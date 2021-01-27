import scala.annotation.tailrec
object Main extends App {

  val week: List[String] = List(
    "Poniedzialek",
    "Wtorek",
    "Sroda",
    "Czwartek",
    "Piatek",
    "Sobota",
    "Niedziela"
  )

  def Zad1a(lista: List[String]): String = {
    var output: String = "";
    for (element <- lista) {
      output += element + ","
    }
    output = output.dropRight(1)
    return output;
  }

  def Zad1b(lista: List[String]): String = {
    var output: String = "";
    for (element <- lista) {
      if (element.head == 'P') {
        output += element + ","
      }
    }
    output = output.dropRight(1)
    return output;
  }

  def Zad1c(lista: List[String]): String = {
    var output: String = ""
    var index = 0
    while (index < lista.length) {
      output += lista(index) + ","
      index += 1
    }
    output = output.dropRight(1)
    return output;
  }

  def Zad2a(lista: List[String]): String = {
    if (lista.isEmpty) {
      return ""
    }
    if (lista.length == 1) {
      return lista.head
    }
    return lista.head + "," + Zad2a(lista.tail);
  }

  def Zad2b(lista: List[String]): String = {
    if (lista.isEmpty) {
      return ""
    }
    if (lista.length == 1) {
      return lista.reverse.head
    }
    return lista.reverse.head + "," + Zad2b(lista.reverse.tail.reverse);
  }

  def Zad3(lista: List[String]): String = {
    @tailrec
    def Zad3_tail(output: String, listaInside: List[String]): String = {
      if (listaInside.isEmpty) return output
      else return Zad3_tail(output + "," + listaInside.head, listaInside.tail)
    }
    return Zad3_tail(lista.head, lista.tail)
  }

  def Zad4a(lista: List[String]): String = {
    return lista.tail.foldLeft(lista.head)((a, b) => a + "," + b)
  }

  def Zad4b(lista: List[String]): String = {
    return lista
      .foldRight("")((a, b) => {
        a + "," + b
      })
      .dropRight(1)
  }

  def Zad4c(lista: List[String]): String = {
    return lista
      .foldLeft("")((a, b) => {
        if (b.head == 'P')
          a + "," + b
        else
          a
      })
      .reverse
      .dropRight(1)
      .reverse
  }

  val katalog: Map[String, BigDecimal] = Map(
    "Farby" -> 10.0,
    "Pedzle" -> 3.0,
    "Kleje" -> 100.0
  )

  def Zad5(mapa: Map[String, BigDecimal]): Map[String, BigDecimal] = {
    return mapa.map(x => (x._1 -> x._2 * 0.9))
  }

  def Zad6(krotka: (String, Int, Double)) {
    println("Zad6 " + krotka._1 + " " + krotka._2 + " " + krotka._3)
  }

  def Zad7(mapa: Map[String, BigDecimal]) {
    println("Zad7 Farby " + mapa.getOrElse("Farby", "Brak Produktu"))
    println("Zad7 Farby2 " + mapa.getOrElse("Farby2", "Brak Produktu"))
  }

  def Zad8() {
    val numbers = List(0, 1, 0, 0, 16, 0, -1);

    def Zad8_reku(numbersInside: List[Int]): List[Int] = {
      if (numbersInside.isEmpty) return Nil
      else if (numbersInside.head == 0)
        return Zad8_reku(numbersInside.tail)
      else return List(numbersInside.head) ++ Zad8_reku(numbersInside.tail)
    }

    val numbers2 = Zad8_reku(numbers);

    println("Zad8 " + numbers)
    println("Zad8 " + numbers2)
  }

  def Zad9(numbersInside: List[Int]): List[Int] = {
    return numbersInside.map(x => x + 1)
  }

  def Zad10(numbersInside: List[Double]): List[Double] = {
    return numbersInside.filter(x => x <= 12 && x >=(-5)).map(x=>x.abs)
  }

  println("Zad1a " + Zad1a(week))
  println("Zad1b " + Zad1b(week))
  println("Zad1c " + Zad1c(week))
  println("Zad2a " + Zad2a(week))
  println("Zad2b " + Zad2b(week))
  println("Zad3 " + Zad3(week))
  println("Zad4a " + Zad4a(week))
  println("Zad4b " + Zad4b(week))
  println("Zad4c " + Zad4c(week))
  println("Zad5 Katalog " + katalog)
  println("Zad5 " + Zad5(katalog))
  Zad6(("Krotka", 5, 2.6))
  Zad7(katalog);
  Zad8();
  println("Zad9 " + List(1, 2, 3, 4, 5, 6))
  println("Zad9 " + Zad9(List(1, 2, 3, 4, 5, 6)))
  println("Zad10 " + List(100, -100, 3, 4, -0.12, -7, -5, -6, 12))
  println("Zad10 " + Zad10(List(100, -100, 3, 4, -0.12, -7, -5, -6, 12)))
}
