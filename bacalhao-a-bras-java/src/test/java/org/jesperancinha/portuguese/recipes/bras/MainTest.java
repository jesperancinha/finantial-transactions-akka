package org.jesperancinha.portuguese.recipes.bras;

import akka.actor.ActorSystem;
import com.ing.baker.compiler.RecipeCompiler;
import com.ing.baker.il.CompiledRecipe;
import com.ing.baker.runtime.common.SensoryEventStatus;
import com.ing.baker.runtime.javadsl.Baker;
import com.ing.baker.runtime.javadsl.EventInstance;
import com.ing.baker.runtime.javadsl.EventListener;
import com.ing.baker.runtime.javadsl.InteractionInstance;
import com.ing.baker.runtime.javadsl.SensoryEventResult;
import com.ing.baker.types.PrimitiveValue;
import com.ing.baker.types.Value;
import org.junit.jupiter.api.Test;
import scala.runtime.BoxedUnit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.util.Optional.ofNullable;
import static org.jesperancinha.portuguese.recipes.bras.JBakerHelper.createInteractionInstance;

public class MainTest {

    private final Recipe recipe = new Recipe();

    private final InteractionInstance dippFishInWaterInteractionInstance =
            createInteractionInstance(recipe.dippFishInWaterInteraction.name(), 1,
                    CompletableFuture.supplyAsync(() -> ofNullable(EventInstance
                            .apply(recipe.codFishRestedOvernightInWaterEvent.name(),
                                    new HashMap<String, Value>() {{
                                        put(recipe.codFishDippedInWater.name(), new PrimitiveValue("Greatly wet"));
                                    }}))));

    private final InteractionInstance boilFishInteractionInstance =
            createInteractionInstance(recipe.boilFishInteraction.name(), 1,
                    CompletableFuture.supplyAsync(() -> ofNullable(EventInstance
                            .apply(recipe.boilFishEvent.name(),
                                    new HashMap<String, Value>() {{
                                        put(recipe.boiledCodFish.name(), new PrimitiveValue("Super boiled"));
                                    }}))));


    private final InteractionInstance slicePotatoesInteractionInstance =
            createInteractionInstance(recipe.slicePotatoesInteraction.name(), 1,
                    CompletableFuture.supplyAsync(() -> ofNullable(EventInstance
                            .apply(recipe.potatosHaveBeednSlicedEvent.name(),
                                    new HashMap<String, Value>() {{
                                        put(recipe.potatoStrips.name(), new PrimitiveValue("Greatly sliced"));
                                    }}))));

    private final InteractionInstance sliceOnionsInteractionInstance =
            createInteractionInstance(recipe.sliceOnionsInteraction.name(), 1,
                    CompletableFuture.supplyAsync(() -> ofNullable(EventInstance
                            .apply(recipe.onionsHaveBeednSlicedEvent.name(),
                                    new HashMap<String, Value>() {{
                                        put(recipe.oneSlicedOnion.name(), new PrimitiveValue("Super Onions"));
                                    }}))));

    private final InteractionInstance skinFishInteractionInstance =
            createInteractionInstance(recipe.skinFishInteraction.name(), 1,
                    CompletableFuture.supplyAsync(() -> ofNullable(EventInstance
                            .apply(recipe.skinCodFishEvent.name(),
                                    new HashMap<String, Value>() {{
                                        put(recipe.skinnedCodFish.name(), new PrimitiveValue("Skinned fish"));
                                    }}))));

    private final InteractionInstance boneFishInteractionInstance =
            createInteractionInstance(recipe.boneFishInteraction.name(), 1,
                    CompletableFuture.supplyAsync(() -> ofNullable(EventInstance
                            .apply(recipe.boneCodFishEvent.name(),
                                    new HashMap<String, Value>() {{
                                        put(recipe.bonedCodFish.name(), new PrimitiveValue("No bones in this fish"));
                                    }}))));

    private final InteractionInstance deflakeFishInteractionInstance =
            createInteractionInstance(recipe.deflakeFishInteraction.name(), 1,
                    CompletableFuture.supplyAsync(() -> ofNullable(EventInstance
                            .apply(recipe.deflakeCodFishEvent.name(),
                                    new HashMap<String, Value>() {{
                                        put(recipe.deflakedCodFish.name(), new PrimitiveValue("Awesomly deflaked"));
                                    }}))));

    private final InteractionInstance coverSaucePanInteractionInstance =
            createInteractionInstance(recipe.coverSaucePanInteraction.name(), 2,
                    CompletableFuture.supplyAsync(() -> ofNullable(EventInstance
                            .apply(recipe.coverSaucePanEvent.name(),
                                    new HashMap<String, Value>() {{
                                        put(recipe.saucePanCovered.name(), new PrimitiveValue("Good sauce pan"));
                                    }}))));

