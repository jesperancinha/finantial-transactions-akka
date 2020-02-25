package org.jesperancinha.portuguese.recipes.bras;

import akka.actor.ActorSystem;
import com.ing.baker.il.CompiledRecipe;
import com.ing.baker.runtime.javadsl.Baker;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import scala.runtime.BoxedUnit;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MainTest {

    @Test
    void createBacalhauABrasRecipe() {
        System.out.println(Main.createBacalhauABrasRecipe().getRecipeVisualization());
    }

    @Test
    @Disabled
    void bakeBacalhauABrasRecipeStopInMiddle() throws ExecutionException, InterruptedException {
        final CompiledRecipe bacalhauABrasRecipe = Main.createBacalhauABrasRecipe();

        ActorSystem actorSystem = ActorSystem.apply("peixinhosDaHorta");
        Baker baker = Baker.akkaLocalDefault(actorSystem);

        CompletableFuture<String> stringCompletableFuture = baker.addRecipe(bacalhauABrasRecipe);
        baker.addInteractionInstances(null);
        String recipeId = stringCompletableFuture.get();
        CompletableFuture<BoxedUnit> bake = baker.bake(recipeId, "recipe-instance-id");
        baker.fireEventAndResolveWhenReceived("recipe-instance-id", null);

        bake.get();

        baker.getVisualState("recipe-instance-id");
    }

    @Test
    @Disabled
    void bakeBacalhauABrasRecipe() throws ExecutionException, InterruptedException {
        final CompiledRecipe bacalhauABrasRecipe = Main.createBacalhauABrasRecipe();

        ActorSystem actorSystem = ActorSystem.apply("peixinhosDaHorta");
        Baker baker = Baker.akkaLocalDefault(actorSystem);

        CompletableFuture<String> stringCompletableFuture = baker.addRecipe(bacalhauABrasRecipe);
        baker.addInteractionInstances(null);
        String recipeId = stringCompletableFuture.get();
        CompletableFuture<BoxedUnit> bake = baker.bake(recipeId, "recipe-instance-id");
        baker.fireEventAndResolveWhenCompleted("recipe-instance-id", null);

        bake.get();

        baker.getVisualState("recipe-instance-id");

    }
}