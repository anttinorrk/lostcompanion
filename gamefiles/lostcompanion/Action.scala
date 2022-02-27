package gamefiles.lostcompanion

class Action(input: String) {

  private val commandText = input.trim.toLowerCase
  private val verb        = commandText.takeWhile( _ != ' ' )
  private val modifiers   = commandText.drop(verb.length).trim
  def verbWas = verb

  def execute(actor: Player): Option[String] = this.verb match {
    case "go"       => Some(actor.go(this.modifiers))
    case "quit"     => Some(actor.quit())
    case "talk"     => Some(actor.talk(this.modifiers.head.toUpper + this.modifiers.tail))
    case ""         => Some(actor.nothing)
    case "-"        => Some(actor.say(this.modifiers))
    case "help"     => Some(actor.help)
    case "inventory"=> Some(actor.inventory)
    case "cast"     => Some(actor.cast(this.modifiers))
    case "wallet"   => Some(actor.wallet)
    case "take"     => Some(actor.take(this.modifiers))
    case "hint"     => Some(actor.hint)
    case other      => None


  }



}
