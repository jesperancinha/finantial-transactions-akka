package org.jesperancinha.portuguese.recipes.bras;

import com.ing.baker.recipe.common.Ingredient;
import com.ing.baker.recipe.scaladsl.Event;
import com.ing.baker.recipe.scaladsl.Interaction;
import scala.Option;

import static org.jesperancinha.portuguese.recipes.bras.JBakerHelper.createIngredient;
import static org.jesperancinha.portuguese.recipes.bras.JBakerHelper.createInteraction;
import static org.jesperancinha.portuguese.recipes.bras.JBakerHelper.seq;
import static org.jesperancinha.portuguese.recipes.bras.JBakerHelper.set;

public class Recipe {

    final Ingredient potatoes = createIngredient("4 potatoes");
    final Ingredient potatoStrips = createIngredient("4 potatoes in tiny strips");
    final Ingredient goldenbrownedPotatoes = createIngredient("Browned potatoes");
    final Ingredient codFish = createIngredient("18 ounces of cod fish");
    final Ingredient codFishDippedInWater = createIngredient("Desalted cod fish");
    final Ingredient cookedCodFishLowHeat = createIngredient("Cooked cod Fish Low heat");
    final Ingredient boiledCodFish = createIngredient("Boiled cod fish");
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
    final Ingredient bacalhauABrasCoveredWithBlackOlives = createIngredient("Bacalhau à Brás covered with black olives");

    final Event prepareGuestsDinner = Event.apply("The weekend is starting and I have to prepare dinner for my guests on Saturday",
            seq(codFish, milkTeaSpoon, saltNPepper, eggs, potatoes, oneOnion, blackOlives, halfCupOliveOil));

    final Event codFishRestedOvernightInWaterEvent = Event.apply("Cod fish has been dipped in water for at lest 24 hours", seq(codFishDippedInWater));
    final Event onionsHaveBeednSlicedEvent = Event.apply("Onions have been sliced", seq(oneSlicedOnion));
    final Event potatosHaveBeednSlicedEvent = Event.apply("Potatoes have been sliced", seq(potatoStrips));
    final Event boilFishEvent = Event.apply("Cod fish has been boiled for 20 minutes", seq(boiledCodFish));
    final Event skinCodFishEvent = Event.apply("Cod fish has been skinned", seq(skinnedCodFish));
    final Event boneCodFishEvent = Event.apply("Cod fish has been boned", seq(bonedCodFish));
    final Event deflakeCodFishEvent = Event.apply("Cod fish has been deflaked", seq(deflakedCodFish));
    final Event coverSaucePanEvent = Event.apply("Saucepan covered with olive oil", seq(saucePanCovered));
    final Event sauteOnionsEvent = Event.apply("Onions saute until transparent", seq(sautedOnions));
    final Event goldenBrownPotatoesEvent = Event.apply("Potatoes have been golden browned", seq(goldenbrownedPotatoes));
    final Event cookCodFishLowHeatEvent = Event.apply("Cod fish has been cooked in low heat", seq(cookedCodFishLowHeat));
    final Event beatEggsEvent = Event.apply("Eggs have been beaten", seq(beatenEggs));
    final Event eggsAddedToThePanEvent = Event.apply("Cod fish has been mixed with beaten eggs", seq(codFishWithEggs));
    final Event mixedCookedOnMediumHeatEvent = Event.apply("Medium heat cooked mix", seq(mediumHeatCookedMix));
    final Event pourMixtureIntoServingDishEvent = Event.apply("Mix poured into serving dish with parsley", seq(bacalhauABras));
    final Event decorateWithOlivesEvent = Event.apply("Decorated with black olives", seq(bacalhauABrasCoveredWithBlackOlives));

