//https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list
/*
    Insert Node in a doubly sorted linked list 
    After each insertion, the list should be sorted
   Node is defined as
   struct Node
   {
     int data;
     Node *next;
     Node *prev
   }
*/
Node* SortedInsert(Node *head,int data)
{
    //Create node
    Node* node = new Node();
    node->data = data;
    node->next = NULL;
    node->prev = NULL;
    //Check if empty list
    if (head == NULL){
        return node;
    }
    //Check if less than head
    if (data <= head->data){
        node->next = head;
        head->prev = node;
        return node;
    }
    //Find position
    Node* cur = head;
    while (cur->next != NULL && data > cur->next->data){
        cur = cur->next;
    }
    //Insert
    node->prev = cur;
    if (cur->next != NULL){
        node->next = cur->next;
        cur->next->prev = node;
    }
    cur->next = node;
    return head;
}
