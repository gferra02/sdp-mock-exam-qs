package test
import practice.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class PracticeTests {
  @Test
  fun q1() {
    val m1 = manyTimesString("abc", 3)
    assertEquals("abcabcabc", m1)
  }

  @Test fun q2() {
    val t = SimpleTime(hours=5, minutes=30)
    assertEquals(5, t.hours)
    assertEquals(30, t.minutes)
  }
}
