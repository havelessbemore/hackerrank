//https://www.hackerrank.com/challenges/fibonacci-fp
import scala.collection.mutable._;

object Solution {

    var MOD: Int = 100000007;
    
    def main(args: Array[String]) {
        var fibs: ArrayBuffer[Int] = new ArrayBuffer[Int]();
        fibs.append(0, 1);
        for(t <- readShort() until 0 by -1){
            var n: Int = readShort();
            for(size <- fibs.size to n){
                fibs.append((fibs.last + fibs(size-2))%MOD);
            }
            println(fibs(n))
        }
    }
}