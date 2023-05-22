import scala.io.Source

object Main extends App {
  if (args.length > 0) {
    val filename = args(0)
    val content = Source.fromFile(filename).getLines().toVector
    println(content)
  } else {
    println("Erreur : Le programme attend au moins un argument")
  }
}