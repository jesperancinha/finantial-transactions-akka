package org.jesperancinha.portuguese.recipes.peixinhos

import akka.actor.ActorSystem
import com.ing.baker.compiler.RecipeCompiler
import com.ing.baker.runtime.scaladsl.{Baker, EventInstance}
import com.ing.baker.types.PrimitiveValue
import org.jesperancinha.portuguese.recipes.peixinhos.RecipeImplementation._
import org.jesperancinha.portuguese.recipes.peixinhos.Recipes._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.language.postfixOps

class MainFlowsTest extends AnyFlatSpec with Matchers {

  implicit val actorSystem: ActorSystem = ActorSystem("peixinhosDaHorta")
  implicit val timeout: FiniteDuration = 2.seconds

  "A peixinhos da horta recipe" should "compile and validate" in {
    val compileRecipe = RecipeCompiler.compileRecipe(peixinhosDaHortaRecipe)

    compileRecipe.validationErrors should be('empty)

    println(compileRecipe.getRecipeVisualization);
  }

  "Baking a peixinhos da horta recipe" should "complete baking it in the most parallel ways possible" in {
    val compileRecipe = RecipeCompiler.compileRecipe(peixinhosDaHortaRecipe)

    compileRecipe.validationErrors should be('empty)

    val baker: Baker = Baker.akkaLocalDefault(actorSystem)

    val program: Future[Unit] = for {
      _ <- baker.addInteractionInstances(Seq(
        setupCookingTableInstanceForBeansInteraction, setupCookingTableInstanceForBatterInteraction,
        cookBeansInstance, cutPodsInHalfInstance, washBeansInstance,
        drainBeansInstance, fryPodsInstance, passPodsThroughBatterInstance, makeBatterInstance,
        seasonBatterInstance, removeBeanThreadInstance, addColdWaterInstance))
      recipeId <- baker.addRecipe(compileRecipe)
      _ <- baker.bake(recipeId, "recipe-instance-id")
      eventInstance  = new EventInstance(name = Recipes.startBeans.name, providedIngredients = Map(
        greenBeans.name -> PrimitiveValue("The good kind"),
        salt.name -> PrimitiveValue("The good kind"),
        flower.name -> PrimitiveValue("The good kind"),
        egg.name -> PrimitiveValue("The good kind"),
        pepper.name -> PrimitiveValue("The good kind"),
        oliveOil.name -> PrimitiveValue("The good kind"),
        water.name -> PrimitiveValue("The good kind")
      ))
      _ <- baker.fireEventAndResolveWhenReceived("recipe-instance-id", eventInstance)
      eventInstance = new EventInstance(name = Recipes.startBatter.name, providedIngredients = Map(
        greenBeans.name -> PrimitiveValue("The good kind"),
        salt.name -> PrimitiveValue("The good kind"),
        flower.name -> PrimitiveValue("The good kind"),
        egg.name -> PrimitiveValue("The good kind"),
        pepper.name -> PrimitiveValue("The good kind"),
        oliveOil.name -> PrimitiveValue("The good kind"),
        water.name -> PrimitiveValue("The good kind")
      ))
      _ <- baker.fireEventAndResolveWhenReceived("recipe-instance-id", eventInstance)
    } yield ()

    Thread.sleep(3000)

    val unit: Unit = Await.result(program, 15 seconds)
    val completeGraph = Await.result(baker.getVisualState("recipe-instance-id"), 10 seconds)

    println(unit)
    println(completeGraph)
  }

  "Baking a peixinhos da horta recipe" should "almost complete baking it but fail in the last interaction" in {
    val compileRecipe = RecipeCompiler.compileRecipe(peixinhosDaHortaRecipe)

    compileRecipe.validationErrors should be('empty)

    val baker: Baker = Baker.akkaLocalDefault(actorSystem)

    val program: Future[Unit] = for {
      _ <- baker.addInteractionInstances(Seq(
        setupCookingTableInstanceForBeansInteraction, setupCookingTableInstanceForBatterInteraction,
        cookBeansInstance, cutPodsInHalfInstance, washBeansInstance,
        drainBeansInstance, fryPodsInstanceFail, passPodsThroughBatterInstance, makeBatterInstance,
        seasonBatterInstance, removeBeanThreadInstance, addColdWaterInstance))
      recipeId <- baker.addRecipe(compileRecipe)
      _ <- baker.bake(recipeId, "recipe-instance-id")
      eventInstance  = new EventInstance(name = Recipes.startBeans.name, providedIngredients = Map(
        greenBeans.name -> PrimitiveValue("The good kind"),
        salt.name -> PrimitiveValue("The good kind"),
        flower.name -> PrimitiveValue("The good kind"),
        egg.name -> PrimitiveValue("The good kind"),
        pepper.name -> PrimitiveValue("The good kind"),
        oliveOil.name -> PrimitiveValue("The good kind"),
        water.name -> PrimitiveValue("The good kind")
      ))
      _ <- baker.fireEventAndResolveWhenReceived("recipe-instance-id", eventInstance)
      eventInstance = new EventInstance(name = Recipes.startBatter.name, providedIngredients = Map(
        greenBeans.name -> PrimitiveValue("The good kind"),
        salt.name -> PrimitiveValue("The good kind"),
        flower.name -> PrimitiveValue("The good kind"),
        egg.name -> PrimitiveValue("The good kind"),
        pepper.name -> PrimitiveValue("The good kind"),
        oliveOil.name -> PrimitiveValue("The good kind"),
        water.name -> PrimitiveValue("The good kind")
      ))
      _ <- baker.fireEventAndResolveWhenReceived("recipe-instance-id", eventInstance)
    } yield ()

    Thread.sleep(3000)

    val unit: Unit = Await.result(program, 15 seconds)
    val completeGraph = Await.result(baker.getVisualState("recipe-instance-id"), 10 seconds)

    println(unit)
    println(completeGraph)
  }
}
