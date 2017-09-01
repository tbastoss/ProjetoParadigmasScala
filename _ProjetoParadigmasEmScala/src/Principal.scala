import java.util.Date
object Principal {
  def main(args: Array[String]): Unit = {
    var data1 = new Date()
    var inicio = data1.getTime

    poker(io.Source.fromFile("Artefatos/pokerK.txt").getLines());

    var data2 = new Date()
    var fim = data2.getTime()
    var tempoExec = fim - inicio
    println("Tempo de execucao em ms:")
    println(tempoExec)

  }

  def poker(linha: Iterator[String]): String = {

    var line = linha.next().split(" ").map(_.trim).toList;

    val jogador1: Mao = Mao(line.slice(0, 5).toList)
    val jogador2: Mao = Mao(line.slice(5, 10).toList)

    //println(line)
    jogador1.compareCom(jogador2)._3

    if (linha.hasNext) {

      poker(linha);
    } else {
      ""
    }
  }

}
