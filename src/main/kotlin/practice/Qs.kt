package practice

// q1
fun manyTimesString(s: String, i: Int): String {
  tailrec fun loop(stringSoFar: String, i: Int): String {
    return if (i == 0) stringSoFar else loop(stringSoFar + s, i - 1)
  }
  return loop (s, i - 1)
}

// q2
data class SimpleTime(val hours: Int, val minutes: Int)
val t = SimpleTime(hours=5, minutes=30)

// q3
data class Item(val name: String, val price: Double) {
  fun cost(
    grocery: Boolean = false,
    medication: Boolean = false,
    taxRate: Double = 0.10): Double {
      return if (grocery || medication) price else price * (1 + taxRate)
    }
}

// q4
class ClothesWasher(modelName: String = "ACME", capacity: Double = 1.0) {
  constructor (modelName: String) : this(modelName, 1.0)
  constructor (capacity: Double) : this("ACME", capacity)
}

// q5
data class Person(
  val firstName: String, val lastName: String, val email: String)
