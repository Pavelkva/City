package test2;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Scanner;

public class Test2 {

  public static void main(String[] args) throws InterruptedException {
  
    Npc andy = new Npc(0, "Andy");
    Npc troll = new Npc(0, "Troll");
    
    Location locUlicka = new Location(1,"Alley");
    Location locNamesti = new Location(0,"Square");
    
    locUlicka.addNpc(troll);
    locNamesti.addNpc(andy);
    locNamesti.addPath(locUlicka);
    locUlicka.addPath(locNamesti);
    
    
    ChoiceEvent trollEvent = new ChoiceEvent(1,"ROOOAAAR!");
    trollEvent.setChoice1(new Choice("Kill it."));
    ChoiceEvent trollEvent2 = new ChoiceEvent(6,"boom");
    trollEvent2.addNpcEvent(new NpcEvent(troll, "Troll(dead)"));
    trollEvent2.addNpcEvent(new NpcEvent(troll));
    trollEvent.getChoice1().addNextChoice(trollEvent2);
    trollEvent.setChoice2(new Choice("Run away!"));
    troll.addChoiceEvent(trollEvent);
    
    ChoiceEvent andyEvent = new ChoiceEvent(0,"Alley! Troll in the Alley!");
    andyEvent.addCondition(trollEvent, 1);
    andyEvent.addCondition(trollEvent, 2);
    andyEvent.setChoice1(new Choice("I will take care of him!"));
    andyEvent.setChoice2(new Choice("Better stay away..."));
    andy.addChoiceEvent(andyEvent);
    
    ChoiceEvent andyEvent1 = new ChoiceEvent(2,"Is dead?");
    andyEvent1.addCondition(trollEvent, 0);
    andyEvent1.setChoice1(new Choice("yes"));
    andyEvent1.setChoice2(new Choice("no"));
    
    ChoiceEvent andyEvent3 = new ChoiceEvent(3,"I must see it");
    andyEvent3.addCondition(trollEvent, 0);
    andyEvent3.addCondition(trollEvent, 1);
    andyEvent3.addNpcEvent(new NpcEvent(andy,"Andy(dead)"));
    andyEvent3.addNpcEvent(new NpcEvent(andy));
    andyEvent3.addNpcEvent(new NpcEvent(andy,locNamesti,true));
    andyEvent3.addNpcEvent(new NpcEvent(andy,locUlicka,false));
    andyEvent1.getChoice1().addNextChoice(andyEvent3);
    
   ChoiceEvent andyEvent4 = new ChoiceEvent(4,"I must see it");
   andyEvent4.addCondition(trollEvent, 0);
   andyEvent4.addCondition(trollEvent, 2);
   andyEvent4.addNpcEvent(new NpcEvent(andy,locNamesti,true));
   andyEvent4.addNpcEvent(new NpcEvent(andy,locUlicka,false));
   andyEvent4.addNpcEvent(new NpcEvent(andy));
   ChoiceEvent andyEvent5 = new ChoiceEvent(5,"Thank you!");
   andyEvent4.addNpcEvent(new NpcEvent(andy,andyEvent5));
   andyEvent1.getChoice1().addNextChoice(andyEvent4);
   
    
    andy.addChoiceEvent(andyEvent1);
    
    Player player = new Player();
    player.setLocation(locNamesti);
    
    Storage storage = new Storage();
    PlayerController pControl = new PlayerController(player, storage);

    int choiceNumber;
    int saveNumber;
    ChoiceEvent choiceEvent;

    while (true) {
      System.out.println("########### " + player.getLocation().getName() + " #########");
      System.out.println();
      System.out.println("---npcs---");
      System.out.println();
      choiceNumber = 0;
      for (Npc npc : player.getLocation().getNpcs()) {
        System.out.println(++choiceNumber + ": " + npc.getName());
      }
      saveNumber = choiceNumber;
      System.out.println();
      System.out.println("---paths---");
      System.out.println();
      for (Location location : player.getLocation().getPaths()) {
        System.out.println(++choiceNumber +  ": " + location.getName());
      }
      
      int choice = -1;
      while (!isChoiceInRange(choice,0,choiceNumber-1)) {
        choice = getChoice() -1;
      }
      
      if (choice > saveNumber -1) {
        choice = choice - saveNumber;
        pControl.moveToLocation(player.getLocation().getPaths().get(choice));
      } else {
        Npc npc = player.getLocation().getNpcs().get(choice);
        choiceEvent = pControl.talkToNpc(npc);
        choices(choiceEvent, npc, pControl);
      }

    }
  }



  private static void choices(ChoiceEvent choiceEvent, Npc npc, PlayerController pControl) throws InterruptedException {
    System.out.println("---" + npc.getName() + "---");
    if (choiceEvent != null) {
      System.out.println(choiceEvent.getText());
      int choices = 0;
      Choice choice1 = choiceEvent.getChoice1();
      Choice choice2 = choiceEvent.getChoice2();
      if (choice1 != null) {
        System.out.println("1: " + choice1.getText());
        choices++;
      }
      if (choice2 != null) {
      System.out.println("2: " + choice2.getText());
        choices++;
      }
      int choice = -1;
      if (choices > 0) {  
        while (!isChoiceInRange(choice, 1, choices)) {
          choice = getChoice();
        }
      }
      ChoiceEvent nextChoiceEvent = null;      
      if (choice == 1) {
        choiceEvent.setChoiced(1);
        nextChoiceEvent = pControl.talkToNpc(choiceEvent.getChoice1());
      } else if (choice == 2) {
        choiceEvent.setChoiced(2);
        nextChoiceEvent = pControl.talkToNpc(choiceEvent.getChoice2());
      }
      
      if (nextChoiceEvent != null) {
        for (NpcEvent npcEvent : nextChoiceEvent.getNpcEvents()) {
          npcEvent.runEvent();
        }
        choices(nextChoiceEvent, npc, pControl);
      } else {
        Thread.sleep(2000);
      }

    }

  }

  private static int getChoice() {
    boolean choiceOk = false;
    int choice = 0;
    while (!choiceOk) {
      try {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        choice = Integer.parseInt(s);
        choiceOk = true;
      } catch (Exception ex) {
        System.out.println("number requested");
        choiceOk = false;
      }
    }
     
    return choice;
  }
  
  private static boolean isChoiceInRange(int choice, int min, int max) {
    return choice >= min && choice <= max;
  }
  
}

