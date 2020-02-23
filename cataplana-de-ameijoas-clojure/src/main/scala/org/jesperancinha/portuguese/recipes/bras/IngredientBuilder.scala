package org.jesperancinha.portuguese.recipes.bras

import com.ing.baker.recipe.scaladsl.Ingredient

object IngredientBuilder {

  def creatIngredient(name: String): Ingredient[String] = {
    Ingredient[String](name)
  }
}
