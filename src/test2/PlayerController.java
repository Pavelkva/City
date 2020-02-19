package test2;

import java.util.List;
import java.util.Set;


public class PlayerController {

  private Player player;
  private Storage storage;
  
  public PlayerController(Player player, Storage storage) {
    
    this.player = player;
    this.storage = storage;
    
  }
  
  public ChoiceEvent talkToNpc(Npc npc) {
    boolean getEvent = true;
    List<ChoiceEvent> choiceEvents = npc.getChoiceEvents();
    for (ChoiceEvent event : choiceEvents) {
      List<ChoiceCondition> conditionList = event.getConditions();
      if (!conditionList.isEmpty()) {
        for (ChoiceCondition choiceCondition : conditionList) {
          if (choiceCondition.getChoiced() == choiceCondition.getChoiceEvent().getChoiced()) {
            getEvent = false;
            break;
          }
        }
      }
      if (getEvent) {
        return event;
      }
      getEvent = true;
    }
    return null;
  }
  
   public ChoiceEvent talkToNpc(Choice choice) {
    boolean getEvent = true;
    List<ChoiceEvent> choiceEvents = choice.getNextChoice();
    for (ChoiceEvent event : choiceEvents) {
      List<ChoiceCondition> conditionList = event.getConditions();
      if (!conditionList.isEmpty()) {
        for (ChoiceCondition choiceCondition : conditionList) {
          if (choiceCondition.getChoiced() == choiceCondition.getChoiceEvent().getChoiced()) {
            getEvent = false;
            break;
          }
        }
      }
      if (getEvent) {
        return event;
      }
      getEvent = true;
    }
    return null;
  }
  
  public void moveToLocation(Location location) {
    
    player.setLocation(location);
    
  }
  
  public void chooseChoice(ChoiceEvent choiceEvent, int choice) {
    choiceEvent.setChoiced(choice);
  }

}