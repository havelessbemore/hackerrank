//https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle
/*
  Detect loop in a linked list 
  List could be empty also
  Node is defined as 
  struct Node
  {
     int data;
     struct Node *next;
  }
*/
int HasCycle(Node* head)
{
    Node* slow = head;
    Node* fast1 = head;
    Node* fast2 = head;
    while (
        slow != NULL 
        && (fast1 = fast2->next) != NULL 
        && (fast2 = fast1->next) != NULL
    ){
        if (slow == fast1 || slow == fast2){
            return 1;
        }
        slow = slow->next;
    }
    return 0;
}
