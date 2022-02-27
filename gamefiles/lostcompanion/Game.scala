package gamefiles.lostcompanion

class Game {


  val title = s"\nFRODO'S LOST COMPANION"

  val boat = new Vehicle("boat", "thank", "- Thank you. You can now head south to the river with your boat.")
  val horse = new Vehicle("horse", "aragorn", "- Oh, you are friends with Aragorn? Any friend of Aragorn is a friend of mine.\n  In that case, here's a horse for you. Just head south and you'll be on your way.")
  val badge = new Vehicle("badge", "letter", "-  Yeah, that's right. Okay, here we are. You can now go inside, when they see this badge they'll let you in.")
  val letter = new Vehicle("letter", "frodo", "- You are Frodo Baggins? Welcome, it's an honor to meet you. Aragorn has been waiting for you.\n  In fact, when you go inside, take this letter with you, it's a message for him.\n  If someone asks, tell them you're delivering a letter.")

  val shire         = new Area("Shire", "You are in the middle of the Shire. It's quite a hustle here, it seems like every hobbit has something to do today.\nIn the north you see the Hobbiton and in the south a road passing the Shire.", None)
  val hobbitonY     = new Area("Yard of Hobbiton", "You are on the yard of Hobbiton.", None)
  val hobbitonIn    = new Area("Hobbiton", "You've entered the Hobbiton.", None)
  val shireRoad     = new Area("Road", "You have come to a road that goes from east to west. You can go either way.", None)
  val haven         = new Area("Haven", "You have reached the Grey Havens.\nThe sea goes on as far as your eye can see, so there's no way for you to keep going west.", None)
  val shireForestE  = new Area("Forest", "You've stepped off the road into the woods. Maybe it's a shortcut somewhere, who knows?", None)
  val shireForestW  = new Area("Forest", "You've stepped off the road into the woods. Maybe it's a shortcut somewhere, who knows?", None)
  val bree          = new Area("Bree", "You've arrived to a lively village of Bree. A cold beer sounds very tempting at this point,\nand you happen to notice a tavern called Prancing Pony.", None)
  val prancingPony  = new Area("Prancing Pony", "You entered Prancing Pony, the most famous tavern of Bree.\nIt is crowded with people from all over Middle-Earth.", None)
  val weatherTop    = new Area("Weathertop", "You are now at weathertop, the views there are great. In the north, there are only empty lands and mountains of Angmar.\nIt's a dark place, maybe that's not where you should go.\nIn the south onward from Bree you see a river and in the east a big forest. It might be the black forest, you're not certain from here.", None)
  val emptyLands    = new Area("Wilderness", "You took a risky path, just try to keep a low profile. Oh no, you see orcs marching towards you. You have only one option. RUN!", None)
  val emptyLands2   = new Area("Deep wilderness", "It seems like you've escaped from the orcs, but now you're lost.\nYou also lost your wallet while running away, oh no! Try to find your way back to safety.", None)
  val breeRoad      = new Area("Road", "You are on a road that's leading eastwards from Bree.", None)
  val entrance      = new Area("Treeline", "You see the treeline of Black forest in the east. You can either go in or turn back.", None)
  val blackForest   = new Area("Black Forest", "You are in the middle of a forest, it feels like you've been wandering for ages.\nIt's making you feel sick, you have no idea which way is which anymore.", None)
  val riverForestN  = new Area("Forest", "You've stepped off the road into the woods. Maybe it's a shortcut somewhere, who knows?", None)
  val riverForestNE = new Area("Forest", "You've stepped off the road into the woods. Maybe it's a shortcut somewhere, who knows?", None)
  val bridgeN       = new Area("Bridge", "You found a bridge crossing the river, great! If you go south, you can get to the southern side of the river.", None)
  val bridgeS       = new Area("Bridge", "You are on the southern coast of the river flowing from west to east. In north there's a bridge that leads to the northern side of the river.", None)
  val riversideN    = new Area("Riverside", "You are now at a river. If you wanna keep heading south, you need to figure a way to cross it.\nThere are some crappy-looking boats on the shore, maybe they could be enough to get you across?", None)
  val riversideNE   = new Area("Riverside", "You are on the northern coast of the river flowing from west to east.", None)
  val river         = new Area("River", "You head out to the river in a boat. River flows from west to east, you can either try to follow it\nor make your way to the southern coast. Boat doesn't feel very sturdy though.", Some(boat))
  val riverflow     = new Area("Rivershore", "You decide to follow the river. You feel your feet getting wet. Oh no, the boat is sinking.\nSoaking wet, you're washed ashore to the northern side of the river.\nAnd that's not all, you notice that you lost all your stuff and money.", Some(boat))
  val riversideS    = new Area("Riverside", "You've crossed the river. What next?", None)
  val riversideSE   = new Area("Riverside", "You are on the southern coast of the river. In the south you see wilderness.", None)
  val riversideSW   = new Area("Riverside", "You are on the southern coast of the river. In the south you see wilderness. Keep moving. Somewhere.", None)
  val wilderness    = new Area("Wilderness", "The empty land just goes on and on.", None)
  val wilderness2   = new Area("Wilderness", "The empty land just goes on and on.", None)
  val wildernessH   = new Area("Wilderness", "You are riding through the fields, it almost feels like flying. In the the south you now see a city looming in the horizon.", Some(horse))
  val minastirithG  = new Area("Minas Tirith", "You have come to the heavily guarded gates of Minas Tirith, the city of kings.", None)
  val minastirith   = new Area("Minas Tirith", "Finally, inside the city. It's really beautiful with it's white buildings and narrow streets.\nBut it's a big city, you've realized that you have no idea where to find Aragorn. Someone here must know, right?", Some(letter))
  val minastirithE  = new Area("Minas Tirith", "You are in the streets of Minas Tirith. They all look like the same to you.", None)
  val minastirithK  = new Area("Minas Tirith", "You are in the streets of Minas Tirith. Every place looks similar to you.", None)
  val castle        = new Area("Castle", "Castle", Some(badge))