    private final InteractionInstance sauteOnionsInteractionInstance =
            createInteractionInstance(recipe.sauteOnionsInteraction.name(), 1,
                    CompletableFuture.supplyAsync(() -> ofNullable(EventInstance
                            .apply(recipe.sauteOnionsEvent.name(),
                                    new HashMap<String, Value>() {{
                                        put(recipe.sautedOnions.name(), new PrimitiveValue("Best Saute Onions Ever"));
                                    }}))));

    private final InteractionInstance addThinPotatoesInteractionInstance =
            createInteractionInstance(recipe.addThinPotatoesInteraction.name(), 2,
                    CompletableFuture.supplyAsync(() -> ofNullable(EventInstance
                            .apply(recipe.goldenBrownPotatoesEvent.name(),
                                    new HashMap<String, Value>() {{
                                        put(recipe.goldenbrownedPotatoes.name(), new PrimitiveValue("Thin potato strips"));
                                    }}))));

    private final InteractionInstance cookCodFishInteractionInstance =
            createInteractionInstance(recipe.cookCodFishInteraction.name(), 2,
                    CompletableFuture.supplyAsync(() -> ofNullable(EventInstance
                            .apply(recipe.cookCodFishLowHeatEvent.name(),
                                    new HashMap<String, Value>() {{
                                        put(recipe.cookedCodFishLowHeat.name(), new PrimitiveValue("Cooked fish"));
                                    }}))));

    private final InteractionInstance beatEggsInteractionsInstance =
            createInteractionInstance(recipe.beatEggsInteraction.name(), 3,
                    CompletableFuture.supplyAsync(() -> ofNullable(EventInstance
                            .apply(recipe.beatEggsEvent.name(),
                                    new HashMap<String, Value>() {{
                                        put(recipe.beatenEggs.name(), new PrimitiveValue("The right way beaten eggs"));
                                    }}))));

    private final InteractionInstance eggsAddedToPanInteractionInstance =
            createInteractionInstance(recipe.eggsAddedToPanInteraction.name(), 2,
                    CompletableFuture.supplyAsync(() -> ofNullable(EventInstance
                            .apply(recipe.eggsAddedToThePanEvent.name(),
                                    new HashMap<String, Value>() {{
                                        put(recipe.codFishWithEggs.name(), new PrimitiveValue("Super boiled"));
                                    }}))));

    private final InteractionInstance mixCookingOnMediumHeatInteractionInstance =
            createInteractionInstance(recipe.mixCookingOnMediumHeatInteraction.name(), 1,
                    CompletableFuture.supplyAsync(() -> ofNullable(EventInstance
                            .apply(recipe.mixedCookedOnMediumHeatEvent.name(),
                                    new HashMap<String, Value>() {{
                                        put(recipe.mediumHeatCookedMix.name(), new PrimitiveValue("Mix to medium heat"));
                                    }}))));

    private final InteractionInstance pourMixOverDishInteractionInstance =
            createInteractionInstance(recipe.pourMixOverDishInteraction.name(), 1,
                    CompletableFuture.supplyAsync(() -> ofNullable(EventInstance
                            .apply(recipe.pourMixtureIntoServingDishEvent.name(),
                                    new HashMap<String, Value>() {{
                                        put(recipe.bacalhauABras.name(), new PrimitiveValue("Served gently"));
                                    }}))));

    private final InteractionInstance decorateDishInteractionInstance =
            createInteractionInstance(recipe.decorateDishInteraction.name(), 1,
                    CompletableFuture.supplyAsync(() -> ofNullable(EventInstance
                            .apply(recipe.decorateWithOlivesEvent.name(),
                                    new HashMap<String, Value>() {{
                                        put(recipe.bacalhauABrasCoveredWithBlackOlives.name(), new PrimitiveValue("World Class Bacalhau A Bras"));
                                    }}))));

    @Test
    void createBacalhauABrasRecipe() {
        System.out.println(RecipeCompiler.compileRecipe(new Recipe().bacalhauABrasRecipe).getRecipeVisualization());
    }

