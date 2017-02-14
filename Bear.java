import java.util.*;

public class Bear {
  private String name;
  private ArrayList<Edible> belly;

  public Bear(String name){
    this.name = name;
    this.belly = new ArrayList<Edible>();
  }

  public String getName(){
    return name;
  }

  public int foodCount(){
    return belly.size();
  }

  public void eat(Edible food){
    belly.add(food);
  }

  public void sleep(){
    belly.clear();
  }
  public Edible throwUp(){
    if(foodCount() > 0){
      return belly.remove(0);
    }
    return null;
  }
  public int totalNutrition(){
    int totalCal = 0;
    for(Edible food : belly){
      totalCal += food.nutritionValue();
    }
    return totalCal;
  }

}