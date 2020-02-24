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
        final Ingredient brownedPotatoes = createIngredient("Browned potatoes");
        final Ingredient codFish = createIngredient("18 ounces of cod fish");
        final Ingredient cookedCodFishLowHeat = createIngredient("Cooked cod Fish Low heat");
        final Ingredient boiledCodeFish = createIngredient("Boiled cod fish");
        final Ingredient skinnedCodFish = createIngredient("Skinned cod fish");
        final Ingredient bonedCodFish = createIngredient("Boned cod fish ");
        final Ingredient deflakedCodFish = createIngredient("Deflaked cod fish");
        final Ingredient oneOnion = createIngredient("One onion");
        final Ingredient oneSlicedOnion = createIngredient("One sliced onion");
        final Ingredient sautedOnions = createIngredient("Saute onions");
        final Ingredient halfCupOliveOil = createIngredient("Half cup olive oil");
        final Ingredient eggs = createIngredient("10 eggs");
        final Ingredient beatenEggs = createIngredient("Beaten Eggs");
        final Ingredient codFishWithEggs = createIngredient("Cod fish with beaten eggs");
        final Ingredient blackOlives = createIngredient("Quarter cup of black Olives");
        final Ingredient milkTeaSpoon = createIngredient("Milk tea spoon");
        final Ingredient saltNPepper = createIngredient("Salt and Pepper");
        final Ingredient saucePanCovered = createIngredient("Sauce pan");
        final Ingredient mediumHeatCookedMix = createIngredient("Medium heat cooked mix with creamy eggs and Cod Fish");
        final Ingredient bacalhauABras = createIngredient("Bacalhau à Brás");

        final Event potatosHaveBeenSlicedEvent = Event.apply("Potatoes have been sliced", seq(potatoStrips));
        final Event codFishRestedOvernightInWaterEvent = Event.apply("Cod fish has been dipped in water for at lest 24 hours", seq(potatoStrips));
        final Event boilFishEvent = Event.apply("Cod fish has been boiled for 20 minuts", seq(boiledCodeFish));
        final Event skinCodFishEvent = Event.apply("Cod fish has been skinned", seq(skinnedCodFish));
        final Event boneCodFishEvent = Event.apply("Cod fish has been boned", seq(bonedCodFish));
        final Event deflakeCodFishEvent = Event.apply("Cod fish has been deflaked", seq(deflakedCodFish));
        final Event coverSaucePanEvent = Event.apply("Saucepan covered with olive oil", seq(saucePanCovered));
        final Event sauteOnionsEvent = Event.apply("Onions saute until transparent", seq(sautedOnions));
        final Event brownPotatoesEvent = Event.apply("Potatoes have been browned", seq(brownedPotatoes));
        final Event cookCodFishLowHeatEvent = Event.apply("Cod fish has been cooked in low heat", seq(brownedPotatoes));
        final Event beatEggsEvent = Event.apply("Eggs have been beaten", seq(beatenEggs));
        final Event eggsAddedToThePanEvent = Event.apply("Cod fish with beaten eggs", seq(codFishWithEggs));
        final Event mixedCookedOnMediumHeatEvent = Event.apply("Medium heat cooked mix", seq(mediumHeatCookedMix));
        final Event pourMixtureIntoServingDishEvent = Event.apply("Mix poured into serving dish with parsley", seq(bacalhauABras));

        final Interaction interaction = createInteraction("Make it happen", potatoStrips, potatosHaveBeenSlicedEvent);
        final Recipe bacalhauABrasRecipe = Recipe.apply("Bacalhau à Brás", seq(interaction), set(potatosHaveBeenSlicedEvent), null, Option.empty(), Option.empty());

        final CompiledRecipe compileRecipe = RecipeCompiler.compileRecipe(bacalhauABrasRecipe);

        System.out.println(compileRecipe.getRecipeVisualization());
    }
}
