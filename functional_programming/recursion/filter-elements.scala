//https://www.hackerrank.com/challenges/filter-elements
//See: https://www.hackerrank.com/contests/lambda-calculi-may14/challenges/filter-elements
import scala.collection.mutable._;

object Solution {
    
    def main(args: Array[String]) {
        
        //For every test case
        for(t <- readByte() until 0 by -1){
            //Get input
            val Array(n, k) = readLine().split(" ").map(_.toShort);
            val arr: Array[Int] = readLine().split(" ").map(_.toInt);
            
            //Initialize
            var length: Short = 0;
            var order: Array[Int] = new Array[Int](n);
            val counts: HashMap[Int, Short] = new HashMap[Int, Short]();
            
            //For every value a in arr
            //Count the number of occurrences
            //Record order values are first found
            for(a <- arr){
                val count: Short = counts.getOrElse(a, 0);
                counts.put(a, (count+1).toShort);
                if (count < 1){
                    order(length) = a;
                    length = (length+1).toShort;
                }
            }
            
            //Filter
            order = order.slice(0, length).filter(counts.get(_).get >= k);
            if (order.length < 1){
                println("-1");
            } else {
                println(order.mkString(" "));
            }
        }
    }
}
