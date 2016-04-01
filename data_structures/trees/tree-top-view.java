//https://www.hackerrank.com/challenges/tree-top-view

/* You only have to complete the function given below.
    class Node {
        int data;
        Node left;
        Node right;
    }
*/

void top_view(Node root){
    top_left(root);
    top_right(root.right);
}

void top_left(Node root){
    if(root != null){
        top_left(root.left);
        System.out.print(root.data + " ");
    }
}

void top_right(Node root){
    if(root != null){
        System.out.print(root.data + " ");
        top_right(root.right);
    }
}
