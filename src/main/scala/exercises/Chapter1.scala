package exercises

object Chapter1 {

  //we can use reduceLeft to take a list of items, with some value we want to compare
  //perhaps to get the greatest value? and return that highest value

  case class Player(name: String, score: Int)

  val players = Seq(
    Player("sue", 1),
    Player("danny", 7),
    Player("rich", 9),
    Player("guy", 6),
    Player("dudeman", 4),
    Player("winnaaadunn", 54)
  )

  //reduce left is simple when you read the source. basically, just iterate one by one
  //over the collection, comparing each pair p1 and p2 as you go and returning one of the two.
  val result = players.reduceLeft((p1, p2) => if(p1.score > p2.score) p1 else p2)
  println(result.score, result.name)

  import data_types.TryPractice

  val _ = new TryPractice()
}
