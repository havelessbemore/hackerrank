//https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor

/* You only have to complete the function given below.
    class Node {
        int data;
        Node left;
        Node right;
    }
*/

static Node lca(Node root, int v1, int v2){
    if(root == null){
        return null;
    }
    
    if(v1 > v2){
        final int v3 = v1;
        v1 = v2;
        v2 = v3;
    }
    
    do {
        if(v2 < root.data && root.left != null){
            root = root.left;
        } else if (v1 > root.data && root.right != null){
            root = root.right;
        } else {
            return root;
        }
    } while (true);
}
