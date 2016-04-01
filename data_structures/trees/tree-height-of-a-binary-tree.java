//https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree

/* You only have to complete the function given below.
    class Node {
        int data;
        Node left;
        Node right;
    }
*/

int height(Node root){
    return (root == null) ? 0 : 1 + Math.max(height(root.left), height(root.right));
}
