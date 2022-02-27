package gamefiles.lostcompanion

class Person(val name: String, val lines: Vector[String], val cost: Int) {
  override def toString = this.name
}

