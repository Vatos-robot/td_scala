import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {
    if (args.length >= 1) {
      val filename = args(0)
      val lines = Source.fromFile(filename).getLines().toVector
      println("Contenu du fichier :")
      lines.foreach(println)
      println(s"Nombre de lignes : ${lines.length}")
    } else {
      println("Erreur : Aucun fichier spécifié.")
    }
  }
}