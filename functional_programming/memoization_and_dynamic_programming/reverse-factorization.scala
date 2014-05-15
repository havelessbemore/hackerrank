//https://www.hackerrank.com/challenges/reverse-factorization
import scala.collection.mutable._;
import java.util.Arrays;

object Solution {
    
    def main(args: Array[String]) {
        var temp: Array[String] = readLine().split(" ");
        var n: Int = temp(0).toInt;
        var k: Byte = temp(1).toByte;
        var as: Array[Byte] = readLine().split(" ").map((x) => x.toByte);
        
        //Remove nonfactors of n
        //to speed up recursion process
        as = as.filter((x) => n%x == 0);
        
        //Reverse sort array so that
        //first match is smallest set
        Arrays.sort(as);
        as = as.reverse;
        
        var ab: ArrayBuffer[Byte] = new ArrayBuffer[Byte]();
        if (solve(as, 0, n, ab)){
            n = 1;
            ab.append(1);
            for(v <- ab.reverse){
                n *= v;
                print(n + " ");
            }
        } else {
            print(-1);
        }
    }
    
    def solve(as: Array[Byte], curI: Byte, curN: Int, factors: ArrayBuffer[Byte]): Boolean = {
        if (curN == 1){
            return true;
        }
        if (curN < 1 || curI >= as.length){
            return false;
        }
        if (curN%as(curI) == 0){
            factors.append(as(curI));
            if (solve(as, curI, curN/as(curI), factors)){
                return true;
            }
            factors.trimEnd(1);
        }
        return solve(as, (curI+1).toByte, curN, factors);
    }
}