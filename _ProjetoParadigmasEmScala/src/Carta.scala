
import scala.util.matching.Regex

class Carta(carta: String) {
  require(isValid(carta), "Carta invalida")

  def numero: String = {
    carta.substring(0,1)
  }

  def naipe: String = {
    carta.substring(1,2)
  }

  def peso: Int = {
    Carta.peso(numero)
  }

  override def toString: String = {
    carta
  }

  private def isValid(card: String): Boolean = {
    new Regex("[2-9KTQJA]{1}[CDSH]{1}").findAllIn(card).length > 0
  }
}

object Carta {
  def apply(cs: String): Carta = new Carta(cs)

  val naipe: List[String] = 
    List("C", "H", "D", "S")

  val numero: List[String] = 
    (2 to 9).map(_.toString).toList ::: List("T", "J", "Q", "K", "A")

  def peso(key: String): Int = {
    pesos.find(v => v._1 == key).get._2
  }

  private val pesos: List[(String, Int)] = List(
    ("2", 2),
    ("3", 3),
    ("4", 4),
    ("5", 5),
    ("6", 6),
    ("7", 7),
    ("8", 8),
    ("9", 9),
    ("T", 10),
    ("J", 11),
    ("Q", 12),
    ("K", 13),
    ("A", 14)
  )
}