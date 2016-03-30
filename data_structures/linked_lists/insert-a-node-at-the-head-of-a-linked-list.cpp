//https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list
Node* Insert(Node *head,int data)
{
    Node* node = new Node();
    node->data = data;
    node->next = head;
    return node;
}
