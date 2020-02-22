package org.jesperancinha.portuguese.recipes.peixinhos

import akka.actor.ActorSystem
import com.ing.baker.compiler.RecipeCompiler
import com.ing.baker.runtime.scaladsl.{Baker, EventInstance}
import com.ing.baker.types.PrimitiveValue
import org.jesperancinha.portuguese.recipes.peixinhos.Recipes.{greenBeans, _}
import org.jesperancinha.portuguese.recipes.peixinhos.Recipes
import org.scalatest.Matchers
import org.scalatest.flatspec.AnyFlatSpec

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.language.postfixOps

class MainTest extends AnyFlatSpec with Matchers {

  implicit val actorSystem = ActorSystem("peixinhosDaHorta")
  implicit val timeout: FiniteDuration = 2.seconds

  "A peixinhos da horta recipe" should "compile and validate" in {
    val compileRecipe = RecipeCompiler.compileRecipe(peixinhosDaHortaRecipe)

    compileRecipe.validationErrors should be('empty)

    println(compileRecipe.getRecipeVisualization);
  }

  "Baking a peixinhos da horta recipe" should "complete baking it" in {
    val compileRecipe = RecipeCompiler.compileRecipe(peixinhosDaHortaRecipe)

    compileRecipe.validationErrors should be('empty)

    implicit val actorSystem: ActorSystem =
      ActorSystem("PeixinhosDaHortaSystem")

    val baker: Baker = Baker.akkaLocalDefault(actorSystem)

    val program: Future[Unit] = for {
      _ <- baker.addInteractionInstances(Seq(
        setupCookingTableInstanceForBeans, setupCookingTableInstanceForBatter,
        cookBeansInstance, cutPodsInHalfInstance, washBeansInstance,
        drainBeansInstance, fryPodsInstance, passPodsThroughBatterInstance, makeBatterInstance,
        seasonBatterInstance, removeBeanThreadInstance, addColdWaterInstance))
      recipeId <- baker.addRecipe(compileRecipe)
      _ <- baker.bake(recipeId, "recipe-instance-id")
      _ <- baker.fireEventAndResolveWhenCompleted("recipe-instance-id", EventInstance(name = Recipes.dinnerTime.name))
      familyHungryEvent = new EventInstance(name = Recipes.familyIsHungry.name, providedIngredients = Map(
        greenBeans.name -> PrimitiveValue("The good kind"),
        salt.name -> PrimitiveValue("The good kind"),
        flower.name -> PrimitiveValue("The good kind"),
        egg.name -> PrimitiveValue("The good kind"),
        pepper.name -> PrimitiveValue("The good kind"),
        oliveOil.name -> PrimitiveValue("The good kind"),
        water.name -> PrimitiveValue("The good kind")
      ))
      _ <- baker.fireEventAndResolveWhenCompleted("recipe-instance-id", familyHungryEvent)
    } yield ()


    val unit: Unit = Await.result(program, 15 seconds)
    val completeGraph = Await.result(baker.getVisualState("recipe-instance-id"), 10  seconds)

    println(unit)
    println(completeGraph)
  }
  "Baking a peixinhos da horta recipe" should "start baking it" in {
    val compileRecipe = RecipeCompiler.compileRecipe(peixinhosDaHortaRecipe)

    compileRecipe.validationErrors should be('empty)

    implicit val actorSystem: ActorSystem =
      ActorSystem("PeixinhosDaHortaSystem")

    val baker: Baker = Baker.akkaLocalDefault(actorSystem)

    val program: Future[Unit] = for {
      _ <- baker.addInteractionInstances(Seq(
        setupCookingTableInstanceForBeans, setupCookingTableInstanceForBatter, cookBeansInstance, cutPodsInHalfInstance, washBeansInstance,
        drainBeansInstance, fryPodsInstance, passPodsThroughBatterInstance, makeBatterInstance,
        seasonBatterInstance, removeBeanThreadInstance, addColdWaterInstance))
      recipeId <- baker.addRecipe(compileRecipe)
      _ <- baker.bake(recipeId, "recipe-instance-id")
      familyHungryEvent = new EventInstance(name = Recipes.familyIsHungry.name, providedIngredients = Map(
        greenBeans.name -> PrimitiveValue("The good kind"),
        salt.name -> PrimitiveValue("The good kind"),
        flower.name -> PrimitiveValue("The good kind"),
        egg.name -> PrimitiveValue("The good kind"),
        pepper.name -> PrimitiveValue("The good kind"),
        oliveOil.name -> PrimitiveValue("The good kind"),
        water.name -> PrimitiveValue("The good kind")
      ))
      _ <- baker.fireEventAndResolveWhenReceived("recipe-instance-id", EventInstance(name = Recipes.dinnerTime.name))
      _ <- baker.fireEventAndResolveWhenReceived("recipe-instance-id", familyHungryEvent)
    } yield ()

    val unit: Unit = Await.result(program, 5 seconds)

    val completeGraph = Await.result(baker.getVisualState("recipe-instance-id"), 5 seconds)
    println(unit)
    println(completeGraph)
  }

}
