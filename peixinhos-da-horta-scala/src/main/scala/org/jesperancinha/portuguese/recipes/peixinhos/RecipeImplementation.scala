package org.jesperancinha.portuguese.recipes.peixinhos

import com.ing.baker.runtime.scaladsl.{EventInstance, IngredientInstance, InteractionInstance}
import com.ing.baker.types.{CharArray, PrimitiveValue}
import org.jesperancinha.portuguese.recipes.peixinhos.Recipes._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object RecipeImplementation {

  val setupCookingTableInstanceForBeansInteraction: InteractionInstance = InteractionInstance(
    name = setupCookingTableForBeans.name,
    input = Seq(CharArray, CharArray, CharArray, CharArray, CharArray, CharArray, CharArray),
    run = handleCookingTableForBeansSetup
  )

  val setupCookingTableInstanceForBatterInteraction: InteractionInstance = InteractionInstance(
    name = setupCookingTableForBatter.name,
    input = Seq(CharArray, CharArray, CharArray, CharArray, CharArray, CharArray, CharArray),
    run = handleCookingTableForBatterSetup
  )

  def handleCookingTableForBeansSetup(input: Seq[IngredientInstance]): Future[Option[EventInstance]] = {
    Future {
      Option.apply(new EventInstance(name = cookingTableDoneForBeans.name, providedIngredients = Map(
        greenBeansOnTable.name -> PrimitiveValue("Fresh beans")
      ))).orElse(null)
    }
  }

  def handleCookingTableForBatterSetup(input: Seq[IngredientInstance]): Future[Option[EventInstance]] = {
    Future {
      Option.apply(new EventInstance(name = cookingTableDoneForBatter.name, providedIngredients = Map(
        egg.name -> PrimitiveValue("A good egg"),
        flower.name -> PrimitiveValue("The finest flower")
      ))).orElse(null)
    }
  }


  val washBeansInstance: InteractionInstance = InteractionInstance(
    name = washBeans.name,
    input = Seq(CharArray),
    run = handleWashedBeans
  )

  def handleWashedBeans(input: Seq[IngredientInstance]): Future[Option[EventInstance]] = {
    Future {
      Option.apply(new EventInstance(name = beansWashed.name, providedIngredients = Map(greenBeansWashed.name -> PrimitiveValue("Beans washed")))).orElse(null)
    }
  }

  val removeBeanThreadInstance: InteractionInstance = InteractionInstance(
    name = removeBeanThread.name,
    input = Seq(CharArray),
    run = handleBeanThreadRemoval
  )

  def handleBeanThreadRemoval(input: Seq[IngredientInstance]): Future[Option[EventInstance]] = {
    Future {
      Option.apply(new EventInstance(name = removedBeanThread.name, providedIngredients = Map(greenBeansThreadRemoved.name -> PrimitiveValue("Threadless beans")))).orElse(null)
    }
  }

  val cutPodsInHalfInstance: InteractionInstance = InteractionInstance(
    name = cutPodInHalf.name,
    input = Seq(CharArray),
    run = handleCutInHalfPods
  )

  def handleCutInHalfPods(input: Seq[IngredientInstance]): Future[Option[EventInstance]] = {
    Future {
      Option.apply(new EventInstance(name = podsAreCutInHalf.name, providedIngredients = Map(halfPods.name -> PrimitiveValue("Half Pods")))).orElse(null)
    }
  }

  val cookBeansInstance: InteractionInstance = InteractionInstance(
    name = cookBeans.name,
    input = Seq(CharArray),
    run = handleCookBeans
  )

  def handleCookBeans(input: Seq[IngredientInstance]): Future[Option[EventInstance]] = {
    Future {
      Option.apply(new EventInstance(name = beansAreCooked.name, providedIngredients = Map(cookedBeans.name -> PrimitiveValue("Cooked beans")))).orElse(null)
    }
  }

  val drainBeansInstance: InteractionInstance = InteractionInstance(
    name = drainBeans.name,
    input = Seq(CharArray),
    run = handleDrainedBeans
  )

  def handleDrainedBeans(input: Seq[IngredientInstance]): Future[Option[EventInstance]] = {
    Future {
      Option.apply(new EventInstance(name = beansDrained.name, providedIngredients = Map(drainedBeans.name -> PrimitiveValue("Drained Beans!")))).orElse(null)
    }
  }

  val makeBatterInstance: InteractionInstance = InteractionInstance(
    name = makeBatter.name,
    input = Seq(CharArray, CharArray),
    run = handleMakeBatter
  )

  def handleMakeBatter(input: Seq[IngredientInstance]): Future[Option[EventInstance]] = {
    Future {
      Option.apply(new EventInstance(name = flowerWithEggsMixed.name, Map(batterWithEggs.name -> PrimitiveValue("Hand made")))).orElse(null)
    }
  }

  val seasonBatterInstance: InteractionInstance = InteractionInstance(
    name = seasonBatter.name,
    input = Seq(CharArray),
    run = handleBatterSeasoning
  )

  def handleBatterSeasoning(input: Seq[IngredientInstance]): Future[Option[EventInstance]] = {
    Future {
      Option.apply(new EventInstance(name = mixIsSeasoned.name, providedIngredients = Map(batterWithSaltAndPepper.name -> PrimitiveValue("Batter Home Seasoned")))).orElse(null)
    }
  }

  val addColdWaterInstance: InteractionInstance = InteractionInstance(
    name = addColdWater.name,
    input = Seq(CharArray, CharArray),
    run = handleAddColdWater
  )

  def handleAddColdWater(input: Seq[IngredientInstance]): Future[Option[EventInstance]] = {
    Future {
      Option.apply(new EventInstance(name = moreColdWaterAdded.name, providedIngredients = Map(
        batterWithColdWater.name -> PrimitiveValue("Better With Cold Watter"),
      ))).orElse(null)
    }
  }

  val passPodsThroughBatterInstance: InteractionInstance = InteractionInstance(
    name = passPodsThroughBatter.name,
    input = Seq(CharArray, CharArray),
    run = handlePassPods
  )

  def handlePassPods(input: Seq[IngredientInstance]): Future[Option[EventInstance]] = {
    Future {
      Option.apply(new EventInstance(name = passedPodsThroughBatter.name,
        providedIngredients = Map(batteredPods.name -> PrimitiveValue("Pods with Batter")))).orElse(null)
    }
  }

  val fryPodsInstance: InteractionInstance = InteractionInstance(
    name = fryPods.name,
    input = Seq(CharArray),
    run = handeFryPods
  )

  def handeFryPods(input: Seq[IngredientInstance]): Future[Option[EventInstance]] = {
    Future {
      Option.apply(new EventInstance(name = podsAreFried.name, providedIngredients =
        Map(peixinhosDaHorta.name -> PrimitiveValue("Peixinhos da Horta")))).orElse(null)
    }
  }
}
