package org.jesperancinha.portuguese.recipes.bras;

import com.ing.baker.recipe.common.Event;
import com.ing.baker.recipe.common.EventOutputTransformer;
import com.ing.baker.recipe.common.Ingredient;
import com.ing.baker.recipe.scaladsl.Interaction;
import com.ing.baker.types.Value;
import scala.Option;
import scala.collection.JavaConverters;
import scala.collection.Seq;
import scala.collection.immutable.HashMap;
import scala.collection.immutable.HashSet;
import scala.collection.immutable.Map;
import scala.collection.immutable.Set;

import java.util.Arrays;

public class JBakerHelper {

    public static Ingredient createIngredient(String name) {
        return IngredientBuilder.creatIngredient(name);
    }

    public static <T> Seq<T> seq(T... ingredient) {
        return JavaConverters.asScalaBuffer(Arrays.asList(ingredient)).toSeq();
    }

    public static Set<String> setEmptyString() {
        return new HashSet<>();
    }

    public static Set<Set<String>> setOfSetEmptyString() {
        return new HashSet<>();
    }

    public static Map<String, Value> mapOfEmptyValue() {
        return new HashMap<>();
    }

    public static Map<String, String> mapOfEmptyString() {
        return new HashMap<>();
    }

    public static Map<Event, EventOutputTransformer> mapOfEmptyCommonEvent() {
        return new HashMap<>();
    }

    public static <T> Set<T> set(T... ingredient) {
        return JavaConverters.asScalaBuffer(Arrays.asList(ingredient)).toSet();
    }

    public static Interaction createInteraction(String name, Seq<Ingredient> ingredients, Seq<Event> events) {
        return Interaction.apply(
                name, ingredients,
                events, setEmptyString(),
                setOfSetEmptyString(),
                mapOfEmptyValue(),
                mapOfEmptyString(),
                Option.empty(),
                Option.empty(),
                Option.empty(),
                mapOfEmptyCommonEvent(),
                Option.empty());
    }

    public static Interaction createInteraction(String name, Ingredient ingredient, Event event) {
        return Interaction.apply(
                name,
                seq(ingredient),
                seq(event),
                setEmptyString(),
                setOfSetEmptyString(),
                mapOfEmptyValue(),
                mapOfEmptyString(),
                Option.empty(),
                Option.empty(),
                Option.empty(),
                mapOfEmptyCommonEvent(),
                Option.empty());
    }
}
