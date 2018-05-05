package test
import practice.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class PracticeTests {
  @Test
  fun t1() {
    val m1 = manyTimesString("abc", 3)
    assertEquals("abcabcabc", m1)
  }

  @Test
  fun t2() {
    assertEquals(true, false)
  }

}
