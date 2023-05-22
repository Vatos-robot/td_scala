object Data {
  case class Row(userId: String, gender: String, age: Int)
  case class Data(data: Vector[Row])
}