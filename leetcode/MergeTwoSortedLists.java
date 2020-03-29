package leetcode;

/**
 * Challenge: Merge two sorted linked lists and return it as a new list. The new
 * list should be made by splicing together the nodes of the first two lists.
 * Time-Complexity of Solution Provided: O(n)
 * Space-Complexity of Solution Provided: O(1)
 */

 public class MergeTwoSortedLists{

    public class ListNode{
        private Integer value;
        private ListNode next;
        public ListNode(Integer value){
            this.value=value;
        }
    }

     public static ListNode mergeList(ListNode listOne,ListNode listTwo){
         if(listTwo == null) return listOne;
         if(listOne == null) return listTwo;

         if(listOne.value < listTwo.value){
             listOne.next=listTwo;
             listTwo = mergeList(listTwo, listOne.next);
             return listTwo;
         }else {
             listTwo.next=listOne;
             listOne = mergeList(listOne, listTwo.next);
             return listOne;
         }

     }
 }
