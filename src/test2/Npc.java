package test2;

import java.util.ArrayList;
import java.util.List;

public class Npc {

  private int id;
  private String name;
  private List<ChoiceEvent> choiceEvents;
  private Location location;

 

  public Npc(int id, String name) {
    this.id = id;
    this.name = name;
    this.choiceEvents = new ArrayList<ChoiceEvent>();
  }
  
  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

   /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }
  
  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the choiceEvents
   */
  public List<ChoiceEvent> getChoiceEvents() {
    return choiceEvents;
  }
  
  public void addChoiceEvent(ChoiceEvent choiceEvent) {
    choiceEvents.add(choiceEvent);
  }

  /**
   * @return the location
   */
  public Location getLocation() {
    return location;
  }

  /**
   * @param location the location to set
   */
  public void setLocation(Location location) {
    this.location = location;
  }

}