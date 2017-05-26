package part_2_collections

import support.HandsOnSuite

/**
*  In scala we totally avoid using null (while it still exists for Java compatibility).
*  Instead of using null we use the Option type.
*
*   Quelques liens :
*     - http://www.scala-lang.org/api/current/index.html#scala.Option
*/

class e7_option extends HandsOnSuite {

  exercice("None is...None") {
   None should be(None)
  }

  exercice("None is the empty Option") {
    None.isEmpty should be(true)

    val optional: Option[String] = None
    optional.isEmpty should be(true)
    optional should be(None)
  }

  exercice("Some is the filled Option") {
    val optional: Option[String] = Some("Some Value")
    (optional == None) should be(false)
    optional.isEmpty should be(false)
  }

  exercice("Option.getOrElse can be used to extract the Option value, by providing a default value if the Option is empty") {
    val optional: Option[String] = Some("Some Value")
    val optional2: Option[String] = None
    optional.getOrElse("No Value") should be("Some Value")
    optional2.getOrElse("No Value") should be("No Value")
  }

}
