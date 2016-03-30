//https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list
void Print(Node *head)
{
    for(Node* node = head; node != NULL; node = node->next){
        cout << node->data << '\n';
    }
}
