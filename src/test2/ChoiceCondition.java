package test2;

public class ChoiceCondition {

  private ChoiceEvent choiceEvent;
  private int choiced;
  
  public ChoiceCondition(ChoiceEvent choiceEvent, int choiced) {
    
    this.choiceEvent = choiceEvent;
    this.choiced = choiced;
    
  }

  /**
   * @return the choiceEvent
   */
  public ChoiceEvent getChoiceEvent() {
    return choiceEvent;
  }

  /**
   * @return the choiced
   */
  public int getChoiced() {
    return choiced;
  }

}