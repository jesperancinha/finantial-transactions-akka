package org.jesperancinha.portuguese.recipes.bras;

import com.ing.baker.compiler.RecipeCompiler;
import com.ing.baker.il.CompiledRecipe;
import com.ing.baker.recipe.common.Ingredient;
import com.ing.baker.recipe.scaladsl.Event;
import com.ing.baker.recipe.scaladsl.Interaction;
import com.ing.baker.recipe.scaladsl.Recipe;
import scala.Option;

import static org.jesperancinha.portuguese.recipes.bras.JBakerHelper.createIngredient;
import static org.jesperancinha.portuguese.recipes.bras.JBakerHelper.createInteraction;
import static org.jesperancinha.portuguese.recipes.bras.JBakerHelper.seq;
import static org.jesperancinha.portuguese.recipes.bras.JBakerHelper.set;


public class Main {
    public static void main(String[] args) {
        final Ingredient potatoes = createIngredient("4 potatoes");
        final Ingredient potatoStrips = createIngredient("4 potatoes in tiny strips");
        final Ingredient codFish = createIngredient("18 ounces of cod fish");
        final Ingredient oneOnion = createIngredient("One onion");
        final Ingredient oneSlicedOnion = createIngredient("One sliced onion");
        final Ingredient halfCupOliveOil = createIngredient("Half cup olive oil");
        final Ingredient eggs = createIngredient("10 eggs");
        final Ingredient blackOlives = createIngredient("Quarter cup of black Olives");
        final Ingredient milkTeaSpoon = createIngredient("Milk tea spoon");
        final Ingredient saltNPepper = createIngredient("Salt and Pepper");

        final Event event = Event.apply("A great event!", seq(potatoStrips));

        final Interaction interaction = createInteraction("Make it happen", potatoStrips, event);
        final Recipe bacalhauABras = Recipe.apply("Bacalhau à Brás", seq(interaction), set(event), null, Option.empty(), Option.empty());

        CompiledRecipe compileRecipe = RecipeCompiler.compileRecipe(bacalhauABras);

        System.out.println(compileRecipe.getRecipeVisualization());
    }
}
