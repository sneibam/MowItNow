package fr.mosef.projetScala.MowItNow

/*
  Objet Singleton Pelouse
 */

object Pelouse {

  private var XMAX: Int = 0
  private var YMAX: Int = 0


  def run(fileName: String): Unit = {
      // On suppose que le fichier d'entrée du programme se trouve dans le répertoire 'resources'
      val bufferedSource = io.Source.fromFile(getClass.getResource(s"/$fileName").getPath)

      // On récupère l'ensemble des lignes du fichier
      val lines = bufferedSource.getLines()

      // On récupère la première ligne qui contient les coordonnées du coin supérieur droit de la pelouse
      var line = lines.next()

      val coordMax = line.split(" ")

      XMAX = coordMax(0).toInt
      YMAX = coordMax(1).toInt

      var i = 1

      // On bouble tant qu'il n'y a plus de ligne à lire.
      while (lines.hasNext){
        line = lines.next()
        // On recupere la position initiale de la tondeuse

        val initialPosition = line.split(" ")
        val x = initialPosition(0).toInt
        val y = initialPosition(1).toInt

        val orientation_text = initialPosition(2)
        var orientation = Orientation.NORTH
        orientation_text match {
          case "E" => orientation = Orientation.EAST
          case "W" => orientation = Orientation.WEST
          case "N" => orientation = Orientation.NORTH
          case "S" => orientation = Orientation.SOUTH
        }

        val tondeuse = new Tondeuse(new Position(x, y, orientation), XMAX, YMAX)

        // On récupère la ligne contenant la liste des instructions à fournir à la tondeuse
        line = lines.next()
        val commands = line.toList
        commands.foreach( tondeuse.move(_) )

        // Affichage de la position finale de la tondeuse
        println(s"Tondeuse $i : $tondeuse")
        i = i + 1
      }

      // On ferme le buffer de lecture du fichier
      bufferedSource.close()
  }
}