  val bilbo         = new Person("Bilbo", Vector("- Frodo, my dear boy, how are you doing? Do you have time for a little talk?",
                                 "- Gandalf, you know, the wizard, just visited me couple days ago.\n  He said he was heading south to see how people in Minas Tirith are doing. If you wanna catch them, \n  I suggest you follow his tracks. You were looking for the companion, right?",
                                 "- Oh, and one more thing. In my days I've met some pretty influential people, like you have too.\n  One name you should keep in mind is Aragorn, being friends with him can open some doors for you."), 0)

  val barliman      = new Person("Barliman", Vector("- Welcome to Prancing Pony! How great it is to see hobbits here for a change, why don't you get yourself a drink?",
                                 "- Oh, and you were looking for Gandalf, he passed this way this week. Ordered the usual from the bar, The Balrog's Blow.\n  You can get one for only 5 coins, do you dare to try it?",
                                 "- It's tight stuff, isn't it? Bet you aren't used to drinks like that. Welcome again, make yourself at home."), -5)
  val drunk        = new Person("Drunk", Vector("- Hello my friend, will you join my table?",
                                "- I don't have any secrets but I can tell you about the Black Forest. Wanna hear it?",
                                "- I had a friend of mine who had some business that way and the only way was through the woods.\n  Even though a road leads there, he got lost and wandered in circles for weeks.\n  Said he had no idea where he was. Then finally as he was starving to death, he found his way out of the woods.\n  Believe me when I say, lad, it's a cursed place. Cursed!"), 0)
  val stranger     = new Person("Stranger", Vector("- Yeah, you can borrow a boat but it is gonna cost you something.\n  Do you have anything with you that I might be interested in?",
                                "- Okay, great. These are great boats, I don't want to give them away very cheap.\n  50 coins and we've got a deal. Do you take it?",
                                "- Awesome. Just say thanks and the boat will be yours."), -50)
  val horselord    = new Person("Horselord", Vector("- Hey. I'm in a bit of a hurry. But you want to borrow one of my horses or what?",
                                "- Sorry, but I have no idea who you are or where you come from. How could I trust you?"), 0)
  val guard        = new Person("Guard", Vector("- You there! Are you coming to city?",
                                 "- Who are you and what affairs do you have here?"), 0)
  val stranger2    = new Person("Stranger", Vector("- You look like you're lost. Need help?",
                                "- Are you coming from Bree?",
                                "- If you are going south, it's gonna be a long walk. That's where you're heading, right?",
                                "- So I bet you're looking for a horse? I just saw a nobleman with few of them heading to the river.\n  Not sure if he'll help a halfling like you though, but I think it's worth trying."), 0)
  val soldier      = new Person("Soldier", Vector("- I heard you're looking for Aragorn. Is that right?",
                                "- If you find someone from the kingsguard, they can escort you to him."), 0)
  val joker        = new Person("Joker", Vector("- Do you want to see a magic trick?",
                                "- Do you see this coin? Now it's gone! HAHAHAHAHAA! Wanna see another?",
                                "- Do you see this pen? Now it's gone! HAHAHAHAHAA! Wanna see another?",
                                "- Do you see this flower? Now it's gone! HAHAHAHAHAA! Wanna see another?",
                                "- Do you see your wallet? It's gone! HAHAHAHAHAA! It was great fooling you, GOTTA GO!"), 0)
  val cleaner      = new Person("Cleaner", Vector("- Do you need money?",
                                "- There was a big party here that just ended, if you help me clean this mess I'll give you 10 coins for it. Are you in?",
                                "- Thank you, you saved me from lots of trouble. Here you go, 10 coins for you. Now, off you go."), 10)
  val kingsguard   = new Person("Kingsguard", Vector("- Can I help you?",
                                "- So you wanna see Aragorn. Is your affair urgent?",
                                "- Hmm hmm. For 10 coins I could escort you. Is that okay with you?",
                                "- Okay, hop on. If you're able to take it, I'll give you a badge of the kingsguard,\n  so that you can move freely in the city. What did you say you have for Aragorn?"), -10)
  val orc          = new Person("Orc", Vector("- GET HIM!!"), 0)

