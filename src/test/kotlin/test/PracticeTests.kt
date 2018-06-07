package test
import practice.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse

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

  @Test fun q4() {
    // No assertions - just checking it compiles
    ClothesWasher("Microsoft")
    ClothesWasher(11.0) // turn it up to 11
    ClothesWasher("Microsoft", 11.0)
  }

  @Test fun q5() {
    val p = Person("Joe", "Bloggs", "j@b.com")
    assertTrue(
      p.firstName == "Joe" &&
      p.lastName == "Bloggs" &&
      p.email == "j@b.com")
  }

  @Test fun q6() {
    assertEquals(true, q6func(30,20,40))
    assertEquals(false, q6func(15,20,40))
  }

  @Test fun q7() {
    assertEquals(6, sumIt(1,2,3))
  }

  @Test fun q10() {
    val visitResult = Q10.TripleVisitor().visit(Q10.Visitee(10))
    assertEquals(30, visitResult)
  }

  @Test fun q11() {
    val resolvConfFile = Q11.File("resolv.conf", "nameserver 8.8.8.8")
    val passwordFile = Q11.File("passwd", "mralph:superCool:1001")
    val etcDir = Q11.Directory("/etc", listOf(resolvConfFile, passwordFile))
    val tmpDir = Q11.Directory("/tmp", emptyList<Q11.FileHandle>())
    val rootDir = Q11.Directory("/",listOf(etcDir, tmpDir))
    assertTrue(rootDir.content.contains("nameserver"))
  }

  @Test fun q28() {
    assertTrue(checkBlock(listOf(listOf(1,2,3),listOf(4,5,6),listOf(7,8,9))))
    assertFalse(checkBlock(listOf(listOf(1,2,3),listOf(3,5,6),listOf(7,8,9))))
  }

  @Test fun q35() {
    val s = StringPercussionInstrument(1,20)
    assertEquals(1, s.lowRange)
  }

  @Test fun q38() {
    val dwarfList = listOf("A","B","C")
    val result: List<Duel> = duels(dwarfList)
    val expected: List<Duel> = listOf(Pair("A", "B"), Pair("A", "C"), Pair("B", "C"))
    assertEquals(expected, result)
  }

  @Test fun q39() {
    val results = listOf(Pair(Pair("Thorin","Gloin"),1), Pair(Pair("Thorin","Balin"), -1), Pair(Pair("Gloin","Thorin"), -1),
            Pair(Pair("Gloin","Balin"),1), Pair(Pair("Balin","Thorin"), -1), Pair(Pair("Balin","Gloin"), 1))
    val expectedWinner = "Thorin"
    assertEquals("Thorin", winner(results))
  }

}
