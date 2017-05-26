package part_2_collections

import support.HandsOnSuite

/**
*   A set is a collection of unique elements.
*
*   Some links:
*     - http://www.scala-lang.org/api/current/index.html#scala.collection.immutable.Set
*     - http://docs.scala-lang.org/overviews/collections/sets.html
*/

class e6_sets extends HandsOnSuite {

  /**
  * Creating a Set
  */
  exercice("Creating a Set") {
    val mySet = Set("Sud", "Est", "Ouest", "Nord")
    mySet.size should be(4)

    val myOtherSet = Set("Sud", "Est", "Sud", "Nord")
    myOtherSet.size should be(3)
  }

  /**
  * Operations on Sets: operators +, -, --, method contains
  */
  exercice("Operations on Sets") {
    // Addition
    val mySet = Set("Sud", "Est", "Sud")
    val aNewSet = mySet + "Nord"

    aNewSet.contains("Nord") should be(true)

    // Suppression
    val mySetBis = Set("Sud", "Est", "Ouest", "Nord")
    val aNewSetBis = mySetBis - "Nord"
    // method contains
    aNewSetBis.contains("Nord") should be(false)

    // Multiple suppressions
    val myOtherSet = Set("Sud", "Est", "Ouest", "Nord")
    val aNewOtherSet = myOtherSet -- List("Ouest", "Nord")

    aNewOtherSet.contains("Nord") should be(false)
    aNewOtherSet.contains("Ouest") should be(false)
  }
}
