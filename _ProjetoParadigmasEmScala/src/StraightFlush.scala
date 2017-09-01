class StraightFlush extends TipoDaMao {
  def evaluate(h: Mao): (Boolean, TipoDaMao, List[Int]) = {

    def matches: Boolean = {
      h.consecutivo && h.mesmoNaipe
    }

    (matches, this, 8 :: h.ordena.map(_.peso))
  }

  override def toString: String = {
    "Straight Flush"
  }
}

object StraightFlush {
  def apply(h: Mao): (Boolean, TipoDaMao, List[Int]) = (new StraightFlush).evaluate(h)
}