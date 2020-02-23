class Main

fun main(args: Array<String>) {

    val ingredient: com.ing.baker.recipe.common.Ingredient = JBakerHelper.createIngredient("4 potatoes")
    val event: com.ing.baker.recipe.common.Event = com.ing.baker.recipe.scaladsl.Event.apply("A great event!", JBakerHelper.seq(ingredient))
    val interaction: com.ing.baker.recipe.scaladsl.Interaction = JBakerHelper.createInteraction("Make it happen", ingredient, event)
    val bacalhauABras: com.ing.baker.recipe.scaladsl.Recipe = com.ing.baker.recipe.scaladsl.Recipe.apply("Bacalhau à Brás", JBakerHelper.seq(interaction), JBakerHelper.set(event), null, scala.Option.empty(), scala.Option.empty())

    val compileRecipe: com.ing.baker.il.CompiledRecipe = com.ing.baker.compiler.RecipeCompiler.compileRecipe(bacalhauABras)

    println(compileRecipe.getRecipeVisualization())
}

