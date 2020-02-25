package org.jesperancinha.portuguese.recipes.bras;

import com.ing.baker.compiler.RecipeCompiler;
import com.ing.baker.il.CompiledRecipe;


public class Main {
    public static void main(String[] args) {
        createBacalhauABrasRecipe();
    }

    public static CompiledRecipe createBacalhauABrasRecipe() {
        final com.ing.baker.recipe.javadsl.Recipe bacalhauABrasRecipe = new Recipe().bacalhauABrasRecipe;
        return RecipeCompiler.compileRecipe(bacalhauABrasRecipe);
    }
}
