package practice
import java.lang.reflect.Method

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
class ClothesWasher(val modelName: String = "ACME", val capacity: Double = 1.0) {
  constructor (modelName: String) : this(modelName, 1.0)
  constructor (capacity: Double) : this("ACME", capacity)
  override fun toString():String = "$modelName + $capacity"
}

// q5
data class Person(
  val firstName: String, val lastName: String, val email: String)

// q6
val q6func = { temperature: Int, low: Int, high: Int ->
  temperature >= low && temperature <= high }

// q7
fun sumIt(vararg elems: Int): Int =
  elems.reduce{acc, elem -> acc + elem}

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

fun q22Answer = """
a. GoF Structural DPs:
    - Adapter
    - Facade
    - Mediator
    - Visitor
    - Bridge
    - Composite
    - Chain of Responsibility
b. MVC solves the problem of tight coupling between the UI, business logic
    and backend.
    View: an Observer that watches the Model for changes and renders them
        to the screen
    Model: A data structure holding structured data for the application,
        often conceptualised as OO objects for business domain
    Controller: a pseudo-facade designed to give the client an endpoint (usually
        HTTP/RESTful) to call to update the Model
c.
"""
