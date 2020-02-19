package test2;

import java.util.ArrayList;
import java.util.List;

public class Choice {

  private int id;
  private String text;
  private List<ChoiceEvent> nextChoices;
  
  public Choice(String text) {
    this.text = text;
    nextChoices = new ArrayList<ChoiceEvent>();
  }
  
  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
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
   * @return the nextChoice
   */
  public List<ChoiceEvent> getNextChoice() {
    return nextChoices;
  }

  /**
   * @param nextChoice the nextChoice to set
   */
  public void addNextChoice(ChoiceEvent nextChoice) {
    nextChoices.add(nextChoice);
  }

  

}