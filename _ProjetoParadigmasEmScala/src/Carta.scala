

class Carta (var numero:Char, var nipe:Char, var peso:Int){  
  
  def getNumero() : Char = numero
  
  def setNumero (numero: Char): Unit = {
    this.numero = numero
  }
  
  def getNipe() : Char = nipe
  
  def setNipe(nipe: Char): Unit = {
    this.nipe = nipe
  }
  
  def getPeso() : Int = peso
  
  def setPeso(peso: Int): Unit = {
    this.peso = peso
  }
    
  def atribuirPeso (carta: Carta): Unit = {
    if (carta.getNumero() == '2') {
			this.setPeso(1);
		} else if (carta.getNumero() == '3') {
			this.setPeso(2);
		} else if (carta.getNumero() == '4') {
			this.setPeso(3);
		} else if (carta.getNumero() == '5') {
			this.setPeso(4);
		} else if (carta.getNumero() == '6') {
			this.setPeso(5);
		} else if (carta.getNumero() == '7') {
			this.setPeso(6);
		} else if (carta.getNumero() == '8') {
			this.setPeso(7);
		} else if (carta.getNumero() == '9') {
			this.setPeso(8);
		} else if (carta.getNumero() == 'T') {
			this.setPeso(9);
		} else if (carta.getNumero() == 'J') {
			this.setPeso(10);
		} else if (carta.getNumero() == 'Q') {
			this.setPeso(11);
		} else if (carta.getNumero() == 'K') {
			this.setPeso(12);
		} else if (carta.getNumero() == 'A') {
			this.setPeso(13);
		}
  }
}