//https://www.hackerrank.com/challenges/tree-preorder-traversal

/* You only have to complete the function given below.
    class Node {
        int data;
        Node left;
        Node right;
    }
*/

void Preorder(Node root) {
    if(root != null){
        System.out.print(root.data + " ");
        Preorder(root.left);
        Preorder(root.right);
    }
}
