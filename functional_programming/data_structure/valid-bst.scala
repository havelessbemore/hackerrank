//https://www.hackerrank.com/challenges/valid-bst
import java.io._;

object Solution {
    
    class Node(v: Byte) {
        var value: Byte = v;
        var left: Node = null;
        var right: Node = null;
    }
    
    def main(args: Array[String]) {
        var T: Byte = readLine().toByte;
        for(t <- 0 until T){
            var N: Byte = readLine().toByte;
            var A: Array[Node] = new Array[Node](N);
            N = 0;
            for(s <- readLine().split(" ")){
                A(N) = new Node(s.toByte);
                N = (N + 1).toByte;
            }
            if(isBSTPreorder(A)){
                println("YES");
            } else {
                println("NO");
            }
        }
    }

    //Usually you would seperate the logic of creating
    //the tree and the iteration through it, checking
    //if it matches the bst string given. This approach
    //is intended only for this challenge.
    def isBSTPreorder(nodes: Array[Node]): Boolean = {
         var tree: Node = null;
         for(node <- nodes){
             if (tree == null){
                 tree = node;
             } else if(!add(tree, node)){
                 return false;
             }
         }
        return true;
    }
    
    def add(parent: Node, node: Node): Boolean = {
        if (node.value < parent.value){
            if (parent.right != null){
                return false;
            }
            if (parent.left == null){
                parent.left = node;
                return true;
            }
            return add(parent.left, node);
        }
        if(parent.right == null){
            parent.right = node;
            return true;
        }
        return add(parent.right, node);
    }
}