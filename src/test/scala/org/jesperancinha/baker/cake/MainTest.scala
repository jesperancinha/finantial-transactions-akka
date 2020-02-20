package org.jesperancinha.baker.cake

import akka.actor.ActorSystem
import akka.stream.{ActorMaterializer, Materializer}
import com.ing.baker.compiler.RecipeCompiler
import com.ing.baker.il.CompiledRecipe
import com.ing.baker.runtime.common.Baker
import com.ing.baker.runtime.scaladsl.Baker
import org.jesperancinha.baker.cake.Recipes.peixinhosDaHortaRecipe
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.concurrent.Future
import scala.concurrent.duration.{FiniteDuration, _}

class MainTest extends AnyFlatSpec with Matchers {

  implicit val actorSystem = ActorSystem("peixinhosDaHorta")
  implicit val timeout: FiniteDuration = 2.seconds

  "A peixinhos da horta recipe" should "compile and validate" in {
    val compileRecipe = RecipeCompiler.compileRecipe(peixinhosDaHortaRecipe)

    compileRecipe.validationErrors should be('empty)

    println(compileRecipe.getRecipeVisualization);
  }

  "Baking a peixinhos da horta recipe" should "bake it" in {
    val compileRecipe = RecipeCompiler.compileRecipe(peixinhosDaHortaRecipe)

    compileRecipe.validationErrors should be('empty)

    println(compileRecipe.getRecipeVisualization)

  }
}
