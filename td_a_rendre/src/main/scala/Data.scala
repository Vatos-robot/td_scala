import scala.util.Try

object Data {
  case class Row(userId: String, gender: String, age: Int)

  case class Data(data: Vector[Row])

  object Row {
    def parse(line: String): Row = {
      val values = line.split(",")
      val userId = values(0)
      val gender = values(1)
      val age = Try(values(2).toInt).getOrElse(0)
      Row(userId, gender, age)
    }
  }

  def parse(lines: Vector[String]): Data = {
    val rows = lines.map(Row.parse)
    Data(rows)
  }
}