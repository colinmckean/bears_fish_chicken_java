public class Human implements Edible, Swimmable{
  public String speak(){
    return "Help I'm being eaten by a bear!";
  }
  public String swim() {
    return "Swim";
  }
  public int nutritionValue(){
    return 1000;
  }
}