//https://www.hackerrank.com/challenges/missing-numbers-fp
import java.io._;

object Solution {
    def main(args: Array[String]) {
        /*var N: Int = */readLine().toInt;
        var A: Array[Short] = readLine().split(" ").map((x) => x.toShort);
        /*var M: Int = */readLine().toInt;
        var B: Array[Short] = readLine().split(" ").map((x) => x.toShort);
        var offset: Int = B.min;
        var counts: Array[Byte] = new Array[Byte](B.max - offset + 1);
        for(v <- B){
            counts(v - offset) = (counts(v - offset) + 1).toByte;
        }
        for(v <- A){
            counts(v - offset) = (counts(v - offset) - 1).toByte;
        }
        for(i <- 0 until counts.length if counts(i) > 0){
            print((i + offset) + " ");
        }
    }
}