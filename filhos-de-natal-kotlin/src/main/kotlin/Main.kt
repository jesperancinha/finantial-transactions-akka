import JBakerHelper.createIngredient
import com.ing.baker.il.CompiledRecipe
import com.ing.baker.recipe.common.Ingredient
import com.ing.baker.recipe.scaladsl.Interaction
import com.ing.baker.recipe.scaladsl.Recipe

fun main() {

    val flower: Ingredient = createIngredient("500 g of flower")
    val sugar: Ingredient = createIngredient("4 sugar spoon")
    val yeast: Ingredient = createIngredient("1 teaspoon of yeast")
    val salt: Ingredient = createIngredient("1 coffee spoon of salt")
    val eggyolk: Ingredient = createIngredient("4 egg yolk")
    val semiSkimmedMilk: Ingredient = createIngredient("1 dl of semi skimmed milk")
    val whiteWine: Ingredient = createIngredient("0.5 dl white wine")
    val meltedButter: Ingredient = createIngredient("60 g of melted butter")
    val sunFlowerOil: Ingredient = createIngredient("1 Lt of sunflower oil")
    val fineSugar: Ingredient = createIngredient("2 spoons of fine sugar")

    val event: com.ing.baker.recipe.common.Event = com.ing.baker.recipe.scaladsl.Event.apply("A great event!", JBakerHelper.seq(flower))
    val interaction: Interaction = JBakerHelper.createInteraction("Make it happen", flower, event)
    val filhosDeNatal: Recipe = Recipe.apply("Filhós de Natal", JBakerHelper.seq(interaction), JBakerHelper.set(event), null, scala.Option.empty(), scala.Option.empty())

    val compileRecipe: CompiledRecipe = com.ing.baker.compiler.RecipeCompiler.compileRecipe(filhosDeNatal)

    println(compileRecipe.recipeVisualization)
}

