//https://www.hackerrank.com/challenges/tree-inorder-traversal

/* You only have to complete the function given below.
    class Node {
        int data;
        Node left;
        Node right;
    }
*/

void Inorder(Node root) {
    if(root != null){
        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);
    }
}
