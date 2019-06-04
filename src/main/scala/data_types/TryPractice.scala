package data_types

import scala.util.{Success, Try}

class TryPractice {

  val tryResult = Try {
    2/0
  }
  println(tryResult)


  def returnsTry(): Try[Int] = {
    val result = 1
    val exception = 2/0
    println(exception)
    Success(result)

  }

  println(returnsTry())
}
