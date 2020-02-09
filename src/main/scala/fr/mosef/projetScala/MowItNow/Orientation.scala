package fr.mosef.projetScala.MowItNow

/*
  Type Enum pour definir les differentes valeurs possible de l'orientation d'une tondeuse
 */
object Orientation extends Enumeration {
  val EAST, WEST, NORTH, SOUTH = Value
}