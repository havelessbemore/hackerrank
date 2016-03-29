//https://www.hackerrank.com/challenges/swap-nodes
import scala.collection.mutable._;

object Solution {
    
    class Node(var value: Int){
        var left: Node = null;
        var right: Node = null;
    }
    
    def printTree(root: Node, sb: StringBuilder){
        if (root != null){
            printTree(root.left, sb);
            sb.append(root.value + " ");
            printTree(root.right, sb);
        }
    }
    
    def main(args: Array[String]) {
        //Input
        val n: Short = readShort();
        
        //Setup
        val nodes: Array[Node] = new Array[Node](n);
        val depths: ArrayBuffer[Int] = new ArrayBuffer[Int]();
        
        //Initialize
        var size: Int = 1;
        var prevSize: Int = 0;
        nodes(0) = new Node(1);
        depths.append(prevSize);
        
        //Until all input lines are processed
        while (prevSize < size){
            val temp: Int = prevSize;
            depths.append(size);
            prevSize = size;
            
            //Add nodes per depth
            for(i <- temp until size){
                val Array(a, b) = readLine().split(" ").map(_.toShort);
                if (a != -1){
                    var node: Node = new Node(a);
                    nodes(i).left = node;
                    nodes(size) = node;
                    size += 1;
                }
                if (b != -1){
                    var node: Node = new Node(b);
                    nodes(i).right = node;
                    nodes(size) = node;
                    size += 1;
                }
            }
        }
        
        //For each test
        var maxDepth = depths.size - 1;
        for(t <- readByte() until 0 by -1){
            
            //For each depth
            var k: Short = readShort();
            for(h <- k-1 until maxDepth by k){
                for(i <- depths(h) until depths(h+1)){
                    
                    //Swap the nodes
                    val parent: Node = nodes(i);
                    val child: Node = parent.left;
                    parent.left = parent.right;
                    parent.right = child;
                }
            }
            
            //Print the new tree
            val sb: StringBuilder = new StringBuilder();
            printTree(nodes(0), sb);
            println(sb);
        }
    }
}