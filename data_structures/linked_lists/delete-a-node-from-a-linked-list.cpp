//https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list
Node* Delete(Node *head, int position)
{
    Node* node;
    Node* temp;
    if (position == 0){
        temp = head;
        head = head->next;
    } else {
        for (node = head; --position > 0; node = node->next){}
        temp = node->next;
        node->next = temp->next;
    }
    free(temp);
    return head;
}
