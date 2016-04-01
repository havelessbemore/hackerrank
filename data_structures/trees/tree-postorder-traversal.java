//https://www.hackerrank.com/challenges/tree-postorder-traversal

/* You only have to complete the function given below.
    class Node {
        int data;
        Node left;
        Node right;
    }
*/

void Postorder(Node root) {
    if(root != null){
        Postorder(root.left);
        Postorder(root.right);
        System.out.print(root.data + " ");
    }
}
