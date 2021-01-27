object Main extends App {

  def Zad1() {
    println("Zad1")
    val x = new Container(1)
    println(x.getContent)
    println(x.applyFunction(in => x.getContent() + 1))
    println(x.applyFunction(in => x.getContent() + 2))
  }

  def Zad2() {
    println("Zad2")
    val no = new No()
    val yes = new Yes(1)

    println(no.isInstanceOf[Maybe[_]])
    println(yes.isInstanceOf[Maybe[_]])
  }

  def Zad3() {
    println("Zad3")
    val no = new No()
    val yes = new Yes(1)

    println(no.applyFunction(x => 1))
    println(yes.applyFunction(x => 1))
  }
  def Zad4() {
    println("Zad4")
    val no = new No()
    val yes = new Yes(2)

    println(no.getOrElse(1))
    println(yes.getOrElse(1))
  }
  Zad1();
  Zad2();
  Zad3();
  Zad4();
}
//1
class Container[A](private val x: A) {
  def getContent(): A = x;
  def applyFunction[R](f: A => R): R = f(x)
}

//2
trait Maybe[+A] {
  def applyFunction[R](f: A => R): Maybe[R]
  def getOrElse[R >: A](a: => R): R
}

class No extends Maybe[Nothing] {
  override def applyFunction[R](f: Nothing => R): No = {
    new No()
  }
  override def getOrElse[R >: Nothing](x: => R): R = x
}

class Yes[A](val a: A) extends Maybe[A] {
  override def applyFunction[R](f: A => R): Yes[R] = {
    new Yes(f(a))
  }

  override def getOrElse[R >: A](x: => R): R = a
}
