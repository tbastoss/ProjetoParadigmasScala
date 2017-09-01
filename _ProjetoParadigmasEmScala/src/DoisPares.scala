class DoisPares extends TipoDaMao {
  def evaluate(h: Mao): (Boolean, TipoDaMao, List[Int]) = {
    def score: List[Int] = {
      val p: List[Int] = h.pairs.collect { case (a, b) => b.head.peso }.toList
      val q: List[Int] = h.ordena.map(_.peso).filter(!p.contains(_))

      List(2) ::: p ::: q ::: List(0, 0)
    }

    (h.pairs.toList.length == 2, this, score)
  }

  override def toString: String = {
    "Dois Pares"
  }
}

object DoisPares {
  def apply(h: Mao): (Boolean, TipoDaMao, List[Int]) = (new DoisPares).evaluate(h)
}
