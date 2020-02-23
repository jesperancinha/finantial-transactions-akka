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
        final Ingredient ingredient = createIngredient("4 potatoes");
        final com.ing.baker.recipe.common.Event event = Event.apply("A great event!", seq(ingredient));
        final Interaction interaction = createInteraction("Make it happen", ingredient, event);
        final Recipe bacalhauABras = Recipe.apply("Bacalhau à Brás", seq(interaction), set(event), null, Option.empty(), Option.empty());

        CompiledRecipe compileRecipe = RecipeCompiler.compileRecipe(bacalhauABras);

        System.out.println(compileRecipe.getRecipeVisualization());
    }
}
