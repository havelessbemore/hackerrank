//https://www.hackerrank.com/challenges/tree-level-order-traversal

/* You only have to complete the function given below.
    class Node {
        int data;
        Node left;
        Node right;
    }
*/

void LevelOrder(Node root){
    if(root == null){
        return;
    }
    Deque<Node> q = new ArrayDeque<Node>();
    q.push(root);
    do {
        Node node = q.poll();
        System.out.print(node.data + " ");
        if(node.left != null){
            q.add(node.left);
        }
        if(node.right != null){
            q.add(node.right);
        }
    } while (!q.isEmpty());
}