    @Test
    void bakeBacalhauABrasRecipeStopInMiddle() throws ExecutionException, InterruptedException {
        final CompiledRecipe bacalhauABrasRecipe = RecipeCompiler.compileRecipe(recipe.bacalhauABrasRecipe);

        ActorSystem actorSystem = ActorSystem.apply("BacalhauABras");
        Baker baker = Baker.akkaLocalDefault(actorSystem);


        baker.registerEventListener((EventListener) (recipeInstanceId, event) ->
                TaskSimulator.waitMilliseconds(event.name(), 10));

        baker.addInteractionInstances(
                Arrays.asList(dippFishInWaterInteractionInstance,
                        boilFishInteractionInstance,
                        slicePotatoesInteractionInstance,
                        sliceOnionsInteractionInstance,
                        skinFishInteractionInstance,
                        boneFishInteractionInstance,
                        deflakeFishInteractionInstance,
                        coverSaucePanInteractionInstance,
                        sauteOnionsInteractionInstance,
                        addThinPotatoesInteractionInstance,
                        cookCodFishInteractionInstance,
                        beatEggsInteractionsInstance,
                        eggsAddedToPanInteractionInstance,
                        mixCookingOnMediumHeatInteractionInstance,
                        pourMixOverDishInteractionInstance,
                        decorateDishInteractionInstance)
        )  .thenCompose(ignore -> baker.addRecipe(bacalhauABrasRecipe))
                .thenCompose(recipeId -> baker.bake(recipeId, "recipe-instance-id"))
                .get();

        CompletableFuture<SensoryEventStatus> sensoryEventStatusCompletableFuture = baker.fireEventAndResolveWhenReceived("recipe-instance-id",
                new EventInstance(
                        recipe.prepareGuestsDinner.name(),
                        new HashMap<String, Value>() {{
                            put(recipe.codFish.name(), new PrimitiveValue("We fished this cod fish in the North"));
                            put(recipe.milkTeaSpoon.name(), new PrimitiveValue("Milk from the cow"));
                            put(recipe.saltNPepper.name(), new PrimitiveValue("Pepper from the neighbour"));
                            put(recipe.eggs.name(), new PrimitiveValue("Free range eggs"));
                            put(recipe.potatoes.name(), new PrimitiveValue("A wild potatoe"));
                            put(recipe.oneOnion.name(), new PrimitiveValue("Onion from our friend"));
                            put(recipe.blackOlives.name(), new PrimitiveValue("Olives fromt he farm"));
                            put(recipe.halfCupOliveOil.name(), new PrimitiveValue("Fresh olive oil"));
                        }}

                ));
        sensoryEventStatusCompletableFuture.get();

        final CompletableFuture<String> visualState = baker.getVisualState("recipe-instance-id");
        visualState.join();
        System.out.println(visualState.get());
    }

    @Test
    void bakeBacalhauABrasRecipe() throws ExecutionException, InterruptedException {

        final CompiledRecipe bacalhauABrasRecipe = RecipeCompiler.compileRecipe(recipe.bacalhauABrasRecipe);
        ActorSystem actorSystem = ActorSystem.apply("BacalhauABras");
        Baker baker = Baker.akkaLocalDefault(actorSystem);

        baker.registerEventListener((EventListener) (recipeInstanceId, event) ->
                TaskSimulator.waitMilliseconds(event.name(), 10));

        baker.addInteractionInstances(
                Arrays.asList(dippFishInWaterInteractionInstance,
                        boilFishInteractionInstance,
                        slicePotatoesInteractionInstance,
                        sliceOnionsInteractionInstance,
                        skinFishInteractionInstance,
                        boneFishInteractionInstance,
                        deflakeFishInteractionInstance,
                        coverSaucePanInteractionInstance,
                        sauteOnionsInteractionInstance,
                        addThinPotatoesInteractionInstance,
                        cookCodFishInteractionInstance,
                        beatEggsInteractionsInstance,
                        eggsAddedToPanInteractionInstance,
                        mixCookingOnMediumHeatInteractionInstance,
                        pourMixOverDishInteractionInstance,
                        decorateDishInteractionInstance
                )
        )
                .thenCompose(ignore -> baker.addRecipe(bacalhauABrasRecipe))
                .thenCompose(recipeId -> baker.bake(recipeId, "recipe-instance-id"))
                .get();


        CompletableFuture<SensoryEventResult> sensoryEventStatusCompletableFuture = baker.fireEventAndResolveWhenCompleted("recipe-instance-id",
                new EventInstance(
                        recipe.prepareGuestsDinner.name(),
                        new HashMap<String, Value>() {{
                            put(recipe.codFish.name(), new PrimitiveValue("We fished this cod fish in the North"));
                            put(recipe.milkTeaSpoon.name(), new PrimitiveValue("Milk from the cow"));
                            put(recipe.saltNPepper.name(), new PrimitiveValue("Pepper from the neighbour"));
                            put(recipe.eggs.name(), new PrimitiveValue("Free range eggs"));
                            put(recipe.potatoes.name(), new PrimitiveValue("A wild potato"));
                            put(recipe.oneOnion.name(), new PrimitiveValue("Onion from our friend"));
                            put(recipe.blackOlives.name(), new PrimitiveValue("Olives from the farm"));
                            put(recipe.halfCupOliveOil.name(), new PrimitiveValue("Fresh olive oil"));
                        }}
                ));
        sensoryEventStatusCompletableFuture.get();

        Thread.sleep(2000);
        final CompletableFuture<String> visualState = baker.getVisualState("recipe-instance-id");
        visualState.join();
        System.out.println(visualState.get());
    }
}