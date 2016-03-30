//https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail
int GetNode(Node *head,int positionFromTail)
{
    Node* anchor = head;
    while (positionFromTail-- > 0){
        head = head->next;
    }
    while (head->next != NULL){
        head = head->next;
        anchor = anchor->next;
    }
    return anchor->data;
}
