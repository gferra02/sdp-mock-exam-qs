package practice
import java.lang.reflect.Method

// Q1
// Create a method manyTimesString that takes a String and an Int as arguments
// and returns the String duplicated that many times. Print your answer. Satisfy the
// following:
// val m1 = manyTimesString("abc", 3)
// assert("abcabcabc" == m1,"Your message here")
// val m2 = manyTimesString("123", 2)
// assert("123123" == m2, "Your message here")

// Q1 With iteration
fun manyTimesString(str: String, times: Int) : String {
  var result = ""
    if (times == 0) result = str
  for (i in 1..times) {
    result += str
  }
  return result
}

// Q1 With recursion
fun manyTimesStringRec(str: String, times: Int) : String {
    var result = str
    if (times > 1) result += manyTimesStringRec(result, times - 1)

    return result
}

// q1
//fun manyTimesString(s: String, i: Int): String {
//  tailrec fun loop(stringSoFar: String, i: Int): String {
//    return if (i == 0) stringSoFar else loop(stringSoFar + s, i - 1)
//  }
//  return loop (s, i - 1)
//}

// Q2
// Define a class SimpleTime that takes two arguments: an Int that represents hours,
// and an Int that represents minutes. Use named arguments to create a SimpleTime
// object.
// val t = new SimpleTime(hours=5, minutes=30)
// t.hours produces 5
// t.minutes produces 30

data class SimpleTime (val hours: Int, val minutes: Int)
val t = SimpleTime(hours = 5, minutes = 30)

// Q3
// Demonstrate that named and default arguments can be used with methods. Create a
// class Item that takes two class arguments: A String for name and a Double for price.
// Add a method cost which has named arguments for grocery (Boolean), medication
// (Boolean), and taxRate (Double). Default grocery and medication to false, taxRate
// to 0.10.
// In this scenario, groceries and medications are not taxable. Return the total cost of
// the item by calculating the appropriate tax. Satisfy the following:
// val flour = new Item(name="flour", 4)
// flour.cost(grocery=true) is 4
// val sunscreen = new Item(name="sunscreen", 3)
// sunscreen.cost() is 3.3
// val tv = new Item(name="television", 500)

class Item (val name: String, var price: Double) {
    fun cost(grocery: Boolean = false, medication: Boolean = false, taxrate: Double = 0.10) : Double {
        if (grocery || medication) {
            price
        } else {
            price += price * taxrate
        }

        return price
    }
}

// q3
//data class Item(val name: String, val price: Double) {
//  fun cost(
//    grocery: Boolean = false,
//    medication: Boolean = false,
//    taxRate: Double = 0.10): Double {
//      return if (grocery || medication) price else price * (1 + taxRate)
//    }
//}

// Q4
// Create a class called ClothesWasher with a default constructor and two auxiliary
// constructors, one that specifies modelName (as a String) and one that specifies
// capacity (as a Double).

class ClothesWasher (val modelName: String = "Candy", val capacity: Double = 7.0) {
    constructor(modelName: String) : this(modelName, 9.0)
    constructor(capacity: Double) : this("Whirpool", capacity)

    override fun toString(): String = "$modelName $capacity"
}

// Q5
// Create a case class to represent a Person in an address book, complete with Strings
// for the name and a String for contact information.
// Satisfy the following:
// val p = Person("Jane", "Smile","jane@smile.com")
// p.first is "Jane"
// p.last is "Smile"
// p.email is "jane@smile.com"

data class Person (val firstName: String, val lastName: String, val email: String) {
    override fun toString(): String = "$firstName $lastName, $email"
}

// Q6
// Create an anonymous function with three arguments ( temperate, low, and high).
// The anonymous function will return true if the temperature is between high and
// low, and false otherwise. Assign the anonymous function to a def and then call your
// function.
// Satisfy the following:
// between(70, 80, 90) is false
// between(70, 60, 90) is true

val anonFunc = {
    temperature : Int, low : Int, high : Int -> { temperature > low && temperature < high }
}

val q6func = { temperature: Int, low: Int, high: Int ->
    temperature >= low && temperature <= high }

