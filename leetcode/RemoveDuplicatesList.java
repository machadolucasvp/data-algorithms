package leetcode;

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