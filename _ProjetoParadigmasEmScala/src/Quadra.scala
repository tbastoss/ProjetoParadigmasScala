class Quadra extends TipoDaMao {
  def evaluate(h: Mao): (Boolean, TipoDaMao, List[Int]) = {
    def score: List[Int] = {
      val p: List[Int] = h.quads.collect { case (a, b) => b.head.peso }.toList
      val q: List[Int] = h.ordena.map(_.peso).filter(!p.contains(_))

      List(7) ::: p ::: q ::: List(0, 0, 0)
    }

    (h.quads.toList.length == 1, this, score)
  }

  override def toString: String = {
    "Quadra"
  }
}

object Quadra {
  def apply(h: Mao): (Boolean, TipoDaMao, List[Int]) = (new Quadra).evaluate(h)
}