// Q7
// Use reduce to implement a method sumIt that takes a variable argument list and sums
// those arguments.
// For example,
// sumIt(1, 2, 3) is 6
// sumIt(45, 45, 45, 60) is 195

fun sumIt (vararg listItem: Int) : Int = listItem.reduce{ acc, listItem -> acc + listItem}

fun main(args: Array<String>) {
    //Q1
    println("Q1 with iteration (times 3): ${manyTimesString("abs", 3)}")
    println("Q1 with iteration (times 0): ${manyTimesString("abs", 0)}")
    println("Q1 with recursion (times 3): ${manyTimesStringRec("abs", 3)}")
    println("Q1 with recursion (times 0): ${manyTimesStringRec("abs", 0)}")

    //Q2
    val t = SimpleTime(hours = 5, minutes = 30)
    // Added toString() just to print it out
    println(t.hours.toString() + ":" + t.minutes.toString())

    //Q3
    val flour = Item("flour", 4.0)
    println(flour.cost(grocery=true))
    val sunscreen = Item("sunscreen", 3.0)
    println(sunscreen.cost())
    val tv = Item("television", 500.0)
    println(tv.cost(taxrate = 0.06))

    //Q4
    val washer = ClothesWasher("Bosch")
    val washer1 = ClothesWasher(11.0)
    val washer2 = ClothesWasher()
    println(washer)
    println(washer1)
    println(washer2)

    // Q5
    val person = Person("Jane", "Smith", "jane.smith@email.dot")
    println(person)

    // Q6
    anonFunc(23, 18, 35)

    // Q7
    println(sumIt(1, 2, 3))
}


// q8
val q8Answer = """
  |The pattern is Adapter - the Complex object's from* methods
  |allow a client using a different coordinate system, to
  |interact with Complex numbers, and the Complex companion
  |object does the job of conversion on behalf of the client.
  |It's not facade as it doesn't simplify the API required from
  |the client.
""".trimMargin()

val q9Answer = """
  Working in kotlin, I would just change the 'class' keyword to 'object.'
  Working in Java, I would a) make the constructor private, b) provide
  a static method getInstance(), c) create a static private field to
  d) hold the singleton instance of the class, e) decide whether to
  eagerly or lazily initialize. If eager, use an init {} block in the
  class, so when the class is initialized, the static private field will
  be populated by constructing an instance. If lazy, place null in the
  field, and construct the object the first time a client calls
  getInstance
  """.trimIndent()

val q10Answer = """
  The Visitor pattern can assign more functionality to elements
  without subclassing them.
  """.trimIndent()

// q10 example
object Q10 {
  interface Visitor {
    fun visit(v: Visitee): Int
  }

  class Visitee(serialNumber: Int) {
    public val serialNumber: Int = serialNumber
    fun double(): Int = serialNumber * 2
    fun accept(v: Visitor) = v.visit(this)
  }

  class TripleVisitor : Visitor {
    override fun visit(v: Visitee): Int = v.serialNumber * 3
  }
}

val q11Answer = """
  Composite pattern is ideal for situations where individual items, and
  collections of items, can be represented in the same way by the same
  API, so the client can delegate to the Composite interface the job
  of performing operations on other individuals or collections
  """.trimIndent()

object Q11 {
  interface FileHandle {
    val name: String
    val content: String
  }

  data class File(
    override val name: String,
    override val content: String) : FileHandle

  class Directory(
    override val name: String,
    val files: List<FileHandle>) : FileHandle {
    override val content: String
      get() = files.map{ it.name + ":\n" + it.content }.joinToString("\n")
  }
}

val q12Answer = """
  The definition of Adapter is that it changes the interface to one
  that the client is familiar with. If the interface is unchanged,
  then the Adapter is not acting as such. It could well act as another role
  instead - such as a Proxy to add e.g. logging, or an authorization
  element to stop the client calling methods without login or
  certain privileges.
  """.trimIndent()

val q13Answer = """
  The possibilities are Visitor or Composite. I would use Visitor
  as it provides the ability to solve both problems at once.
  ItemInterface should include an accept() method, to accept a visitor.
  All 3 implementations should implement accept() as calling v.visit(this)
  on the passed Visitor object.
  a. A TotalPagesVisitor can visit all the ItemInterface-implemented
  items in the library. For books it adds pages to its count, for
  magazines it merely visits all their articles, and for articles, it
  adds all pages to its count. It returns a total page count.
  b. Similar to a, a visitor can keep a hashSet of previously-seen
  authors. It can add authors of Books to this set, search all Articles
  of Magazines, and add all Article authors to its set. Then it can return
  the size of the set.
  """.trimIndent()

