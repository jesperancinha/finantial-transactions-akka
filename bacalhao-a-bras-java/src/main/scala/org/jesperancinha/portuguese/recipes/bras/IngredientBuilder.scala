package org.jesperancinha.portuguese.recipes.bras

import java.util
import java.util.Optional
import java.util.concurrent.CompletableFuture

import com.ing.baker.recipe.scaladsl.Ingredient
import com.ing.baker.runtime.javadsl
import com.ing.baker.runtime.javadsl.InteractionInstance
import com.ing.baker.types.{CharArray, Type}

object IngredientBuilder {

  def creatIngredient(name: String): Ingredient[String] = {
    Ingredient[String](name)
  }

  def createIteraction(newName: String, elementNumber: Integer, handleEvent: CompletableFuture[Optional[javadsl.EventInstance]]): InteractionInstance = {
    val types = new util.ArrayList[Type]()
    for (_ <- 0 until elementNumber) {
      types.add(CharArray)
    }
    new InteractionInstance {
      override val name: String = newName
      override val input: util.List[Type] = types

      override def execute(input: util.List[javadsl.IngredientInstance]): CompletableFuture[Optional[javadsl.EventInstance]] = handleEvent
    }
  }
}
