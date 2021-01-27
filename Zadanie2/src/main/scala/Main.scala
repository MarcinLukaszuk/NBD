object Main extends App {

  def Zad1(paramater: String) =
    paramater match {
      case "Poniedzialek" => "Praca"
      case "Wtorek"       => "Praca"
      case "Sroda"        => "Praca"
      case "Czwartek"     => "Praca"
      case "Piatek"       => "Praca"
      case "Sobota"       => "Weekend"
      case "Niedziela"    => "Weekend"
      case default        => "Nie ma takiego dnia"
    }

  def Zad2() {
    var test = new KontoBankowe()
    println("Zad2 stanKonta " + test.stanKonta)

    println("Wplata 20 ")
    test.Wplata(20);
    println("Zad2 stanKonta " + test.stanKonta)

    println("Wyplata 30")
    test.Wyplata(30);
    println("Zad2 stanKonta " + test.stanKonta)
  }

  def Zad3() {
    var person1 = new Osoba("Marcin", "Lukaszuk")
    var person2 = new Osoba("Lukasz", "Marciniuk")
    var person3 = new Osoba("Lukasz", "Marciniuk2")

    def Zad3Inside(paramater: Osoba) =
      paramater.toString() match {
        case "Marcin Lukaszuk"  => "Czesc Marcin"
        case "Lukasz Marciniuk" => "Czesc Lukasz"
        case default            => "Czolem nieznajomy"
      }

    println(Zad3Inside(person1))
    println(Zad3Inside(person2))
    println(Zad3Inside(person3))
  }

  def Zad4(calkowita: Int, p: Int => Int): Int = { p(p(p(calkowita))) }

  def Zad5() {
    var person1 = new OsobaZad5("Marcin", "Lukaszuk", 100) with Pracownik
    var person2 = new OsobaZad5("Marcin", "Lukaszuk", 100) with Student
    var person3 = new OsobaZad5("Marcin", "Lukaszuk", 100) with Nauczyciel
    var person4 = new OsobaZad5("Marcin", "Lukaszuk", 100)
      with Student
      with Pracownik
    var person5 = new OsobaZad5("Marcin", "Lukaszuk", 100)
      with Pracownik
      with Student

    println("Zad5")
    println("Pracownik " + person1.podatek)
    println("Student " + person2.podatek)
    println("Nauczyciel " + person3.podatek)
    println("Student Pracownik " + person4.podatek)
    println("Pracownik Student " + person5.podatek)
  }

  println("Zad1 Poniedzialek " + Zad1("Poniedzialek"))
  println("Zad1 Wtorek " + Zad1("Wtorek"))
  println("Zad1 Poniedzialek2 " + Zad1("Poniedzialek2"))
  Zad2();
  Zad3();
  println("Zad4 " + Zad4(2, x => x * 2))
  Zad5()

}

class KontoBankowe(var stanKonta: BigDecimal) {

  def this() {
    this(0)
  }

  def Wplata(kwota: BigDecimal) {
    this.stanKonta = this.stanKonta + kwota;
  }

  def Wyplata(kwota: BigDecimal) {
    this.stanKonta = this.stanKonta - kwota;
  }
}

class Osoba(val firstName: String, val lastName: String) {
  override def toString(): String = this.firstName + " " + this.lastName
}


 trait OsobaZad5Trait{
  def podatek=0
 }

abstract class OsobaZad5 ( 
    val firstName: String,
    val lastName: String,
    private var _podatek: Int
) extends OsobaZad5Trait{



}

trait Student  extends OsobaZad5Trait{
 override def podatek = 0

}

trait Pracownik extends OsobaZad5Trait {
  var pensja = 0
 override def podatek = 20
}
trait Nauczyciel extends Pracownik {

  override def podatek = 10
}
