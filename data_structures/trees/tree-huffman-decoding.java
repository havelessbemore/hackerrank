//https://www.hackerrank.com/challenges/tree-huffman-decoding

/* You only have to complete the function given below.
    class Node {
        int freq;
        char data;
        Node left;
        Node right;
    }
*/

void decode(String S, Node root){
    
    //Sanitize inputs
    if(root == null || S == null){
        return;
    }
    
    //Decode
    Node node = root;
    final StringBuilder sb = new StringBuilder();
    for(char c : S.toCharArray()){
        node = (c == '0') ? node.left : node.right;
        if(node.data != '\0'){
            sb.append(node.data);
            node = root;
        }
    }
    
    //Print output
    System.out.print(sb);
}
