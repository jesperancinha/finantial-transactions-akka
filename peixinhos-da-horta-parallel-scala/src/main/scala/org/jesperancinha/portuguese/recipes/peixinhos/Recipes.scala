package org.jesperancinha.portuguese.recipes.peixinhos

import com.ing.baker.recipe.common.InteractionFailureStrategy
import com.ing.baker.recipe.scaladsl.{Event, Ingredient, Interaction, Recipe}

object Recipes {

  val greenBeans: Ingredient[String] = Ingredient[String]("500 g of green beans")
  val greenBeansOnTable: Ingredient[String] = Ingredient[String]("500 g of green beans on table")
  val greenBeansWashed: Ingredient[String] = Ingredient[String]("Washed green beans")
  val greenBeansThreadRemoved: Ingredient[String] = Ingredient[String]("Green beans with no Thread")
  val halfPods: Ingredient[String] = Ingredient[String]("Half pods")
  val cookedBeans: Ingredient[String] = Ingredient[String]("Cooked beans")
  val drainedBeans: Ingredient[String] = Ingredient[String]("Drained beans")
  val batteredPods: Ingredient[String] = Ingredient[String]("Battered pods")
  val salt: Ingredient[String] = Ingredient[String]("A pinch of salt")
  val flower: Ingredient[String] = Ingredient[String]("100 g of flower")
  val egg: Ingredient[String] = Ingredient[String]("One egg")
  val pepper: Ingredient[String] = Ingredient[String]("Pepper")
  val oliveOil: Ingredient[String] = Ingredient[String]("Olive Oil")

  val batter: Ingredient[String] = Ingredient[String]("Batter")
  val batterWithEggs: Ingredient[String] = Ingredient[String]("Batter with eggs")
  val batterWithSaltAndPepper: Ingredient[String] = Ingredient[String]("Batter with salt and pepper")
  val batterWithColdWater: Ingredient[String] = Ingredient[String]("Batter with cold water")
  val water: Ingredient[String] = Ingredient[String]("Water")
  val peixinhosDaHorta: Ingredient[String] = Ingredient[String]("Peixinhos da Horta")

  val startBeans: Event = Event("Start Beans", greenBeans, salt, flower, egg, pepper, oliveOil, water).withMaxFiringLimit(1)
  val startBatter: Event = Event("Start Batter", greenBeans, salt, flower, egg, pepper, oliveOil, water).withMaxFiringLimit(1)

  val cookingTableDoneForBeans: Event = Event("Cooking Table Setup for Beans", greenBeansOnTable).withMaxFiringLimit(1)
  val cookingTableDoneForBatter: Event = Event("Cooking Table Setup for Batter", egg, flower).withMaxFiringLimit(1)
  val beansWashed: Event = Event("Beans washed", greenBeansWashed).withMaxFiringLimit(1)
  val removedBeanThread: Event = Event("Beans thread removed", greenBeansThreadRemoved).withMaxFiringLimit(1)
  val podsAreCutInHalf: Event = Event("Pods are cut in half", halfPods).withMaxFiringLimit(1)
  val beansAreCooked: Event = Event("Beans are cooked", cookedBeans).withMaxFiringLimit(1)
  val beansDrained: Event = Event("Beans are drained from any water", drainedBeans).withMaxFiringLimit(1)
  val flowerWithEggsMixed: Event = Event("Flower with eggs mixed", batterWithEggs).withMaxFiringLimit(1)
  val mixIsSeasoned: Event = Event("Seasoned with salt and pepper", batterWithSaltAndPepper).withMaxFiringLimit(1)
  val moreColdWaterAdded: Event = Event("Cold water added", batterWithColdWater).withMaxFiringLimit(1)
  val passedPodsThroughBatter: Event = Event("Passed pods through batter", batteredPods).withMaxFiringLimit(1)
  val podsAreFried: Event = Event("Pods are fried", peixinhosDaHorta).withMaxFiringLimit(1)

  val setupCookingTableForBeans: Interaction = Interaction("Setup Cooking Table for Beans",
    Seq(greenBeans, salt, flower, egg, pepper, oliveOil, water), output = Seq(cookingTableDoneForBeans))
    .withRequiredEvents(startBeans)

  val setupCookingTableForBatter: Interaction = Interaction("Setup Cooking Table for batter",
    Seq(greenBeans, salt, flower, egg, pepper, oliveOil, water), output = Seq(cookingTableDoneForBatter))
    .withRequiredEvents(startBatter)

  val washBeans: Interaction = Interaction("Washing up Beans",
    Seq(greenBeansOnTable), output = Seq(beansWashed))

  val removeBeanThread: Interaction = Interaction("Remove Bean Thread", Seq(greenBeansWashed),
    output = Seq(removedBeanThread))

  val cutPodInHalf: Interaction = Interaction("Cut pods in half",
    Seq(greenBeansThreadRemoved),
    output = Seq(podsAreCutInHalf))

  val cookBeans: Interaction = Interaction("Cook beans", Seq(halfPods), output = Seq(beansAreCooked))

  val drainBeans: Interaction = Interaction("Drain beans", Seq(cookedBeans), output = Seq(beansDrained))

  val makeBatter: Interaction = Interaction("Mix flower with eggs",
    Seq(egg, flower), output = Seq(flowerWithEggsMixed))
    .withRequiredEvent(cookingTableDoneForBatter)

  val seasonBatter: Interaction = Interaction("Season Mix",
    Seq(batterWithEggs), output = Seq(mixIsSeasoned))

  val addColdWater: Interaction = Interaction("Batter with more water",
    Seq(batterWithSaltAndPepper, water), output = Seq(moreColdWaterAdded))

  val passPodsThroughBatter: Interaction = Interaction("Pass pods through batter",
    Seq(drainedBeans, batterWithColdWater), output = Seq(passedPodsThroughBatter))

  val fryPods: Interaction = Interaction("Fry pods",
    Seq(batteredPods), output = Seq(podsAreFried))

  val peixinhosDaHortaRecipe: Recipe = Recipe("Peixinhos da Horta Recipe")
    .withInteractions(
      setupCookingTableForBeans,
      setupCookingTableForBatter, washBeans, removeBeanThread,
      cutPodInHalf, cookBeans, drainBeans,
      makeBatter, seasonBatter, addColdWater,
      passPodsThroughBatter, fryPods
    )
    .withSensoryEvents(startBeans, startBatter)
    .withDefaultFailureStrategy(
      InteractionFailureStrategy.FireEventAfterFailure(Option.apply("ooops")))
}
