



class CartaAlta extends TipoDaMao {
  def evaluate(h: Mao): (Boolean, TipoDaMao, List[Int]) = {
    (true, this, 0 :: h.ordena.map(_.peso))
  }
  
  override def toString: String = "Carta Alta"
}

object CartaAlta {
  def apply(h: Mao): (Boolean, TipoDaMao, List[Int]) = (new CartaAlta).evaluate(h)
}
