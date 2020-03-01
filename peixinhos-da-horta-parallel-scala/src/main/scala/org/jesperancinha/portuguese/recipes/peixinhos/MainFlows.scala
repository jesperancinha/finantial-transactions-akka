package org.jesperancinha.portuguese.recipes.peixinhos

import com.ing.baker.compiler.RecipeCompiler
import org.jesperancinha.portuguese.recipes.peixinhos.Recipes._

object MainFlows extends App {
  val compileRecipe = RecipeCompiler.compileRecipe(peixinhosDaHortaRecipe)
  println(compileRecipe.getRecipeVisualization)
}
