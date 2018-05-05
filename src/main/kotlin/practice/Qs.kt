package practice

fun manyTimesString(s: String, i: Int): String {
  tailrec fun loop(stringSoFar: String, i: Int): String {
    return if (i == 0) stringSoFar else loop(stringSoFar + s, i - 1)
  }
  return loop (s, i - 1)
}

data class SimpleTime(val hours: Int, val minutes: Int)
val t = SimpleTime(hours=5, minutes=30)
