package test2;

 public class NpcEvent {
  
   enum Event {
     MoveToLocation,
     RemoveFromLocation,
     RemoveAllChoiceEvents,
     AddChoiceEvent,
     Rename;
     
   }
   
  private int id;
  private Npc npc;
  private String newName;
  private Location location;
  private Event event;
  private ChoiceEvent choiceEvent;
  
  /**
   * Add or delete npc from location.
   * @param npc
   * @param location 
   */
  NpcEvent(Npc npc, Location location, boolean remove) {
    if (remove == true) {
      event = Event.RemoveFromLocation;
    } else {
      event = Event.MoveToLocation;
    }
    this.location = location;
    this.npc = npc;
  }
  
  /**
   * Move npc to location
   * @param npc
   * @param location 
   */
  NpcEvent(Npc npc, Location location) {
    this.location = location;
    this.npc = npc;
    event = Event.MoveToLocation;
  }
  
  NpcEvent(Npc npc, String name) {
    event = Event.Rename;
    this.npc = npc;
    newName = name;
  }
  
  NpcEvent(Npc npc) {
    this.npc = npc;
    event = Event.RemoveAllChoiceEvents;
  }
  
  NpcEvent(Npc npc, ChoiceEvent choiceEvent) {
    event = Event.AddChoiceEvent;
    this.npc = npc;
    this.choiceEvent = choiceEvent;
  }

  public void runEvent() {
    if (event == Event.MoveToLocation) {
      location.addNpc(npc);
    } else if (event == Event.RemoveFromLocation) {
      location.removeNpc(npc);
    } else if (event == Event.Rename) {
      npc.setName(newName);
    } else if (event == Event.RemoveAllChoiceEvents) {
      npc.getChoiceEvents().clear();
    } else if (event == Event.AddChoiceEvent) {
      npc.addChoiceEvent(choiceEvent);
    } 
  }
  
}