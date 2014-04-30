//https://www.hackerrank.com/challenges/fp-update-list
object Solution extends App {
	def f(arr : List[Int]) : List[Int] = {
	    return arr.map(x => x.abs);
	}
	println(f(io.Source.stdin.getLines.toList.map(_.trim).map(_.toInt)).map(_.toString).mkString("\n"))
}