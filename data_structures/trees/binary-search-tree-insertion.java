//https://www.hackerrank.com/challenges/binary-search-tree-insertion

/* You only have to complete the function given below.
    class Node {
        int data;
        Node left;
        Node right;
    }
*/

static Node Insert(Node root,int value){
    if(root == null){
        root = new Node();
        root.data = value;
    } else if(root.data < value){
        root.right = Insert(root.right, value);
    } else {
        root.left = Insert(root.left, value);
    }
    return root;
}
