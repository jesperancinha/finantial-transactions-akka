(ns org.jesperancinha.recipes.core
  (:gen-class)
  (:import
    (org.jesperancinha.portuguese.recipes.bras IngredientBuilder)
    (org.jesperancinha.portuguese.recipes.bras JBakerHelper)
    (com.ing.baker.compiler RecipeCompiler)
    (java.util ArrayList)))


(defn create-ingredient
  "docstring"
  [name]
  (IngredientBuilder/creatIngredient ["name"]))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (def liveClams (JBakerHelper/createIngredient "500 g of clams"))
  (def washedClams (JBakerHelper/createIngredient "Washed clams"))
  (def brushedMussels (JBakerHelper/createIngredient "Brushed mussels"))
  (def scrappedMussels (JBakerHelper/createIngredient "Scrapped mussels"))
  (def washedMussels (JBakerHelper/createIngredient "Washed mussels"))
  (def mussels (JBakerHelper/createIngredient "500 g of mussels"))
  (def monkfish (JBakerHelper/createIngredient "400 g of frozen monkfish loins"))
  (def monkFishThawed (JBakerHelper/createIngredient "Thawed monk fish"))
  (def squids (JBakerHelper/createIngredient "400 g of frozen squid in rings"))
  (def squidsThawed (JBakerHelper/createIngredient "Thawed Squids"))
  (def onions (JBakerHelper/createIngredient "2 onions"))
  (def peeledOnions (JBakerHelper/createIngredient "Peeled onions"))
  (def slicedOnions (JBakerHelper/createIngredient "Sliced Onions"))
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
  (def salt (JBakerHelper/createIngredient "salt"))
  (def cataplanaWithOnions (JBakerHelper/createIngredient "Cataplana with onions"))
  (def cataplanaWithSauteOnions (JBakerHelper/createIngredient "Cataplana with saute onions"))
  (def cataplanaWithRedSeasoning (JBakerHelper/createIngredient "Cataplana with chili and peeled tomatoes"))
  (def cataplanaLowHeat15Cooked (JBakerHelper/createIngredient "Cooked for 15 minutes"))
  (def cataplanaWithSmashedTomato (JBakerHelper/createIngredient "Post cook smashed tomato"))
  (def cataplanaLowHeat10CookedWithExtraSeasoning (JBakerHelper/createIngredient "Cooked for 10 minutes with extra seasoning"))
  (def cataplanaDeAmeijoas (JBakerHelper/createIngredient "Cataplana de ameijoas"))
  (def fishermansBag (ArrayList.
                       [liveClams, mussels, monkfish, onions, squids, laurel, thyme, almonds, water, saffron]))

  (def fisherManComesToFamilyEvent (JBakerHelper/createEvent "Fisherman caught a bunch of sea food and went shopping"
                                                             fishermansBag))
  (def liveClamsCleanupEvent (JBakerHelper/createEvent "Live clams cleanup" washedClams))
  (def brushMusselsEvent (JBakerHelper/createEvent "Brushed live mussels" brushedMussels))
  (def scrappedMusselsEvent (JBakerHelper/createEvent "Mussels have been scrapped" scrappedMussels))
  (def washedMusselsEvent (JBakerHelper/createEvent "Mussels have been washed" washedMussels))
  (def seaFoodThawedEvent (JBakerHelper/createEvent "Thaw seafood" monkFishThawed, squidsThawed))
  (def peelOnionsEvent (JBakerHelper/createEvent "Onions have been peeled" peeledOnions))
  (def slicedOnionsEvent (JBakerHelper/createEvent "Onions have been sliced" slicedOnions))
  (def onionsInCataplanaEvent (JBakerHelper/createEvent "Onions in Cataplana" cataplanaWithOnions))
  (def lightBakingSauteEvent (JBakerHelper/createEvent "Baked with Margarine and Olive oil" cataplanaWithSauteOnions))
  (def seasoningInRedEvent (JBakerHelper/createEvent "Seasoning with chili and peeled tomato" cataplanaWithRedSeasoning))
  (def low15MinuteCookEvent (JBakerHelper/createEvent "Cooked for 15 minutes in a closed lid" cataplanaLowHeat15Cooked))
  (def mashupMixInCataplanaEvent (JBakerHelper/createEvent "Mashed up tomato" cataplanaWithSmashedTomato))
  (def low10MinuteCookMixEvent (JBakerHelper/createEvent "Cooked further for 10 minutes with seaoned mix" cataplanaLowHeat10CookedWithExtraSeasoning))
  (def low15MinuteCookWithSeaFood (JBakerHelper/createEvent "Cooked further for 15 to 20 minutes with sea food" cataplanaDeAmeijoas))
  (def cleaningLiveClamsInteraction (JBakerHelper/createInteraction "Washing up clams" liveClams liveClamsCleanupEvent))
  (.withRequiredEvent cleaningLiveClamsInteraction fisherManComesToFamilyEvent)
  (def brushMusselsInteraction (JBakerHelper/createInteraction "Brush Mussels" mussels, brushMusselsEvent))
  (.withRequiredEvent brushMusselsInteraction fisherManComesToFamilyEvent)
  (def scrappedMusselsInteraction (JBakerHelper/createInteraction "Scrape Mussels" brushedMussels, scrappedMusselsEvent))
  (def washMusselsInteraction (JBakerHelper/createInteraction "Wash Mussels" scrappedMussels, washedMusselsEvent))
  (def thawSeaFoodInteraction (JBakerHelper/createInteraction "Thaw sea food" monkfish squids seaFoodThawedEvent))
  (.withRequiredEvent thawSeaFoodInteraction fisherManComesToFamilyEvent)
  (def peelOnionsInteraction (JBakerHelper/createInteraction "Peel onions" onions peelOnionsEvent))
  (.withRequiredEvent peelOnionsInteraction fisherManComesToFamilyEvent)
  (def sliceOnionsInteraction (JBakerHelper/createInteraction "Slice onions" peeledOnions slicedOnionsEvent))
  (def onionsInCataplanaInteraction (JBakerHelper/createInteraction "Dumping onion in cataplana" slicedOnions onionsInCataplanaEvent))
  (def lightBakingSauteInteraction (JBakerHelper/createInteraction "Sauteing with margarine and olive oil", cataplanaWithOnions, lightBakingSauteEvent))
  (def seasonCataplanInteraction (JBakerHelper/createInteraction "Seasoning the cataplana", cataplanaWithSauteOnions, seasoningInRedEvent))
  (def low15MinuteCookingInteraction (JBakerHelper/createInteraction "15 minutes on low heat", cataplanaWithRedSeasoning, low15MinuteCookEvent))
  (def mashupMixInCataplanaInteraction (JBakerHelper/createInteraction "Mashup mixing ingredients in cataplana pan", cataplanaLowHeat15Cooked, mashupMixInCataplanaEvent))
  (def seasonIngredients (ArrayList.
                           [cataplanaWithSmashedTomato, almonds, saffron, water, laurel, thyme]))
  (def low10MinuteCookMixInteraction (JBakerHelper/createInteraction "Cooking seasoned mix for 10 minutes"
                                                                     seasonIngredients low10MinuteCookMixEvent))
  (def low15MinuteCookingInteractionWithSeaFood (JBakerHelper/createInteraction "Cooking with the added seafood",
                                                                     cataplanaLowHeat10CookedWithExtraSeasoning monkFishThawed squidsThawed washedMussels low15MinuteCookWithSeaFood))
  (def recipeIteractions (ArrayList.
                           [cleaningLiveClamsInteraction, brushMusselsInteraction,
                            scrappedMusselsInteraction, washMusselsInteraction,
                            thawSeaFoodInteraction, peelOnionsInteraction,
                            sliceOnionsInteraction, onionsInCataplanaInteraction,
                            lightBakingSauteInteraction, seasonCataplanInteraction,
                            low15MinuteCookingInteraction, mashupMixInCataplanaInteraction,
                            low10MinuteCookMixInteraction, low15MinuteCookingInteraction,
                            low15MinuteCookingInteractionWithSeaFood]))
  (def recipeEvents (ArrayList. [fisherManComesToFamilyEvent]))
  (def recipe (JBakerHelper/createRecipe "Cataplana de ameijoas" recipeIteractions recipeEvents))
  (def compiledRecipe (RecipeCompiler/compileRecipe recipe))
  (def result (.getRecipeVisualization compiledRecipe))
  (println result)
  )
