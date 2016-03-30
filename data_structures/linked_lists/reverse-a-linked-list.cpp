//https://www.hackerrank.com/challenges/reverse-a-linked-list
/*
  Reverse a linked list and return pointer to the head
  The input list will have at least one element  
  Node is defined as 
  struct Node
  {
     int data;
     struct Node *next;
  }
*/
Node* Reverse(Node *head)
{
    Node* node = NULL;
    Node* next = NULL;
    for(Node* temp = head; temp != NULL;){
        node = temp;
        temp = node->next;
        node->next = next;
        next = node;
    }
    return node;
}
