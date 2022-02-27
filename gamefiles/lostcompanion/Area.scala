package gamefiles.lostcompanion
import scala.collection.mutable.Map
import scala.collection.mutable.Buffer
import scala.math.max

class Area(var name: String, var description: String, val vehicleNeeded: Option[Vehicle]) {

  private val neighbors = Map[String, Area]()
  private val persons = Map[String, Person]()
  private val vehicles = Map[String, Vehicle]()
  private var money    = 0
  //private val items    = Map[String, Vehicle]()

  def addPerson(person: Person) = persons += person.name -> person
  def removePerson(personName: String) = persons.remove(personName)
  def contains(personName: String) = persons.contains(personName)
  def personList = persons

  def vehicleList = vehicles
  def addVehicle(vehicle: Vehicle) = vehicles += vehicle.keyword -> vehicle
  def getVehicle(vehicleName: String) = vehicles.get(vehicleName)


  /** Edits the money in the area. Returns the amount taken or added. */
  def editMoney(amount: Int) = {
    val oldAmount = money
    money = max(oldAmount + amount, 0)
    max(oldAmount + amount, 0) - oldAmount
  }
  def amount = money


  /** Returns the area that can be reached from this area by moving in the given direction. The result
    * is returned in an `Option`; `None` is returned if there is no exit in the given direction. */
  def neighbor(direction: String) = this.neighbors.get(direction)

  /** Adds an exit from this area to the given area. The neighboring area is reached by moving in
    * the specified direction from this area. */
  def setNeighbor(direction: String, neighbor: Area) = {
    this.neighbors += direction -> neighbor
  }

  /** Adds exits from this area to the given areas. Calling this method is equivalent to calling
    * the `setNeighbor` method on each of the given direction--area pairs.
    * @param exits  contains pairs consisting of a direction and the neighboring area in that direction
    * @see [[setNeighbor]] */
  def setNeighbors(exits: Vector[(String, Area)]) = {
    this.neighbors ++= exits
  }



  def fullDescription = {
    val exitList = "\n\nDirections available: " + this.neighbors.keys.mkString(" ")
    val personList = if (persons.nonEmpty) {
      "\nPersons near you: " + persons.keys.mkString(", ")
    } else {
      ""
    }
    val coins = {
      if (money > 0) {
        s"\nMoney here: $money coins"
      } else {
        ""
      }
    }

    this.description + personList + coins + exitList
  }


}