  shire.setNeighbors        (Vector("north" -> hobbitonY,    "east" -> shireForestE,   "south" -> shireRoad,  "west" -> shireForestW  ))
  hobbitonY.setNeighbors    (Vector(                                                   "south" -> shire,        "inside" -> hobbitonIn))
    hobbitonIn.setNeighbors   (Vector("outside" -> hobbitonY))
  shireRoad.setNeighbors    (Vector("north" -> shire,        "east" -> bree,                                  "west" -> haven         ))
  haven.setNeighbors        (Vector("north" -> shireForestW, "east"  -> shireRoad                                                     ))
  shireForestE.setNeighbors (Vector(                                                   "south" -> shireRoad,  "west" -> shire         ))
  shireForestW.setNeighbors (Vector(                         "east"  -> shire,         "south" -> haven                               ))

  bree.setNeighbors         (Vector("north" -> weatherTop,   "east" -> breeRoad,       "south" -> riversideN,     "west" -> shireRoad , "inside" -> prancingPony    ))
    prancingPony.setNeighbors (Vector("outside" -> bree))
  weatherTop.setNeighbors   (Vector("north" -> emptyLands,   "east" -> breeRoad,       "south" -> bree,       "west" -> shireForestE  ))
  emptyLands.setNeighbors   (Vector("north" -> emptyLands2,  "east" -> emptyLands2,    "south" -> emptyLands2,"west" -> emptyLands2   ))
  emptyLands2.setNeighbors  (Vector("north" -> emptyLands2,  "east" -> entrance,       "south" -> breeRoad,   "west" -> shireForestE  ))
  breeRoad.setNeighbors     (Vector("north" -> emptyLands,    "east"  -> entrance,     "south" -> riverForestN,"west" -> bree         ))
  entrance.setNeighbors     (Vector(                         "east"  -> blackForest,   "south" -> riverForestNE,"west" -> breeRoad    ))
  blackForest.setNeighbors  (Vector("north" -> blackForest,  "east" -> blackForest,    "south" -> emptyLands, "west" -> emptyLands    ))

