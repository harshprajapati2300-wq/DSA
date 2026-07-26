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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // No need to reverse if list is empty or has only one node in the range
        if (head == null || left == right) {
            return head;
        }

        // Create a dummy node to handle edge cases (e.g., reversing from head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Move 'prev' to the node just before the 'left' position
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // 'curr' points to the first node of the sublist to be reversed
        ListNode curr = prev.next;

        // Reverse the sublist using head insertion technique
        for (int i = 0; i < right - left; i++) {

            // Store the next node
            ListNode next = curr.next;

            // Remove 'next' from its current position
            curr.next = next.next;

            // Insert 'next' at the beginning of the reversed part
            next.next = prev.next;
            prev.next = next;
        }

        // Return the new head of the list
        return dummy.next;
    }
}