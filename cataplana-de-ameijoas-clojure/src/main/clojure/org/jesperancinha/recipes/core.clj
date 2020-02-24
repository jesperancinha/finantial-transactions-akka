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
  (def clams (JBakerHelper/createIngredient "500 g of clams"))
  (def mussels (JBakerHelper/createIngredient "500 g of mussels"))
  (def monkfish (JBakerHelper/createIngredient "400 g of monkfish loins"))
  (def squids (JBakerHelper/createIngredient "400 g of squid in rings"))
  (def onions (JBakerHelper/createIngredient "2 onions"))
  (def margarine (JBakerHelper/createIngredient "60 g of margarine"))
  (def oliveOil (JBakerHelper/createIngredient "1 dl olive oil"))
  (def chili (JBakerHelper/createIngredient "1 chili"))
  (def peeledTomato (JBakerHelper/createIngredient "1 big can of peeled tomato"))
  (def almonds (JBakerHelper/createIngredient "100 g of grated almonds"))
  (def saffron (JBakerHelper/createIngredient "1 spoon of saffron"))
  (def laurel (JBakerHelper/createIngredient "1 leaf of laurel"))
  (def thyme (JBakerHelper/createIngredient "fresh thyme"))
  (def whiteWine (JBakerHelper/createIngredient "4 dl white wine"))
  (def water (JBakerHelper/createIngredient "5 dl water"))
  (def pepper (JBakerHelper/createIngredient "pepper"))
  (def prawns (JBakerHelper/createIngredient "500 g of prawns"))
  )