    final Interaction dippFishInWaterInteraction = createInteraction("Leave fish overnight in water", codFish, codFishRestedOvernightInWaterEvent)
            .withRequiredEvent(prepareGuestsDinner);
    final Interaction boilFishInteraction = createInteraction("Boil fish", codFishDippedInWater, boilFishEvent)
            .withRequiredEvent(codFishRestedOvernightInWaterEvent);
    final Interaction slicePotatoesInteraction = createInteraction("Slice potatoes", potatoes, potatosHaveBeednSlicedEvent)
            .withRequiredEvent(prepareGuestsDinner);
    final Interaction sliceOnionsInteraction = createInteraction("Slice onions", oneOnion, onionsHaveBeednSlicedEvent)
            .withRequiredEvent(prepareGuestsDinner);

    final Interaction skinFishInteraction = createInteraction("Skinned Fish", boiledCodFish, skinCodFishEvent)
            .withRequiredEvent(boilFishEvent);
    final Interaction boneFishInteraction = createInteraction("Bone fish", skinnedCodFish, boneCodFishEvent)
            .withRequiredEvent(skinCodFishEvent);
    final Interaction deflakeFishInteraction = createInteraction("Deflake fish", bonedCodFish, deflakeCodFishEvent)
            .withRequiredEvent(boneCodFishEvent);
    final Interaction coverSaucePanInteraction = createInteraction("Cover sauce pan", seq(oneSlicedOnion, halfCupOliveOil), seq(coverSaucePanEvent))
            .withRequiredEvent(onionsHaveBeednSlicedEvent);
    final Interaction sauteOnionsInteraction = createInteraction("Saute Onions", saucePanCovered, sauteOnionsEvent)
            .withRequiredEvent(coverSaucePanEvent);
    final Interaction addThinPotatoesInteraction = createInteraction("Golden brown thin potatoes", seq(sautedOnions, potatoStrips), seq(goldenBrownPotatoesEvent))
            .withRequiredEvent(sauteOnionsEvent);
    final Interaction cookCodFishInteraction = createInteraction("Cook cod fish low heat", seq(goldenbrownedPotatoes, deflakedCodFish), seq(cookCodFishLowHeatEvent))
            .withRequiredEvent(goldenBrownPotatoesEvent);
    final Interaction beatEggsInteraction = createInteraction("Beat eggs", seq(eggs, milkTeaSpoon, saltNPepper), seq(beatEggsEvent))
            .withRequiredEvent(cookCodFishLowHeatEvent);
    final Interaction eggsAddedToPanInteraction = createInteraction("Cover cod fish with beaten eggs", seq(beatenEggs, cookedCodFishLowHeat), seq(eggsAddedToThePanEvent))
            .withRequiredEvent(beatEggsEvent);
    final Interaction mixCookingOnMediumHeatInteraction = createInteraction("Cook mix on medium heat", codFishWithEggs, mixedCookedOnMediumHeatEvent)
            .withRequiredEvent(eggsAddedToThePanEvent);
    final Interaction pourMixOverDishInteraction = createInteraction("Pour mix over plate", mediumHeatCookedMix, pourMixtureIntoServingDishEvent)
            .withRequiredEvent(mixedCookedOnMediumHeatEvent);
    final Interaction decorateDishInteraction = createInteraction("Decorate with black olives", bacalhauABras, decorateWithOlivesEvent)
            .withRequiredEvent(pourMixtureIntoServingDishEvent);


    final com.ing.baker.recipe.javadsl.Recipe bacalhauABrasRecipe = com.ing.baker.recipe.javadsl.Recipe
            .apply("Bacalhau à Brás",
                    seq(dippFishInWaterInteraction,
                            slicePotatoesInteraction, sliceOnionsInteraction, boilFishInteraction,
                            skinFishInteraction, boneFishInteraction, deflakeFishInteraction,
                            coverSaucePanInteraction, sauteOnionsInteraction, addThinPotatoesInteraction,
                            cookCodFishInteraction, beatEggsInteraction, eggsAddedToPanInteraction,
                            mixCookingOnMediumHeatInteraction, pourMixOverDishInteraction,
                            decorateDishInteraction),
                    set(prepareGuestsDinner),
                    null,
                    Option.empty(),
                    Option.empty());

}
