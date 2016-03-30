//https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list
Node* InsertNth(Node *head, int data, int position)
{
    Node* node;
    Node* temp;
    if (position == 0){
        temp = head;
        head = node = new Node();
    } else {
        for (node = head; --position > 0; node = node->next){}
        temp = node->next;
        node = node->next = new Node();
    } 
    node->data = data;
    node->next = temp;
    return head;
}
