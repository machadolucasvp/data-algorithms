package leetcode;

/**
 * Challenge: Given a sorted linked list, delete all duplicates such that each
 * element appear only once.
 * Time-Complexity of Solution Provided: O(n)
 * Space-Complexity of Solution Provided: O(1)
 */

class RemoveDuplicatesList {

    public class ListNode {
        private Integer value;
        private ListNode next;

        public ListNode(Integer value) {
            this.value = value;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode currentHead = head;
        while (currentHead != null && currentHead.next != null) {
            if (currentHead.next.value == currentHead.value) {
                currentHead.next = currentHead.next.next;
            } else {
                currentHead = currentHead.next;
            }
        }
        return head;
    }

}