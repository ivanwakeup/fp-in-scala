package exercises

import java.security.KeyStore.TrustedCertificateEntry

import scala.annotation.tailrec

object Chapter2 extends App {


  def factorial(num: Int): Int = {

    @tailrec
    //tailrec tells the compiler to compile this to
    //an iterative while loop essentially, removing the memory
    //cost of storing the stack frame. the call must be in the "tail" position to do this.
    def do_fact(num: Int, state: Int): Int = {
      if(num == 0) state else do_fact(num-1, state*num)
    }
    if(num==0) 0 else do_fact(num, 1)
  }

  //println(factorial(5))

  def fibonacci(num: Int, doFib: Int => Int): Int = {
    doFib(num)
  }

  def do_fib_iterative(num: Int): Int = {
    if(num < 2) return 1
    var n1 = 1
    var n2 = 1
    var result = 0
    (2 to num).foreach { _ =>
      result = n1 + n2
      n1 = n2
      n2 = result
    }
    result
  }

  def do_fib_recursive(num: Int): Int ={
    if(num < 2) 1 else do_fib_recursive(num-1) + do_fib_recursive(num-2)
  }


  def do_fib_tail_rec(num: Int): Int = {
    @tailrec
    def go(num: Int, n1: Int, n2:Int): Int = {
      if(num < 2) n1 + n2 else go(num-1, n2, n1+n2)
    }
    go(num, 0, 1)
  }

  //println(fibonacci(5, do_fib_tail_rec))


  //exercise 2
  def isSorted[A](arr: Array[A], gt: (A, A) => Boolean): Boolean = {
    if(arr.length < 2) true
    else {
      var res = true;
      (1 to arr.length-1).foreach { idx: Int =>
        val result = gt(arr(idx-1), arr(idx))
        if(!result) res = false
      }
      res
    }
  }

  val cmpFunc = (n1: Int, n2: Int) => n2 > n1

  //println(isSorted(Array(-1,0,-2),cmpFunc))

  /*
  we can't call f because not enough parameters?
   */
  def partial1[A,B,C](a: A, f: (A,B) => C): B => C = {
    (b: B) => f(a,b)
  }

  val res = partial1[Int, Int, Int](1, (n1, n2) => n1+n2)
  println(res(5))

  val adderFunction = (n1: Int, n2: Int) => n1 + n2
  val add5 = adderFunction(5, _)

  //println(add5(5))

  /*
  allows us to provide separate parameter lists to a function
  it's really not that complicated once you just think about
  following the return type and matching the generics up with the
  function
   */
  def curry[A,B,C](f: (A, B) => C): A => (B => C) = {
    (a: A) => (b: B) => f(a, b)
  }

  /*
  same here. just study the return type. (A, B) => C.
  so method body should look like a function that takes an A, B and returns
  a C from the return. we can get that by applying a: A then b: B to the input
  function f!
   */
  def uncurry[A,B,C](f: A => B => C): (A, B) => C = {
    (a: A, b: B) => f(a)(b)
  }



}