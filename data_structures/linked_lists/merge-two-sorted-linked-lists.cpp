//https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists
Node* MergeLists(Node *headA, Node* headB)
{
    Node* c;
    Node* a = headA;
    Node* b = headB;
    Node* head = new Node();
    for(c = head; a != NULL && b != NULL; c = c->next){
        if (a->data < b->data) {
            c->next = a;
            a = a->next;
        } else {
            c->next = b;
            b = b->next;
        }
    }
    c->next = (a == NULL) ? b : a;
    c = head->next;
    free(head);
    return c;
}
