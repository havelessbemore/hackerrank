//https://www.hackerrank.com/challenges/fp-list-replication
object Solution extends App {

	def f(num : Int, arr : List[Int]) : List[Int] = {
	    val out : Array[Int] = new Array[Int](num*arr.length);
	    for(i <- 0 until arr.length){
	        val offset : Int = i*num;
	        for(n <- 0 until num){
	            out(offset + n) = arr(i);
	        }
	    }
	    return out.toList;
	}

	def displayResult(arr:List[Int]) = println(f(arr(0).toInt,arr.drop(1)).map(_.toString).mkString("\n"))
	  displayResult(io.Source.stdin.getLines.toList.map(_.trim).map(_.toInt))
	}
}