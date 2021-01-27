object Main extends App {
  def dividers: Iterator[(Int, Int)] =
    for {
      a <- Iterator.from(1)
      b <- 1 until a + 1 if a % b == 0
    } yield (a, b)

  def Zad1() = {
    println("Zad1")
    val divider = dividers.buffered
    val iter1 = divider.take(20)

    while (iter1.hasNext) {
      println(iter1.next())
    }
  }
  def Zad2() = {
    println("Zad2")
    val lista = List(1, 1, 2, 2);
    println(lista)
    val mapper = new Mapper(lista)
    println(mapper.map(x => List(x, x)))
    println(mapper.flatMap(x => List(x, x)))

  }

  Zad1();
  Zad2();
}

trait Maybe[+A] {
  def map[R](f: A => R): List[R]

  def flatMap[R](f: A => List[R]): List[R]
}

class Mapper[A](var a: List[A]) extends Maybe[A] {

  override def map[R](f: A => R): List[R] = {
    for (value <- a) yield f(value)
  }

  override def flatMap[R](f: A => List[R]): List[R] = {
    val initialList = List.empty[R]
    def flatMapReku(in: List[A], out: List[R]): List[R] = {
      in match {
        case Nil          => out
        case head :: Nil  => out ::: f(head)
        case head :: tail => flatMapReku(tail, out ::: f(head))
      }
    }
    flatMapReku(a, initialList)
  }
}