val q14Answer = """
  The decorator pattern provides a way to add an arbitrary number of
  features, an arbitrary number of times, to objects. It uses
  recursive composition, with all variants sharing same interface,
  so the client can always interact with the same API no matter how
  nested the object becomes.

  For example, if a coffee shop serves coffee with different variations
  on adding cream, milk, marshmellows, cinnamon and sugar, creating
  a subclass hierarchy for all those possibilities would result in an
  explosion of different implementations to manage. Instead, we can simply
  have one class per added condiment (e.g. CoffeeCinnamon), have them
  all fulfil the 'Coffee' interface, and then have them each accept
  a member which itself fulfils the Coffee interface. Then we can
  wrap CoffeeCinnamon(CoffeeCream(CoffeeMarshmallows))) to represent
  a coffee with those 3 condiments. CoffeeMarshmallows needs to have
  null for its Coffee member field.
  """.trimIndent()

val q15Answer = """
  There is both an abstraction and an implementation to vary here. As such,
  I would use the bridge pattern. This would ensure that I could vary one
  hierarchy, e.g. the publication format abstraction, separately from the other
  hierarchy, the media implementation, without resulting in an explosion
  of different subclasses.
  e.g.:
  interface PubFormat -------------> class PubFormatMedia

  Interface book extends PubFormat
  Interface article extends PubFormat
  Interace leadlet extends PubFormat

  class CD extends PubFormatMedia
  class DVD extends PubFormatMedia
  class Website extends PubFormatMedia
  """.trimIndent()

val q16Answer = """
  Provide a simplified interface which is opinionated, and offers simplified,
  reduced functionality from a complex subsystem, to a client whose particular
  needs are well understood.""".trimIndent()

val q17Answer = """
  Visitor pattern. The defined Visitor implementations
  contain different logic which they bring to the context,
  and hence new visitors can be written to add
  new functionality. TODO what do I say for total of 5 marks?!?!
  """.trimIndent()

val q18Answer = """
  client --> photoProcessor --> photoRepository
  photoProcessor is a Proxy which checks the client's permissions before
  allowing certain methods to succeed - i.e. download / comment
  """.trimIndent()

val q19Answer = """
  1. Encapsulation
  2. Inheritance
  3. Polymorphism
  """

val q20Answer = """
  a. Creational patterns:
  - builder
  - factory method
  - abstract factory
  - Flyweight
  - Clone?

  b. Singleton pattern:
  Solves problem of not wasting memory for an object that is only needed once,
  and of ensuring the object isn't created multiple times even in a
  multithreaded scenario.

  c. Singleton pattern interface:

  interface MySingleton
  private MySingleton instance;
  public static MySingleton getInstance() // returns instance of MySingleton,
    guaranteed to be only 1
  """

fun q21ReflectionExample(obj: Any) {
  val c: Class<*> = obj::class.java
  val methods: Array<Method> = c.getMethods()
  methods.forEach { m ->
      val exceptions = m.getExceptionTypes().toList()
      val paramTypes = m.getParameterTypes().toList()
      println("${m.getName()}, $exceptions, $paramTypes, ${m.getReturnType()}")
  }
}

object Main {
  @JvmStatic
  fun main(args: Array<String>) {
    q21ReflectionExample("Busses")
    println("Running")
  }
}

