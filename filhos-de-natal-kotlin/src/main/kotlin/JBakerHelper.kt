import com.ing.baker.recipe.common.Event
import com.ing.baker.recipe.common.EventOutputTransformer
import com.ing.baker.recipe.common.Ingredient
import com.ing.baker.recipe.scaladsl.Interaction
import com.ing.baker.types.Value
import org.jesperancinha.portuguese.recipes.bras.IngredientBuilder
import scala.Option
import scala.collection.JavaConverters
import scala.collection.Seq
import scala.collection.immutable.HashMap
import scala.collection.immutable.HashSet
import scala.collection.immutable.Map
import scala.collection.immutable.Set
import java.util.*

object JBakerHelper {
    fun createIngredient(name: String?): Ingredient {
        return IngredientBuilder.creatIngredient(name)
    }

    fun <T> seq(vararg ingredient: T): Seq<T> {
        return JavaConverters.asScalaBuffer(Arrays.asList(*ingredient)).toSeq()
    }

    private fun setEmptyString(): Set<String> {
        return HashSet()
    }

    private fun setOfSetEmptyString(): Set<Set<String>> {
        return HashSet()
    }

    private fun mapOfEmptyValue(): Map<String, Value> {
        return HashMap()
    }

    private fun mapOfEmptyString(): Map<String, String> {
        return HashMap()
    }

    private fun mapOfEmptyCommonEvent(): Map<Event, EventOutputTransformer> {
        return HashMap()
    }

    fun <T> set(vararg ingredient: T): Set<T> {
        return JavaConverters.asScalaBuffer(Arrays.asList(*ingredient)).toSet()
    }

    fun createInteraction(name: String?, ingredients: Seq<Ingredient>, events: Seq<Event>): Interaction {
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
                Option.empty())
    }
}
