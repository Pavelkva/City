package test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChoiceEvent {

  private int id;
  private int choiced;
  private String text;
  private Choice choice1;
  private Choice choice2;
  private List<ChoiceCondition> conditions;
  private List<NpcEvent> npcEvents;
  
  public ChoiceEvent(int id) {
    this.text = "";
    this.id = id;
    choiced = 0;
    conditions = new ArrayList<ChoiceCondition>();
    npcEvents = new ArrayList<NpcEvent>();
    
  }
  
  public ChoiceEvent(int id, String text) {
    this.text = text;
    this.id = id;
    choiced = 0;
    conditions = new ArrayList<ChoiceCondition>();
    npcEvents = new ArrayList<NpcEvent>();
    
  }

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @return the choiced
   */
  public int getChoiced() {
    return choiced;
  }

  /**
   * @param choiced the choiced to set
   */
  public void setChoiced(int choiced) {
    this.choiced = choiced;
  }

  /**
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * @param text the text to set
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * @return the choice1
   */
  public Choice getChoice1() {
    return choice1;
  }

  /**
   * @param choice1 the choice1 to set
   */
  public void setChoice1(Choice choice1) {
    this.choice1 = choice1;
  }

  /**
   * @return the choice2
   */
  public Choice getChoice2() {
    return choice2;
  }

  /**
   * @param choice2 the choice2 to set
   */
  public void setChoice2(Choice choice2) {
    this.choice2 = choice2;
  }

  /**
   * @return the conditions
   */
  public List<ChoiceCondition> getConditions() {
    return conditions;
  }

  /**
   * @param conditions the conditions to set
   */
  public void addCondition(ChoiceCondition choiceCondition) {
    conditions.add(choiceCondition);
  }
  
  public void addCondition(ChoiceEvent choiceEvent, int choiced) {
    conditions.add(new ChoiceCondition(choiceEvent, choiced));
  }
  
  public void addNpcEvent(NpcEvent npcEvent) {
    getNpcEvents().add(npcEvent);
  }
  
  public void removeNpcEvent(NpcEvent npcEvent) {
    getNpcEvents().remove(npcEvent);
  }

  /**
   * @return the npcEvents
   */
  public List<NpcEvent> getNpcEvents() {
    return npcEvents;
  }
  
  
}