import com.ing.baker.recipe.scaladsl.{Event, Ingredient}

object Main extends App {
  println("Hello, World!");

  val greenBeans = Ingredient[String]("500 g of green beans")
  val salt = Ingredient[String]("A pinch of salt")
  val flower = Ingredient[String]("100 g of flower")
  val egg = Ingredient[String]("One egg")
  val pepper = Ingredient[String]("Pepper")
  val oliveOil = Ingredient[String]("Olive Oil")

  val beansWashed = Event("Beans washed")
  val removeBeanThread = Event("Beans thread removed")
  val cutPodsInHalf = Event("Cut pods in half")
  val beansAreCooked = Event("Beans are cooked")
  val beansDrained = Event("Beans are drained from any water")
  val batterPrepared = Event("Batter is prepared")
  val flowerWithEggsMixed = Event("Flower with eggs mixed")
  val mixIsSeasoned = Event("Seasoned with salt and pepper")
  val moreColdWaterAdded = Event("Cold water added")
  val passedPodsThroughBatter = Event("Passed pods through batter")
  val podsAreFried = Event("Pods are fried")
}