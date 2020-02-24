(ns org.jesperancinha.recipes.core
  (:gen-class)
  (:import
    (org.jesperancinha.portuguese.recipes.bras IngredientBuilder)
    (org.jesperancinha.portuguese.recipes.bras JBakerHelper)
    ))


(defn create-ingredient
  "docstring"
  [name]
  (IngredientBuilder/creatIngredient ["name"]))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (def test (JBakerHelper/createIngredient "test"))
  (println test)
  )
