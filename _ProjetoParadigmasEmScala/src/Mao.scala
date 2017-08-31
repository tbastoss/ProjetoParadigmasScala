

class Mao (var cartas: Array[Carta]){
  def getCartas(): Array[Carta] = cartas
  
  def setCartas (cartas : Array[Carta]): Unit = {
    if (cartas.length == 5)
      this.cartas = cartas
  }
  
  def ordena (mao: Mao): Unit = {
    var maoAux = mao 
    var min = 0
    var x = new Carta('-', '-', 0)
    
    for (i <- 0 to maoAux.getCartas().length){
      min = i
      for(j <- i to maoAux.getCartas().length){
        if(maoAux.getCartas()(j).getPeso() < maoAux.getCartas()(min).getPeso()){
          min = j
        }
      }
      if(maoAux.getCartas()(i) != maoAux.getCartas()(min)){
        x = maoAux.getCartas()(i)
        maoAux.getCartas()(i) = maoAux.getCartas()(min)
        maoAux.getCartas()(min) = x
      }
    }
    maoAux
  }
}
  
