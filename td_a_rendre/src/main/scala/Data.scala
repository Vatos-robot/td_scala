object Data {
  case class Row(userId: String, gender: String, age: Int)

  object Row {
    def parse(line: String): Row = {
      val values = line.split(",")
      val userId = values(0)
      val gender = values(1)
      val age = values(2).toInt
      Row(userId, gender, age)
    }
  }

  case class Data(data: Vector[Row])
}