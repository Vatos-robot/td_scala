import scala.io.Source
import scopt.OParser

case class Config(path: String, gender: Option[String])

object Main_no_scopt {
  def main(args: Array[String]): Unit = {
    if (args.length >= 1) {
      val filename = args(0)
      val lines = Source.fromFile(filename).getLines().toVector
      println("Contenu du fichier :")
      lines.foreach(println)
      println(s"Nombre de lignes : ${lines.length}")

      if (args.length >= 2) {
        val genreFilter = args(1)
        val filteredLines = lines.filter(line => line.contains(genreFilter))
        println(s"Il y a ${filteredLines.length} utilisateurs avec le genre $genreFilter")
      }
    } else {
      println("Erreur : Aucun fichier spécifié.")
    }
  }
}


object Main {
  def main(args: Array[String]): Unit = {
    val builder = OParser.builder[Config]
    val parser = {
      import builder._
      OParser.sequence(
        programName("MonProgramme"),
        head("MonProgramme", "1.0"),
        opt[String]('g', "gender")
          .action((x, c) => c.copy(gender = Some(x)))
          .validate(x =>
            if (x == "f" || x == "m" || x == "u") success
            else failure("L'option gender doit être f, m ou u")
          )
          .text("Genre sur lequel on veut filtrer"),
        arg[String]("<path>")
          .required()
          .action((x, c) => c.copy(path = x))
          .text("Chemin du fichier")
      )
    }

    OParser.parse(parser, args, Config("", None)) match {
      case Some(config) =>
        val filename = config.path
        val lines = scala.io.Source.fromFile(filename).getLines().toVector
        println("Contenu du fichier :")
        lines.foreach(println)
        println(s"Nombre de lignes : ${lines.length}")

        config.gender match {
          case Some(gender) =>
            val filteredLines = lines.filter(line => line.contains(gender))
            println(s"Il y a ${filteredLines.length} utilisateurs avec le genre $gender")
          case None =>
            // Pas de filtre de genre, afficher le nombre total d'utilisateurs
            println(s"Il y a ${lines.length} utilisateurs au total")
        }

      case _ =>
        // Erreur lors de l'analyse des arguments
        println("Erreur : Veuillez spécifier le chemin du fichier.")
    }
  }
}

object Main_using_row {
  def main(args: Array[String]): Unit = {
    val filename = args(0)

    val fileLines = Source.fromFile(filename).getLines().toVector

    if (fileLines.nonEmpty) {
      val firstLine = fileLines.head
      val row = Data.Row.parse(firstLine)
      println("Il y a " + fileLines.size + " utilisateurs")
      println("Première ligne du fichier : " + row)
    } else {
      println("Le fichier est vide")
    }
  }
}