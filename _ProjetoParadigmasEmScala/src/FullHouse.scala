class FullHouse extends TipoDaMao {
  def evaluate(h: Mao): (Boolean, TipoDaMao, List[Int]) = {

    def matches: Boolean = {
      h.pairs.toList.length == 1 && h.trips.toList.length == 1
    }

    def score: List[Int] = {
      val p: List[Int] = matches match {
        case true  => h.trips.collect { case (a, b) => b.head.peso }.toList
        case false => 0 :: Nil
      }

      val q: List[Int] = matches match {
        case true  => h.pairs.collect { case (a, b) => b.head.peso }.toList
        case false => 0 :: Nil
      }

      6 :: p.head :: q.head :: 0 :: 0 :: 0 :: Nil
    }

    (matches, this, score)
  }

  override def toString: String = {
    "Full House"
  }
}

object FullHouse {
  def apply(h: Mao): (Boolean, TipoDaMao, List[Int]) = (new FullHouse).evaluate(h)
}