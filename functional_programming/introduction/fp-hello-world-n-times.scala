//https://www.hackerrank.com/challenges/fp-hello-world-n-times
object Solution extends App {
	def f(n : Int) = {
	    for(i <- 0 until n){
	        println("Hello World");
	    }
	}
	var n = readInt
  	f(n)
}