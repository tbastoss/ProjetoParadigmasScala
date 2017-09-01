class Straight extends TipoDaMao {
  def evaluate(h: Mao): (Boolean, TipoDaMao, List[Int]) = {
    (h.consecutivo, this, 4 :: h.ordena.map(_.peso))
  }

  override def toString: String = {
    "Straight"
  }
}

object Straight {
  def apply(h: Mao): (Boolean, TipoDaMao, List[Int]) = (new Straight).evaluate(h)
}