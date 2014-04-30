//https://www.hackerrank.com/challenges/fp-list-length
object Solution extends App {
	def f(arr : List[Int]) : Int = {
	    return (arr.zipWithIndex.last)._2 + 1;
	}
	println(f(io.Source.stdin.getLines.toList.map(_.trim).map(_.toInt)))
}