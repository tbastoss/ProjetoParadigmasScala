class Flush extends TipoDaMao {
  def evaluate(h: Mao): (Boolean, TipoDaMao, List[Int]) = {
    (h.mesmoNaipe, this, 5 :: h.ordena.map(_.peso))
  }

  override def toString: String = {
    "Flush"
  }
}

object Flush {
  def apply(h: Mao): (Boolean, TipoDaMao, List[Int]) = (new Flush).evaluate(h)
}
