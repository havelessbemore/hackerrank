//https://www.hackerrank.com/challenges/fp-array-of-n-elements
object Solution extends App {
	def f(num:Int) : List[Int] = {
	    return List.fill(num)(0)
	}
	println(f(readInt).length)
}