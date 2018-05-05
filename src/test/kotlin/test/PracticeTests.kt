package test
import practice.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue

class PracticeTests {
  // For comparing Doubles - we don't care if they are slightly out
  // due to floating point arithmetic rounding.
  private infix fun Double.nearEnough(d2: Double) = this - d2 < 0.001

  @Test fun q1() {
    val m1 = manyTimesString("abc", 3)
    assertEquals("abcabcabc", m1)
  }

  @Test fun q2() {
    val t = SimpleTime(hours=5, minutes=30)
    assertEquals(5, t.hours)
    assertEquals(30, t.minutes)
  }

  @Test fun q3() {
    val flour = Item(name="flour", price=4.0)
    assertEquals(4.0, flour.cost(grocery=true))
    val sunscreen = Item(name="sunscreen", price=3.0)
    assertTrue(sunscreen.cost() nearEnough 3.3)
    val tv = Item(name="television", price=500.0)
    assertTrue(tv.cost(taxRate = 0.06) nearEnough 530.0)
  }
}
