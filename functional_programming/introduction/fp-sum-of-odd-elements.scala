//https://www.hackerrank.com/challenges/fp-sum-of-odd-elements
object Solution extends App {
	def f(arr : List[Int]) : Int = {
	    return arr.filter(x => (x & 1) == 1).sum
	}
	println(f(io.Source.stdin.getLines.toList.map(_.trim).map(_.toInt)))
}