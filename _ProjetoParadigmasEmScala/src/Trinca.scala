class Trinca extends TipoDaMao {
  def evaluate(h: Mao): (Boolean, TipoDaMao, List[Int]) = {
    def score: List[Int] = {
      val p: List[Int] = h.trips.collect { case (a, b) => b.head.peso }.toList
      val q: List[Int] = h.ordena.map(_.peso).filter(!p.contains(_))

      List(3) ::: p ::: q ::: List(0, 0)
    }

    (h.trips.toList.length == 1, this, score)
  }

  override def toString: String = {
    "Trinca"
  }
}

object Trinca {
  def apply(h: Mao): (Boolean, TipoDaMao, List[Int]) = (new Trinca).evaluate(h)
}