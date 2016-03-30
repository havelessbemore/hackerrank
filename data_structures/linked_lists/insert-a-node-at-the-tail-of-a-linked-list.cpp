//https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list
/*
  Insert Node at the end of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  struct Node
  {
     int data;
     struct Node *next;
  }
*/
Node* Insert(Node *head,int data)
{
    Node* node;
    if (head == NULL){
        head = node = new Node();
    } else {
        for(node = head; node->next != NULL; node = node->next){}
        node = node->next = new Node();
    }
    node->data = data;
    node->next = NULL;
    return head;
}
