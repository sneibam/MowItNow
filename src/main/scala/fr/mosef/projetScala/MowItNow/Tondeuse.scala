package fr.mosef.projetScala.MowItNow

/*
  @Tondeuse
  Classe contenant la position de la tondeuse ainsi que les coordonnées (X,Y) du coin supérieur à droite de la pelouse
 */
class Tondeuse(val _position: Position, val _XMAX: Int, _YMAX: Int){

  private var position: Position = _position

  private val XMAX: Int = _XMAX
  private val YMAX: Int = _YMAX

  def move(command: Char): Unit = {
    command match {
      case 'A' => {
        position.orientation match {
          case Orientation.EAST =>
                if (position.x < XMAX) position.x = position.x + 1
          case Orientation.WEST =>
                if (position.x > 0) position.x = position.x -1
          case Orientation.NORTH =>
                if (position.y < YMAX) position.y = position.y + 1
          case Orientation.SOUTH =>
                if (position.y > 0) position.y = position.y - 1
        }
      }
      case 'D' => {
        position.orientation match {
          case Orientation.EAST => position.orientation = Orientation.SOUTH
          case Orientation.WEST => position.orientation = Orientation.NORTH
          case Orientation.NORTH => position.orientation = Orientation.EAST
          case Orientation.SOUTH => position.orientation = Orientation.WEST
        }
      }
      case 'G' => {
        position.orientation match {
          case Orientation.EAST => position.orientation = Orientation.NORTH
          case Orientation.WEST => position.orientation = Orientation.SOUTH
          case Orientation.NORTH => position.orientation = Orientation.WEST
          case Orientation.SOUTH => position.orientation = Orientation.EAST
        }
      }
      case default => println("Cette commande n'existe pas !")
    }
  }


  override def toString =  s"$position"
}
