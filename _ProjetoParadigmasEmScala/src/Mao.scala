import Ordering.Implicits._

class Mao(val cartas: List[Carta]) {
  require(valido, "Especificacao de mao invalida")

  def ordena: List[Carta] = this.cartas.sortWith(_.peso > _.peso)

  def compareCom(that: Mao): (Option[Mao], Option[TipoDaMao], String) = {
    def eval(h: Mao): (Mao, TipoDaMao, List[Int]) = {
      TodasAsMaos.all.collect { case t => t.evaluate(h) }.find { case (b, t, s) => b } match {
        case None    => throw new Error("Erro")
        case Some(v) => (h, v._2, v._3)
      }
    }

    def comparar(a: (Mao, TipoDaMao, List[Int]), b: (Mao, TipoDaMao, List[Int])): Option[(Mao, TipoDaMao)] = {
      (a._3 > b._3, b._3 > a._3) match {
        case (true, false) => Some((a._1, a._2))
        case (false, true) => Some((b._1, b._2))
        case _ => None
      }
    }

    comparar(eval(this), eval(that)) match {
      case Some(v) => (Option(v._1), Option(v._2), s"Vencedor: ${v._1} (${v._2})\n")
      case None    => (None, None, s"Tie (${eval(this)._2})")
    }
  }

  def pairs = grupo(2)
  def trips = grupo(3)
  def quads = grupo(4)

  def mesmoNaipe: Boolean = {
    cartas.groupBy(_.naipe).toList.length == 1
  }

  def consecutivo: Boolean = {
    def get(swap: Boolean): List[Int] = swap match {
      case false => ordena.map(_.peso)
      case true  => get(false).map { case 14 => 1; case x => x }.sortWith(_ > _)
    }

    val a: List[Int] = get(false)
    val b: List[Int] = get(true)

    (a.max to a.min by -1).toList == a || (b.max to b.min by -1).toList == b
  }

  override def toString: String = {
    cartas.map(_.toString).mkString(" ")
  }

  private def grupo(n: Int): Map[String, List[Carta]] = {
    this.cartas.groupBy(_.numero).filter { case (a, b) => b.length == n }
  }

  private def valido: Boolean = {
    cartas.length == 5
  }
}

object Mao {
  def apply(cards: List[String]): Mao = {
    val c = cards.collect { case s: String => new Carta(s) }
    new Mao(c)
  }
}

