/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { 
 *         this.val = val; 
 *         this.next = next; 
 *     }
 * }
 */

class Solution {
    public ListNode mergeNodes(ListNode head) {

        // Dummy node to build the answer list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Skip the first 0
        head = head.next;

        int sum = 0;

        while (head != null) {

            // If current node is not 0, keep adding its value
            if (head.val != 0) {
                sum += head.val;
            } 
            else {
                // Reached a separator (0)
                // Create a new node with the accumulated sum
                tail.next = new ListNode(sum);
                tail = tail.next;

                // Reset sum for the next segment
                sum = 0;
            }

            // Move to the next node
            head = head.next;
        }

        // Return the merged linked list
        return dummy.next;
    }
}