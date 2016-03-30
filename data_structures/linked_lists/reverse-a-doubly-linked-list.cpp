//https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list
/*
   Reverse a doubly linked list, input list may also be empty
   Node is defined as
   struct Node
   {
     int data;
     Node *next;
     Node *prev
   }
*/
Node* Reverse(Node* head)
{
    Node* node = NULL;
    for(Node* temp = head; temp != NULL;){
        node = temp;
        temp = node->next;
        node->next = node->prev;
        node->prev = temp;
    }
    return node;
}
