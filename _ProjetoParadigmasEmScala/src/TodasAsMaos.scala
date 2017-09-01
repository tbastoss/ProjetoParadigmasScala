object TodasAsMaos {
  def all: List[TipoDaMao] = {
    List(
      new StraightFlush,
      new Quadra,
      new FullHouse,
      new Flush,
      new Straight,
      new Trinca,
      new DoisPares,
      new Par,
      new CartaAlta)
  }
}