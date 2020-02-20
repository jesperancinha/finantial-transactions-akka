package org.jesperancinha.baker.cake

import com.ing.baker.recipe.scaladsl.{Event, Ingredient, Interaction, Recipe}

object Recipes {

  val greenBeans: Ingredient[String] = Ingredient[String]("500 g of green beans")
  val greenBeansWashed: Ingredient[String] = Ingredient[String]("500 g of washed green beans")
  val greenBeansThreadRemoved: Ingredient[String] = Ingredient[String]("500 g of green beans with no Thread")
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
  val water: Ingredient[String] = Ingredient[String]("Water")
  val peixinhosDaHorta: Ingredient[String] = Ingredient[String]("Peixinhos da Horta")


  val dinnerTime: Event = Event("Dinner time")
  val familyIsHungry: Event = Event("Family is hungry")

  val cookingTableDone: Event = new Event("Cooking Table Setup",
    Seq(greenBeans, salt, flower, egg, pepper, oliveOil, water),
    maxFiringLimit = Option(1))
  val beansWashed: Event = Event("Beans washed", greenBeansWashed)
  val removedBeanThread: Event = Event("Beans thread removed", greenBeansThreadRemoved)
  val podsAreCutInHalf: Event = Event("Pods are cut in falf", halfPods)
  val beansAreCooked: Event = Event("Beans are cooked", cookedBeans)
  val beansDrained: Event = Event("Beans are drained from any water", drainedBeans)
  val flowerWithEggsMixed: Event = Event("Flower with eggs mixed")
  val mixIsSeasoned: Event = Event("Seasoned with salt and pepper", batter)
  val moreColdWaterAdded: Event = Event("Cold water added", batter)
  val passedPodsThroughBatter: Event = Event("Passed pods through batter", batteredPods)
  val podsAreFried: Event = Event("Pods are fried", peixinhosDaHorta)


  val setupCookingTable: Interaction = Interaction("Setup Cooking Table",
    Seq(greenBeans, salt, flower, egg, pepper, oliveOil, water), output = Seq(cookingTableDone))
    .withRequiredEvents(dinnerTime, familyIsHungry)

  val washBeans: Interaction = Interaction("Washing up Beans",
    Seq(greenBeans), output = Seq(beansWashed)).withRequiredEvents(cookingTableDone)

  val removeBeanThread: Interaction = Interaction("Remove Bean Thread", Seq(greenBeansWashed), output = Seq(removedBeanThread))
    .withRequiredEvent(beansWashed)

  val cutPodInHalf: Interaction = Interaction("Cut pods in half", Seq(greenBeansThreadRemoved), output = Seq(podsAreCutInHalf))
    .withRequiredEvent(removedBeanThread)

  val cookBeans: Interaction = Interaction("Cook beans", Seq(halfPods), output = Seq(beansAreCooked))
    .withRequiredEvent(podsAreCutInHalf)

  val drainBeans: Interaction = Interaction("Drain beans", Seq(drainedBeans), output = Seq(beansDrained))
    .withRequiredEvent(beansAreCooked)

  val makeBatter: Interaction = Interaction("Mix flower with eggs",
    Seq(egg, flower), output = Seq(flowerWithEggsMixed))

  val seasonBatter: Interaction = Interaction("Season Mix",
    Seq(batter, salt, pepper), output = Seq(mixIsSeasoned))
    .withRequiredEvents(flowerWithEggsMixed)

  val addColdWater: Interaction = Interaction("Batter with more water",
    Seq(batter, water), output = Seq(moreColdWaterAdded))

  val passPodsThroughBatter: Interaction = Interaction("Pass pods through batter",
    Seq(drainedBeans, batter), output = Seq(passedPodsThroughBatter))
    .withRequiredEvents(moreColdWaterAdded, beansDrained)

  val fryPods: Interaction = Interaction("Fry pods",
    Seq(batteredPods), output = Seq(podsAreFried))
    .withRequiredEvents(passedPodsThroughBatter)

  val peixinhosDaHortaRecipe: Recipe = Recipe("Peixinhos da Horta Recipe")
    .withInteractions(setupCookingTable, washBeans, removeBeanThread,
      cutPodInHalf, cookBeans, drainBeans,
      makeBatter, seasonBatter, addColdWater,
      passPodsThroughBatter, fryPods)
    .withSensoryEvents(dinnerTime, familyIsHungry, cookingTableDone,
      beansWashed, removedBeanThread, podsAreCutInHalf,
      beansAreCooked, beansDrained, flowerWithEggsMixed,
      mixIsSeasoned, moreColdWaterAdded, passedPodsThroughBatter, podsAreFried)
}