  riversideN.setNeighbors   (Vector("north" -> bree,         "east" -> riversideNE,    "south" -> river                               ))
  riversideNE.setNeighbors  (Vector("north" -> riverForestN,                                                  "west" -> riversideN    ))
  riverForestN.setNeighbors (Vector("north" -> breeRoad,     "east" -> riverForestNE,  "south" -> riversideNE,"west" -> riversideN    ))
  riverForestNE.setNeighbors(Vector("north" -> entrance,                               "south" -> bridgeN,    "west" -> riverForestN  ))
  bridgeN.setNeighbors      (Vector("north" -> riverForestNE,                          "south" -> bridgeS                             ))

  river.setNeighbors        (Vector(                         "east" -> riverflow,      "south" -> riversideS                          ))
  riverflow.setNeighbors    (Vector("north" -> riversideNE, "east" -> riversideNE,                              "west" -> riversideN  ))

  riversideS.setNeighbors   (Vector(                         "east" -> riversideSE,    "south" -> wilderness, "west" -> riversideSW   ))
  riversideSW.setNeighbors  (Vector(                         "east" -> riversideSE,    "south" -> wilderness2                         ))
  riversideSE.setNeighbors  (Vector(                         "east" -> bridgeS,        "south" -> wildernessH,"west" -> riversideSW   ))
  bridgeS.setNeighbors      (Vector("north" -> bridgeN,                                "south" -> wilderness, "west" -> riversideSE   ))

  wilderness.setNeighbors   (Vector("north" -> riversideSE,  "east" -> wilderness,                            "west" -> wilderness2   ))
  wilderness2.setNeighbors  (Vector("north" -> riversideSW,  "east" -> wilderness                                                     ))
  wildernessH.setNeighbors  (Vector("north" -> riversideSE,  "east" -> wildernessH,    "south" -> minastirithG,"west"-> wildernessH   ))

  minastirithG.setNeighbors (Vector("north" -> wildernessH, "inside" -> minastirith))
  minastirith.setNeighbors  (Vector("north" -> minastirithK, "east" -> minastirithE, "outside" -> minastirithG                        ))
  minastirithK.setNeighbors (Vector("inside" -> castle,       "east" -> minastirithE,   "south" -> minastirith                        ))
    castle.setNeighbors     (Vector("outside" -> minastirithK))
  minastirithE.setNeighbors (Vector("north" -> minastirithK, "west" -> minastirith                                                    ))


  hobbitonY.addPerson(bilbo)
  prancingPony.addPerson(barliman)
  prancingPony.addPerson(drunk)
  riversideN.addPerson(stranger)
  riversideSE.addPerson(horselord)
  minastirithG.addPerson(guard)
  wilderness2.addPerson(stranger2)
  minastirith.addPerson(soldier)
  minastirith.addPerson(joker)
  minastirithE.addPerson(cleaner)
  minastirithK.addPerson(kingsguard)
  emptyLands.addPerson(orc)

  riversideN.addVehicle(boat)
  riversideSE.addVehicle(horse)
  minastirithG.addVehicle(letter)
  minastirithK.addVehicle(badge)

  hobbitonIn.editMoney(100)
  shireForestW.editMoney(50)


  val player = new Player(hobbitonY)

  var turnCount = 0
  var lastVerb = ""

  def isComplete = this.player.location == castle && player.vehicleList.contains("letter")
  def isOver = this.player.hasQuit || this.isComplete

  def welcomeMessage = "\nYou are a hobbit called Frodo Baggins. It's been some time since the ring was destroyed, and you've come back to Middle-Earth.\nYour goal is to find a friend of yours, don't be afraid to ask advice from people on the way.\nIf at any point you need help, command 'help' will open the tutorial and command 'hint' will show a randomized hint."
  def goodbyeMessage = {
    if (isComplete) {
      "You've found Aragorn, your old friend. Congratulations!"
    } else {
      "You've quit the game."
    }
  }
  def turnMessage = {
    if(isComplete) {
      s"You completed the game in $turnCount turns."
    } else {
      s"It took you $turnCount turns to get this far."
    }
  }

  def playTurn(command: String): String = {
    val action = new Action(command)
    lastVerb = action.verbWas
    val outcomeReport = action.execute(this.player)
    val addTurn = outcomeReport.isDefined && lastVerb != "" && lastVerb != "help"
    if (addTurn) {
      this.turnCount += 1
    }
    outcomeReport.getOrElse("Unknown command: \"" + command + "\".")
  }

}
