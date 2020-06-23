public class MergeTwoSortedLists {

    /**
     * Merge two sorted linked lists and return it as a new sorted list. The new
     * list should be made by splicing together the nodes of the first two lists.
     * 
     * Input: 1->2->4, 1->3->4
     * 
     * Output: 1->1->2->3->4->4
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode temp = result;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l2 == null) {
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                if (l1.val <= l2.val) {
                    temp.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    temp.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }
            temp = temp.next;
        }
        return result.next;
    }

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedLists m = new MergeTwoSortedLists();

        MergeTwoSortedLists.ListNode listNode1 = m.new ListNode(1);
        listNode1.next = m.new ListNode(2);
        listNode1.next.next = m.new ListNode(3);

        MergeTwoSortedLists.ListNode listNode2 = m.new ListNode(4);
        listNode2.next = m.new ListNode(5);
        listNode2.next.next = m.new ListNode(6);

        MergeTwoSortedLists.ListNode temp = listNode1;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

        System.out.println("=====");

        MergeTwoSortedLists.ListNode temp1 = listNode2;
        while (temp1 != null) {
            System.out.println(temp1.val);
            temp1 = temp1.next;
        }
        System.out.println("=====");
        System.out.println("=====");

        MergeTwoSortedLists.ListNode temp3 = m.mergeTwoLists(listNode1, listNode2);
        while (temp3 != null) {
            System.out.println(temp3.val);
            temp3 = temp3.next;
        }

    }
}