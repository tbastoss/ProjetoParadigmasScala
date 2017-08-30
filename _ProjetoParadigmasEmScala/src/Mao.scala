

class Mao (var cartas: Array[Carta]){
  def getCartas(): Array[Carta] = cartas
  
  def setCartas (cartas : Array[Carta]): Unit = {
    if (cartas.length == 5)
      this.cartas = cartas
  }
  
  def ordena (mao: Mao): Unit = {
    var maoAux = mao 
    var i, j, min = 0
    var x = new Carta('5', 'H', 0)
    
  }
}