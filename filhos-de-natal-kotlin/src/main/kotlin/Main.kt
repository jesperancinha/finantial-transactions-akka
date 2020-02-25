import JBakerHelper.createIngredient
import JBakerHelper.createInteraction
import JBakerHelper.seq
import com.ing.baker.compiler.RecipeCompiler.compileRecipe
import com.ing.baker.il.CompiledRecipe
import com.ing.baker.recipe.common.Ingredient
import com.ing.baker.recipe.scaladsl.Event
import com.ing.baker.recipe.scaladsl.Interaction
import com.ing.baker.recipe.scaladsl.Recipe

fun main() {

    val flower: Ingredient = createIngredient("500 g of flower")
    val sugar: Ingredient = createIngredient("4 sugar spoon")
    val yeast: Ingredient = createIngredient("1 teaspoon of yeast")
    val salt: Ingredient = createIngredient("1 coffee spoon of salt")
    val dough: Ingredient = createIngredient("Dough")
    val doughShapped: Ingredient = createIngredient("Dough concavely shapped")
    val kneadedDough: Ingredient = createIngredient("Kneaded dough")
    val laydeDoughFor5Hours: Ingredient = createIngredient("Dough rested for 5 to 6 hours")
    val doughInStrips: Ingredient = createIngredient("Dough flat in strips")
    val doughInSmallShapes: Ingredient = createIngredient("Dough cut down in shapes")
    val friedFilhos: Ingredient = createIngredient("Fried filhós")
    val eggyolk: Ingredient = createIngredient("4 egg yolk")
    val semiSkimmedMilk: Ingredient = createIngredient("1 dl of semi skimmed milk")
    val whiteWine: Ingredient = createIngredient("0.5 dl white wine")
    val meltedButter: Ingredient = createIngredient("60 g of melted butter")
    val sunFlowerOil: Ingredient = createIngredient("1 Lt of sunflower oil")
    val fineSugar: Ingredient = createIngredient("2 spoons of fine sugar")

    val doughEvent: com.ing.baker.recipe.common.Event = Event.apply("Dough", seq(dough))
    val doughMixAndFormEvent: com.ing.baker.recipe.common.Event = Event.apply("Dough changed and transformed into a concave form", seq(doughShapped))
    val doughKneadedEvent: com.ing.baker.recipe.common.Event = Event.apply("Kneaded dough", seq(kneadedDough))
    val doughLayedEvent: com.ing.baker.recipe.common.Event = Event.apply("Layed dough for 5 hours", seq(laydeDoughFor5Hours))
    val doughInStripsEvent: com.ing.baker.recipe.common.Event = Event.apply("Flattened dough in strips", seq(doughInStrips))
    val doughInSmallShapesEvent: com.ing.baker.recipe.common.Event = Event.apply("Cutted dough down in small shapes", seq(doughInSmallShapes))
    val friedFilhosEvent: com.ing.baker.recipe.common.Event = Event.apply("Filhos fried", seq(friedFilhos))

    val interaction: Interaction = createInteraction("Make it happen", flower, doughEvent)
    val filhosDeNatal: Recipe = Recipe.apply("Filhós de Natal", seq(interaction), JBakerHelper.set(doughEvent), null, scala.Option.empty(), scala.Option.empty())

    val compileRecipe: CompiledRecipe = compileRecipe(filhosDeNatal)

    println(compileRecipe.recipeVisualization)
}

