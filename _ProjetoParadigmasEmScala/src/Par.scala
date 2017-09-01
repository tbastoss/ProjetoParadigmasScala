class Par extends TipoDaMao {
  def evaluate(h: Mao): (Boolean, TipoDaMao, List[Int]) = {
    def score: List[Int] = {
      val p: List[Int] = h.pairs.collect { case (a, b) => b.head.peso }.toList
      val q: List[Int] = h.ordena.map(_.peso).filter(!p.contains(_))

      List(1) ::: p ::: q ::: List(0)
    }

    (h.pairs.toList.length == 1, this, score)
  }

  override def toString: String = {
    "Par"
  }
}

object Par {
  def apply(h: Mao): (Boolean, TipoDaMao, List[Int]) = (new Par).evaluate(h)
}
