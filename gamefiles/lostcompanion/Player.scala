package gamefiles.lostcompanion
import scala.collection.mutable.Map
import scala.io.StdIn._
import scala.math.max
import scala.util.Random

class Player(startingArea: Area) {

  private var currentLocation = startingArea        // gatherer: changes in relation to the previous location
  private var quitCommandGiven = false              // one-way flag
  private var vehicles = Map[String, Vehicle]()
  private val inventorySize = 3
  private var money = 0

  def moneyAmount = money
  def location = this.currentLocation
  def hasQuit = this.quitCommandGiven
  def vehicleList = vehicles


  def wallet = s"You have $money coins in your wallet."
  def inventory = {
    if (vehicles.nonEmpty) {
      vehicles.keys.mkString("\n") + s"\n\nSpace used: ${vehicles.size}/$inventorySize\n\n$wallet"
    } else {
      "You are carrying nothing except a wallet.\n" + wallet
    }
  }
  def cast(item: String) = {
    val success = vehicles.remove(item)
    if (success.isDefined) {
      "Done. You're not gonna need that anyways."
    } else {
      "You don't have anything like that."
    }
  }


  /** Takes a positive integrer as a parameter. If there is money in the current location, takes given amount of it. */
  def take(amount: String) = {
    val option = amount.toIntOption
    if (option.isDefined) {
        if (option.get > 0) {
          val moneyTaken = currentLocation.editMoney(-option.get)
            this.money -= moneyTaken
          if (moneyTaken != 0) {
            s"You added ${-moneyTaken} coins to your wallet. You now have total of $money coins."
          } else {
            s"You can't take $amount coins."
          }
        } else {
          s"You can't take $amount coins."
        }
    } else {
      "The amount has to be an integer."
    }
  }

  def pay(amount: Int) = {
      val oldAmount = money
      money = max(oldAmount + amount, 0)
      val paid = oldAmount - money
    }


  /** Command 'go' uses this in particular locations to empty the player's inventory. */
  private def loseAll() = {
    vehicles = Map[String, Vehicle]()
    money = 0
  }
  /** Makes the player move to the given direction, if he can do so.
    * To go to some areas player has to have a certain vehicle/item (in the code they are referenced as vehicles). */
  def go(direction: String) = {
    val destination = this.location.neighbor(direction)
    def canGo = {
      if (destination.isDefined) {
        if (destination.get.vehicleNeeded.nonEmpty) {
          vehicles.contains(destination.get.vehicleNeeded.get.name)
        } else true
    } else false
    }

    if (canGo) this.currentLocation = destination.getOrElse(this.currentLocation)
    if (currentLocation.name == "Deep wilderness" || currentLocation.name == "Rivershore") loseAll()

    if (destination.isDefined && canGo) {
      "You go " + direction + "."
    } else if (destination.isDefined && !canGo) {
      "You need a vehicle or an item to go there."
    } else {
      "You can't go " + direction + "."
    }
  }


  /** Starts a conversation with the desired person, if that person is at the same location as the player.
    * If the player answers yes to a question, the conversation keeps going.
    * Some conversations have a cost (defined within each instance of Person), and if player answers yes to the last question, that amount is removed (or added) from his wallet.*/
  def talk(personName: String) = {
    if (currentLocation.contains(personName)) {
      val lines = currentLocation.personList(personName).lines
      println(lines.head)
      var linesLeft = lines.tail
      def answer = readLine("\n- ").toLowerCase.trim

      while (linesLeft.length > 1 && answer.contains("yes")) {
        println("\n" + linesLeft.head)
        linesLeft = linesLeft.drop(1)
      }
      if(linesLeft.length == 1) {
        if (answer.contains("yes")) {
          if(personName != "Joker") {
            if (money >= - currentLocation.personList(personName).cost) {
              pay(currentLocation.personList(personName).cost)
              "\n" + linesLeft.head
            } else {
              "\n- That's not enough money."
            }
          } else {
            pay(- money)
            "\n" + linesLeft.head
          }
        } else {
          "\n- Okay, see ya."
        }
      } else {
        "\n- Okay, bye."

      }

    } else {
      "Who?"
    }
  }


  private var saySuccessfully = false
  def said = saySuccessfully
/** This command is used to give the player vehicles. Every vehicle has a keyword, and by saying that, the vehicle is added to the players inventory.
  * It is used in game after conversations: Some conversations lead to player having to say something to get a vehicle.
  * For example, Stranger asks player to say thanks, and if the player's answer contains keyword 'thank', boat is added to players inventory.
  */
  def say(line: String) = {
    saySuccessfully = false
    val lowLine = line.toLowerCase
    if (location.vehicleList.nonEmpty && lowLine.contains(location.vehicleList.head._2.keyword)) {
      if (vehicles.size < inventorySize) {
        val taken = location.getVehicle(location.vehicleList.head._2.keyword)
        this.vehicles += taken.get.name -> taken.get
        saySuccessfully = true
        "\n" + taken.get.line
      } else {
        "Sorry, but you have no room in your inventory. Use command 'cast' to throw used items or vehicles away and then answer again."
      }
    } else {
      if (location.personList.nonEmpty) {
        "\n- Sorry, what?"
      } else {
        "Who are you talking to?"
      }
    }
  }

  def help = {
    "____________________________________________\n" +
      "HERE ARE ALL THE COMMANDS AVAILABLE IN THE GAME: (Don't type the quotation marks!)\n\n" +
      "'go [direction]'       Will move your character. Possible directions are (depending on your location): north, east, south, west, inside, outside.\n" +
      "'inventory'            Shows the items and vehicles you're carrying.\n" +
      "'cast [item]'          Removes desired item from your inventory and frees up space for new stuff.\n" +
      "'take [amount]'        If there's money at your location, you can take it.\n" +
      "'wallet'               Shows how much money you have.\n" +
      "'talk [person]'        Will start a conversation with desired person, if he is near you.\n\n" +
      "DURING A CONVERSATION: If there is a dash (-), it implies that someone is talking, so it is a conversation.\n" +
      "'yes/no'               Can be used to answer yes/no -type questions, 'yes' keeps the conversation going.\n" +
      "'- [your line]'        If you wanna say something else than yes or no, remember to put a dash and spacebar (- ) first, like shown here.\n" +
      "                          Note: If the dash is already printed, only yes and no are valid lines.\n\n" +
      "''                     If you need to see the description of the area again, just press enter.\n" +
      "'hint'                 Displays a single randomized hint.\n" +
      "'quit'                 Quits the game.\n" +
      "____________________________________________"
  }



  def hint = {
    val hints = Vector("You have room for only 3 items/vehicles in your inventory.", "You should cast used vehicles with command 'cast'.", "You can get valuable information by talking to people, so pay close attention.", "Not all of the persons have good intentions. Watch out.", "If a person expects you to say something, they'll make it pretty clear. Otherwise the conversation is ended.")
    Random.shuffle(hints).head
  }

  /** Prints the description of the area again. */
  def nothing = ""

  def quit() = {
    this.quitCommandGiven = true
    ""
  }
}
