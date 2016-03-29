//https://www.hackerrank.com/challenges/prison-transport
//See: https://www.hackerrank.com/contests/lambda-calculi-may14/challenges/prison-transport
import scala.collection.mutable._;

object Solution {
    
    def main(args: Array[String]) {
        val n: Int = readInt();
        val m: Int = readInt();
        val isVisited: Array[Boolean] = (new Array[Boolean](n)).map((_) => false);
        val edges: Array[ArrayBuffer[Int]] = (new Array[ArrayBuffer[Int]](n)).map((_) => new ArrayBuffer[Int]());
        
        //Connect the grouped nodes
        for(i <- 0 until m){
            val Array(p, q) = readLine().split(" ").map(_.toInt - 1);
            edges(p).append(q);
            edges(q).append(p);
        }
        
        //Initialize total cost
        var totalCost: Int = 0;
        
        //For every unvisited node
        var groupLength: Int = 0;
        val group: Array[Int] = new Array[Int](m+1);
        for(i <- 0 until n if !isVisited(i)){
            
            //Initialize group with current node
            group(0) = i;
            groupLength = 1;
            isVisited(i) = true;
            
            //Fill group with rest of nodes
            var groupI: Int = 0;
            do {
                //print(group(si) + " ")
                for(k <- edges(group(groupI)) if !isVisited(k)){
                    isVisited(k) = true;
                    group(groupLength) = k;
                    groupLength += 1;
                }
                groupI += 1;
            } while (groupI < groupLength);
            //println("");
            
            //Get cost of group
            //Add the cost to total cost
            totalCost += math.ceil(math.sqrt(groupLength)).toInt;
        }
        
        //Print
        print(totalCost);
    }
}
