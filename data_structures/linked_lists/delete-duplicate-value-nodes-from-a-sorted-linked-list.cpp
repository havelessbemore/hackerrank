//https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list
/*
  Remove all duplicate elements from a sorted linked list
  Node is defined as 
  struct Node
  {
     int data;
     struct Node *next;
  }
*/
Node* RemoveDuplicates(Node *head)
{
    Node* cur = head;
    for (Node* node = cur->next; node != NULL; node = node->next){
        if (cur->data == node->data){
            cur->next = node->next;
            free(node);
            node = cur;
        } else {
            cur = node;
        }
    }
    return head;
}
