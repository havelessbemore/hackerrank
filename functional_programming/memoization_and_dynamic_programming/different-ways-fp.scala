//https://www.hackerrank.com/challenges/different-ways-fp
import scala.collection.mutable._;

object Solution {

    var MOD: Int = 100000007;

    class Node(var i: Int, var n: Int, var k: Int){
    	var value: Int = 1;
    }

    def main(args: Array[String]) {
    	var T: Short = readShort();
    	var nodes: Array[Node] = new Array[Node](T);
    	for(i <- 0 until T){
            var Array(n, k) = readLine().split(" ").map(_.toShort);
            nodes(i) = new Node(i, n, k);
        }

        nodes = nodes.sortWith((a, b) => a.n < b.n);
        var row: Array[Int] = new Array[Int](nodes.last.n+1);
        row(0) = 1;
        var n: Int = 0;
        for(node <- nodes){
        	while (n < node.n){
        		for(i <- n until 0 by -1){
        			row(i) = (row(i) + row(i-1))%MOD;
        		}
                n += 1;
                row(n) = 1;
        	}
        	node.value = row(node.k);
        }

        nodes = nodes.sortWith((a, b) => a.i < b.i);
        for(node <- nodes){
        	println(node.value);
        }
    }
}