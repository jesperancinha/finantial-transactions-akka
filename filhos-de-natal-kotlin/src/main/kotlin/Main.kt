import JBakerHelper.createIngredient
import JBakerHelper.createInteraction
import JBakerHelper.seq
import JBakerHelper.set
import com.ing.baker.compiler.RecipeCompiler.compileRecipe
import com.ing.baker.il.CompiledRecipe
import com.ing.baker.recipe.common.Ingredient
import com.ing.baker.recipe.scaladsl.Event
import com.ing.baker.recipe.scaladsl.Interaction
import com.ing.baker.recipe.scaladsl.Recipe
import scala.Option.empty

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
    val filhosDeNatal: Ingredient = createIngredient("Filhós de Natal")

    val bakerWentShoppingEvent: com.ing.baker.recipe.common.Event = Event.apply("Baker went shopping", seq(
            flower, sugar, yeast, salt, dough, eggyolk, semiSkimmedMilk, whiteWine, meltedButter, sunFlowerOil, fineSugar))
    val doughEvent: com.ing.baker.recipe.common.Event = Event.apply("Dough has been made", seq(dough))
    val doughMixAndFormEvent: com.ing.baker.recipe.common.Event = Event.apply("Dough changed and transformed into a concave form", seq(doughShapped))
    val doughKneadedEvent: com.ing.baker.recipe.common.Event = Event.apply("Kneaded dough", seq(kneadedDough))
    val doughLayedEvent: com.ing.baker.recipe.common.Event = Event.apply("Layed dough for 5 hours", seq(laydeDoughFor5Hours))
    val doughInStripsEvent: com.ing.baker.recipe.common.Event = Event.apply("Flattened dough in strips", seq(doughInStrips))
    val doughInSmallShapesEvent: com.ing.baker.recipe.common.Event = Event.apply("Cutted dough down in small shapes", seq(doughInSmallShapes))
    val friedFilhosEvent: com.ing.baker.recipe.common.Event = Event.apply("Filhos fried", seq(friedFilhos))
    val filhosDeNatalEvent: com.ing.baker.recipe.common.Event = Event.apply("Filhos covered with fine sugar", seq(filhosDeNatal))

    val bakerShopppinInteraction: Interaction = createInteraction("Baker is shopping", seq(), seq(bakerWentShoppingEvent))
    val mixingDryIngredients: Interaction = createInteraction("Mixing dry dough ingredients", seq(flower, sugar, yeast, salt), seq(doughEvent))
    val makeDoughInConcaveFormInteraction: Interaction = createInteraction("Making dough dried mix into a concave shape", seq(dough, eggyolk, semiSkimmedMilk,
            whiteWine, meltedButter), seq(doughMixAndFormEvent))
    val kneadDoughInteraction: Interaction = createInteraction("Kneading dough until smooth form", seq(doughShapped), seq(doughKneadedEvent))
    val layDoughFor5HoursInteraction: Interaction = createInteraction("Laying dough for 5 to 6 hours", seq(kneadedDough), seq(doughLayedEvent))
    val doughInStripesInteraction: Interaction = createInteraction("Create flat dough strips", seq(laydeDoughFor5Hours), seq(doughInStripsEvent))
    val doughInSmallShapesInteraction: Interaction = createInteraction("Cut dough into small pieces", seq(doughInStrips), seq(doughInSmallShapesEvent))
    val filhosInteraction: Interaction = createInteraction("Fry dough pieces", seq(doughInSmallShapes, sunFlowerOil), seq(friedFilhosEvent))
    val filhosDeNatalInteraction: Interaction = createInteraction("Finishing filhós de natal", seq(friedFilhos, fineSugar), seq(filhosDeNatalEvent))
    val filhosDeNataRecipe: Recipe = Recipe.apply("Filhós de Natal",
            seq(bakerShopppinInteraction,
                    mixingDryIngredients, makeDoughInConcaveFormInteraction, kneadDoughInteraction,
                    layDoughFor5HoursInteraction, doughInStripesInteraction, doughInSmallShapesInteraction,
                    filhosInteraction, filhosDeNatalInteraction),
            set(doughEvent),
            null, empty(), empty())

    val compileRecipe: CompiledRecipe = compileRecipe(filhosDeNataRecipe)

    println(compileRecipe.recipeVisualization)
}

