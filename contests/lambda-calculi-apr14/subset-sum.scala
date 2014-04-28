//https://www.hackerrank.com/contests/lambda-calculi-apr14/challenges/subset-sum
import java.io._;
import scala.util._;

object Solution {

    def main(args: Array[String]) {
    	//Get size of array
        var N : Int = readLine().toInt;
        //Get array
        var A : Array[Long] = readLine().split(" ") map(_.toLong);
        //We're looking for the smallest subset that will sum to
        //greater than or equal a number given by each test. Bigger
        //numbers sum quicker of course so let's order the array
        //in descending order.
        A = A.sortBy(-_);
        //We'll be going through the array and either subtracting
        //from the test value (S) until <= 0 or summing up each index
        //until >= S. Let's sum up the index beforehand to cache it.
        for(i <- 1 until A.length){
            A(i) += A(i-1);
        }
        val sb : StringBuilder = new StringBuilder();
        for(t <- readLine().toInt until 0 by -1){
        	//Now that we know the biggest sums we can get
        	//for each set size, just check if at what point
        	//our array equals or passes S.
            val S : Long = readLine().toLong;
            val index = binarySearch(A, S);
            //If it does, that index + 1 (since arrays start at 0)
            //is the smallest subset possible that's >= S.
            var size = -1;
            if (index < A.length){
                size = index + 1;
            }
            sb.append(size).append("\n");
        }
        println(sb);
    }

    def binarySearch(ar : Array[Long], v : Long) : Int = {
        var min : Int = 0;
        var max : Int = ar.length;
        while (min < max){
            val mid : Int = min + ((max - min) >> 1);
            val midVal : Long = ar(mid);
            if (v > midVal){
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }
}