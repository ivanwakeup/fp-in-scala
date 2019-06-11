package exercises

object Chapter3 extends App {

  //remove element from a list
  def remove[A](ls: List[A]): List[A] = {
    ls match {
      case Nil => Nil
      case _ :: tail => tail
    }
  }

  def drop[A](n: Int, ls: List[A]): List[A] = {
    n match {
      case 0 => ls
      case num => drop(num-1, remove(ls))
    }
  }

  //the pass-by-name parameter is cool because we can pass
  //any function that returns a boolean, but its also
  //not helpful because if we want to do dropWhile based on elements
  //of the list its hard this way
  def dropWhile[A](ls: List[A], whl: => Boolean): List[A] = {
    if(whl && ls.nonEmpty) {
      dropWhile(remove(ls), whl)
    }
    else {
      ls
    }
  }

  val dropWhileFilterInt: Int => Boolean = (num: Int) => num < 50
  val dropWhileFilterRand: Int => Boolean = _ => Math.random() < 5000

  println(dropWhile(List(1,2,3,4), dropWhileFilterInt(5)))

}
