//https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists
int listLength(Node* head){
    int len = 0;
    while (head != NULL){
        len++;
        head = head->next;
    }
    return len;
}
Node* traverseN(Node* head, int n){
    while (n-- > 0){
        head = head->next;
    }
    return head;
}
int FindMergeNode(Node *headA, Node *headB){
    int lenA = listLength(headA);
    int lenB = listLength(headB);
    headA = traverseN(headA, lenA - lenB);
    headB = traverseN(headB, lenB - lenA);
    while (headA != headB){
        headA = headA->next;
        headB = headB->next;
    }
    return headA->data;
}