val q22Answer = """
a. GoF Structural DPs:
    - Adapter
    - Bridge
    - Composite
    - Decorator
    - Facade
    - Flyweight
    - Proxy
Also Creational DPs:
    - Abstract Factory
    - Factory Method
    - Builder
    - Prototype
Finally Behavioural DPs:
    - Chain of Responsibility
    - Command
    - Interpreter
    - Iterator
    - Mediator
    - Memento
    - Observer
    - State
    - Strategy
    - Template Method
    - Visitor
b. MVC solves the problem of tight coupling between the UI, business logic
    and backend.
    View: an Observer that watches the Model for changes and renders them
        to the screen
    Model: A data structure holding structured data for the application,
        often conceptualised as OO objects for business domain
    Controller: a pseudo-facade designed to give the client an endpoint (usually
        HTTP/RESTful) to call to update the Model
c. Sensu/Uchiwa. View is NodeJS frontend, an Observer of Sensu Model via
the Sensu API. Sensu API also acts as Controller - changes made in Uchiwa
are submitted to Sensu API, and Uchiwa will not update UI till its next
poll. Also Sensu API can be hit directly by other clients.
"""

val q23Answer = """
a. Loose Coupling is related to the SOLID principle of Depenency Inversion.
It stipulates that concrete implementations should not depend on each-other -
instead, both should depend on abstractions. This means that objects should generally
not instantiate other concrete objects using new - instead, they should
depend on interfaces, which change less often than implementation and are
a level of abstraction higher.

b. Of course, without 'New' you need a way to actually get objects - a DI framework
is a good solution for this, and tidier than an initialization script that
creates all required objects (but must work out their dependency orders).
E.g.
"""
interface MySimpleInterface
class MyComplexObject: MySimpleInterface

class q23bObjExample  {
    val obj: MySimpleInterface = MyComplexObject()
}

// The class has to create its own ComplexObject. It would be simpler for
// e.g. Spring to instantiate an object fulfilling MySimpleInterface, for it.

val q24Answer = """
inheritance and delegation
"""
// q28
typealias Matrix = List<List<Int>>
fun checkBlock(m: Matrix): Boolean {
    val l: List<Int?> =
        m.flatMap {
            l -> l.map {
                e -> e
            }
        }.filter { it <= 9 && it >= 1 }
    return l.toSet().size == 9
}

val q34Answer = """
Use proxy pattern. System works fine, and the addition is to superimpose
something on the output of the original. As we are keeping same interface,
cannot be adapter. Proxy can superimpose extra functionality before returning
result to caller.
"""

// q35
interface Instrument  {
    val lowRange: Int
    val highRange: Int
    fun play(): Unit = println("Make sound")
}
interface StringInstrument: Instrument {
    override fun play() = println("Twang!")
    fun tune(): Unit
}
interface PercussionInstrument : Instrument {
    override fun play() = println("Thump!")
    fun strike(): Unit
}
class StringPercussionInstrument(override val lowRange: Int, override val highRange: Int)
    : StringInstrument, PercussionInstrument {
    override fun play() {
        super<StringInstrument>.play()
        super<PercussionInstrument>.play()
    }
    override fun tune() = println("Pull the string, re-fasten the pole")
    override fun strike() = println("Beat and try not to fall over")
}

// q38
typealias Duel = Pair<String, String>
fun duels(dwarves: List<String>) : List<Duel> {
  tailrec fun duels(dwarves: List<String>, opponent: Int, acc: List<Duel>): List<Duel> {
    return when {
      dwarves.size == 2 -> acc + Pair(dwarves[0], dwarves[1])
      opponent < dwarves.size -> {
        duels(dwarves, opponent + 1, acc + Pair(dwarves[0], dwarves[opponent]))
      }
      // opponent == dwarves.size
      else -> {
        duels(dwarves.drop(1), 1, acc)
      }
    }
  }
  return duels(dwarves, 1, emptyList<Duel>())
}

fun winner(duels: List<Pair<Duel, Int>>): String {
  fun winner(duels: List<Pair<Duel, Int>>, scoreMap: Map<String, Int>): String {
    // If duels is empty, we're done - return top scorer
    if (duels.isEmpty()) {
      return scoreMap.maxBy({ it.value })?.key ?: "No Contestants"
    }
    else {
      val (fighters: Pair<String, String>, result: Int) = duels[0]
      val victor: String = if (result == 1) fighters.first else fighters.second
      val victorScore: Int = scoreMap.getOrDefault(victor, 0) + 1
      return winner(duels.drop(1), scoreMap + (victor to victorScore))
    }
  }
  return winner(duels, emptyMap<String, Int>())
}

// Eileen 23-28
// Alun 29-34
// matt 34,35, 38,39
