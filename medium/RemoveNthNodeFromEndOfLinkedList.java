/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = removeNthFromEndHelper(head, n);

        if (count == n +1) {
            return head.next;
        }

        return head;
    }

    private int removeNthFromEndHelper(ListNode head, int n) {
        if (head == null) {
            return 1;
        }
        int currentPlace = removeNthFromEndHelper(head.next, n);
        if(currentPlace == n+1) {
            head.next = head.next.next;
        }
        return currentPlace+1;
    } 
}