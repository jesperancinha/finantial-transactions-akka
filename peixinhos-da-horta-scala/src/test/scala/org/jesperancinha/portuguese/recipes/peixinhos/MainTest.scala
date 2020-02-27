package org.jesperancinha.portuguese.recipes.peixinhos

import akka.actor.ActorSystem
import com.ing.baker.compiler.RecipeCompiler
import com.ing.baker.runtime.scaladsl.{Baker, EventInstance}
import com.ing.baker.types.PrimitiveValue
import org.jesperancinha.portuguese.recipes.peixinhos.RecipeImplementation._
import org.jesperancinha.portuguese.recipes.peixinhos.Recipes._
import org.scalatest.BeforeAndAfter
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.language.postfixOps

class MainTest extends AnyFlatSpec with Matchers with BeforeAndAfter{

  implicit val actorSystem: ActorSystem = ActorSystem("peixinhosDaHorta")
  implicit val timeout: FiniteDuration = 2.seconds

  "A peixinhos da horta recipe" should "compile and validate" in {
    val compileRecipe = RecipeCompiler.compileRecipe(peixinhosDaHortaRecipe)

    compileRecipe.validationErrors should be('empty)

    println(compileRecipe.getRecipeVisualization);
  }

  "Baking a peixinhos da horta recipe fire event only when received and don't wait" should "start baking it but stop in the middle" in {
    val compileRecipe = RecipeCompiler.compileRecipe(peixinhosDaHortaRecipe)

    compileRecipe.validationErrors should be('empty)

    val baker: Baker = Baker.akkaLocalDefault(actorSystem)

    baker.registerEventListener((_, event) => TaskSimulator.waitMilliseconds(event.name, 10))

    val program: Future[Unit] = for {
      _ <- baker.addInteractionInstances(Seq(
        setupCookingTableInstanceForBeansInteraction, setupCookingTableInstanceForBatterInteraction, cookBeansInstance, cutPodsInHalfInstance, washBeansInstance,
        drainBeansInstance, fryPodsInstance, passPodsThroughBatterInstance, makeBatterInstance,
        seasonBatterInstance, removeBeanThreadInstance, addColdWaterInstance))
      recipeId <- baker.addRecipe(compileRecipe)
      _ <- baker.bake(recipeId, "recipe-instance-id-received-no-wait")
      _ <- baker.fireEventAndResolveWhenReceived("recipe-instance-id-received-no-wait", EventInstance(name = Recipes.dinnerTime.name))
      familyHungryEvent = new EventInstance(name = Recipes.familyIsHungry.name, providedIngredients = Map(
        greenBeans.name -> PrimitiveValue("The good kind"),
        salt.name -> PrimitiveValue("The good kind"),
        flower.name -> PrimitiveValue("The good kind"),
        egg.name -> PrimitiveValue("The good kind"),
        pepper.name -> PrimitiveValue("The good kind"),
        oliveOil.name -> PrimitiveValue("The good kind"),
        water.name -> PrimitiveValue("The good kind")
      ))
      _ <- baker.fireEventAndResolveWhenReceived("recipe-instance-id-received-no-wait", familyHungryEvent)
    } yield ()

    val unit: Unit = Await.result(program, 5 seconds)
    val completeGraph = Await.result(baker.getVisualState("recipe-instance-id-received-no-wait"), 5 seconds)
    println(unit)
    println(completeGraph)
  }

  "Baking a peixinhos da horta recipe fire event after interaction completion and don't wait" should "complete baking it" in {
    val compileRecipe = RecipeCompiler.compileRecipe(peixinhosDaHortaRecipe)

    compileRecipe.validationErrors should be('empty)

    val baker: Baker = Baker.akkaLocalDefault(actorSystem)

    baker.registerEventListener((recipeId, event) => TaskSimulator.waitMilliseconds(event.name + recipeId, 10))

    val program: Future[Unit] = for {
      _ <- baker.addInteractionInstances(Seq(
        setupCookingTableInstanceForBeansInteraction, setupCookingTableInstanceForBatterInteraction,
        cookBeansInstance, cutPodsInHalfInstance, washBeansInstance,
        drainBeansInstance, fryPodsInstance, passPodsThroughBatterInstance, makeBatterInstance,
        seasonBatterInstance, removeBeanThreadInstance, addColdWaterInstance))
      recipeId <- baker.addRecipe(compileRecipe)
      _ <- baker.bake(recipeId, "recipe-instance-id-complete-no-wait")
      _ <- baker.fireEventAndResolveWhenCompleted("recipe-instance-id-complete-no-wait", EventInstance(name = Recipes.dinnerTime.name))
      familyHungryEvent = new EventInstance(name = Recipes.familyIsHungry.name, providedIngredients = Map(
        greenBeans.name -> PrimitiveValue("The good kind"),
        salt.name -> PrimitiveValue("The good kind"),
        flower.name -> PrimitiveValue("The good kind"),
        egg.name -> PrimitiveValue("The good kind"),
        pepper.name -> PrimitiveValue("The good kind"),
        oliveOil.name -> PrimitiveValue("The good kind"),
        water.name -> PrimitiveValue("The good kind")
      ))
      _ <- baker.fireEventAndResolveWhenCompleted("recipe-instance-id-complete-no-wait", familyHungryEvent)
    } yield ()

    val unit: Unit = Await.result(program, 5 seconds)
    val completeGraph = Await.result(baker.getVisualState("recipe-instance-id-complete-no-wait"), 10 seconds)

    println(unit)
    println(completeGraph)
  }

  "Baking a peixinhos da horta recipe fire event only when received and wait 3 seconds " should "complete baking it" in {
    val compileRecipe = RecipeCompiler.compileRecipe(peixinhosDaHortaRecipe)

    compileRecipe.validationErrors should be('empty)

    val baker: Baker = Baker.akkaLocalDefault(actorSystem)

    baker.registerEventListener((_, event) => TaskSimulator.waitMilliseconds(event.name, 10))

    val program: Future[Unit] = for {
      _ <- baker.addInteractionInstances(Seq(
        setupCookingTableInstanceForBeansInteraction, setupCookingTableInstanceForBatterInteraction, cookBeansInstance, cutPodsInHalfInstance, washBeansInstance,
        drainBeansInstance, fryPodsInstance, passPodsThroughBatterInstance, makeBatterInstance,
        seasonBatterInstance, removeBeanThreadInstance, addColdWaterInstance))
      recipeId <- baker.addRecipe(compileRecipe)
      _ <- baker.bake(recipeId, "recipe-instance-id-received-wait")
      _ <- baker.fireEventAndResolveWhenReceived("recipe-instance-id-received-wait", EventInstance(name = Recipes.dinnerTime.name))
      familyHungryEvent = new EventInstance(name = Recipes.familyIsHungry.name, providedIngredients = Map(
        greenBeans.name -> PrimitiveValue("The good kind"),
        salt.name -> PrimitiveValue("The good kind"),
        flower.name -> PrimitiveValue("The good kind"),
        egg.name -> PrimitiveValue("The good kind"),
        pepper.name -> PrimitiveValue("The good kind"),
        oliveOil.name -> PrimitiveValue("The good kind"),
        water.name -> PrimitiveValue("The good kind")
      ))
      _ <- baker.fireEventAndResolveWhenReceived("recipe-instance-id-received-wait", familyHungryEvent)
    } yield ()

    Thread.sleep(3000)
    val unit: Unit = Await.result(program, 5 seconds)
    val completeGraph = Await.result(baker.getVisualState("recipe-instance-id-received-wait"), 5 seconds)
    println(unit)
    println(completeGraph)
  }

  "Baking a peixinhos da horta recipe fire event after interaction completion and wait 3 seconds" should "complete baking it" in {
    val compileRecipe = RecipeCompiler.compileRecipe(peixinhosDaHortaRecipe)

    compileRecipe.validationErrors should be('empty)

    val baker: Baker = Baker.akkaLocalDefault(actorSystem)

    baker.registerEventListener((recipeId, event) => TaskSimulator.waitMilliseconds(event.name + recipeId, 10))

    val program: Future[Unit] = for {
      _ <- baker.addInteractionInstances(Seq(
        setupCookingTableInstanceForBeansInteraction, setupCookingTableInstanceForBatterInteraction,
        cookBeansInstance, cutPodsInHalfInstance, washBeansInstance,
        drainBeansInstance, fryPodsInstance, passPodsThroughBatterInstance, makeBatterInstance,
        seasonBatterInstance, removeBeanThreadInstance, addColdWaterInstance))
      recipeId <- baker.addRecipe(compileRecipe)
      _ <- baker.bake(recipeId, "recipe-instance-id-complete-wait")
      _ <- baker.fireEventAndResolveWhenCompleted("recipe-instance-id-complete-wait", EventInstance(name = Recipes.dinnerTime.name))
      familyHungryEvent = new EventInstance(name = Recipes.familyIsHungry.name, providedIngredients = Map(
        greenBeans.name -> PrimitiveValue("The good kind"),
        salt.name -> PrimitiveValue("The good kind"),
        flower.name -> PrimitiveValue("The good kind"),
        egg.name -> PrimitiveValue("The good kind"),
        pepper.name -> PrimitiveValue("The good kind"),
        oliveOil.name -> PrimitiveValue("The good kind"),
        water.name -> PrimitiveValue("The good kind")
      ))
      _ <- baker.fireEventAndResolveWhenCompleted("recipe-instance-id-complete-wait", familyHungryEvent)
    } yield ()


    Thread.sleep(3000);
    val unit: Unit = Await.result(program, 5 seconds)
    val completeGraph = Await.result(baker.getVisualState("recipe-instance-id-complete-wait"), 10 seconds)

    println(unit)
    println(completeGraph)
  }
}
