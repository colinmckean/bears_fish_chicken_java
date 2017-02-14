import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.*;

public class BearTest {

  Bear bear;
  Salmon salmon;
  Human human;
  Chicken chicken;

  @Before 
  public void before() {
    bear = new Bear("Baloo");
    human = new Human();
    salmon = new Salmon();
    chicken = new Chicken();
  }

  @Test
  public void hasName(){
    assertEquals("Baloo", bear.getName());
  }

  @Test
  public void bellyStartsEmpty(){
    assertEquals(0, bear.foodCount());
  }

  @Test
  public void canEatSalmon(){
    bear.eat(salmon);
    assertEquals(bear.foodCount(), 1);
  }

  @Test
  public void shouldEmptyBellyAfterSleeping(){
    bear.eat(salmon);
    bear.sleep();
    assertEquals(bear.foodCount(), 0);
  }
  @Test
  public void canEatHuman(){
    bear.eat(human);
    assertEquals(1, bear.foodCount());
  }
  @Test
  public void canThrowUp(){
    bear.eat(salmon);
    Edible food = bear.throwUp();
    assertNotNull(food);
    Salmon original = (Salmon)food;

    assertEquals("swimming", original.swim());
  }  

  @Test
  public void canThrowUpChickens(){
    bear.eat(chicken);
    Edible food = bear.throwUp();
    assertNotNull(food);
    Chicken original = (Chicken)food;

    assertEquals("Cluck cluck, I'm a chicken, alive and well!", original.cluck());
  }
  @Test 
  public void howMuchCals(){
    bear.eat(salmon);
    assertEquals(50,bear.totalNutrition());
    bear.eat(chicken);
    assertEquals(200,bear.totalNutrition());
    bear.eat(human);
    assertEquals(1200, bear.totalNutrition());
    Edible food = bear.throwUp();
    assertEquals(1150, bear.totalNutrition());

  }

}