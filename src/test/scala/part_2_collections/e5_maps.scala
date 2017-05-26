package part_2_collections

import support.HandsOnSuite


/**
*   As other languages, a map of type Map[Key, Value] is a data structure which associates a key of type Key
*   to a value of type Value.
*
*   http://www.scala-lang.org/api/current/index.html#scala.collection.concurrent.Map
*/

class e5_maps extends HandsOnSuite {

  exercice("It's easy to create a map!") {
    val myMap = Map("PA" -> "Paris", "BE" -> "Besançon", "BL" -> "Belfort")
    myMap.size should be(3)
    myMap.head should be("PA" -> "Paris")
    // There is no order in a map
    val myMapBis = Map("BE" -> "Besançon", "BL" -> "Belfort", "PA" -> "Paris")
    myMap.equals(myMapBis) should be(true)
    // impact of duplicated keys
    val myOtherMap = Map("PA" -> "Paris", "BE" -> "Besançon", "PA" -> "Palo Alto")
    myOtherMap.size should be(2)
    myOtherMap("PA") should be("Palo Alto")
  }

  /**
  * Map addition is done via `+` operator
  */
  exercice("Map addition") {
    val myMap = Map("PA" -> "Paris", "BE" -> "Besançon", "NA" -> "Nantes")
    // Adding one element
    val aNewMap = myMap + ("BL" -> "Belfort")

    myMap.contains("BL") should be (false) // Maps are immutable
    aNewMap.contains("BL") should be(true)
  }

  /**
  * Some operations on maps
  */
  exercice("Access/Delete elements in a Map") {
    val myMap = Map("PA" -> "Paris", "BE" -> "Besançon", "NA" -> "Nantes", "BL" -> "Belfort")

    // removing a key
    val aNewMap = myMap - "NA"
    aNewMap.contains("NA") should be(false)
    // removing multiple keys
    val aNewOtherMap = myMap -- List("BE", "BL")
    aNewOtherMap.contains("BE") should be(false)
    aNewOtherMap.contains("BL") should be(false)
    // An exception is raised when a key is absent
    intercept[NoSuchElementException] {
      aNewOtherMap("BL") should be("Belfort")
    }
    val maybeCity = aNewOtherMap.get("BL")
    maybeCity should be (None)
  }

}
