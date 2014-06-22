//https://www.hackerrank.com/challenges/pentagonal-numbers
//See: https://www.hackerrank.com/contests/lambda-calculi-may14/challenges/pentagonal-numbers
import scala.collection.mutable._;

/*
f(1) = 1
f(2) = 5
f(3) = 12
f(4) = 22
f(5) = 25
----------
  01  05  12  22  35  ...
01  04  07  10  13  ...
  03  03  03  03  ...
----------
f(n) = 1 + 3*(n-1) + f(n-1)
*/

object Solution {
    
    def main(args: Array[String]) {
        var velocity: Long = 1;
        val acceleration: Int = 3;
        val sb: StringBuilder = new StringBuilder();
        val pents: ArrayBuffer[Long] = new ArrayBuffer[Long]();
        pents.append(0);
        
        //For every test case
        for(t <- 0 until readInt()){
            val n: Int = readInt();
            for(i <- pents.length to n){
                pents.append(pents(i-1) + velocity);
                velocity += acceleration;
            }
            sb.append(pents(n) + "\n");
        }
        
        //Print
        print(sb);
    }
}
