import java.math.BigInteger;

public class AddTwoNumbers {

    /**
     * You are given two non-empty linked lists representing two non-negative
     * integers.
     * 
     * The digits are stored in reverse order and each of their nodes contain a
     * single digit.
     * 
     * Add the two numbers and return it as a linked list.
     * 
     * You may assume the two numbers do not contain any leading zero, except the
     * number 0 itself.
     * 
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 
     * Output: 7 -> 0 -> 8
     * 
     * Explanation: 342 + 465 = 807
     * 
     */

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String value1 = "";
        String value2 = "";
        while (l1 != null) {
            value1 = Integer.toString(l1.val) + value1;
            l1 = l1.next;
        }
        while (l2 != null) {
            value2 = Integer.toString(l2.val) + value2;
            l2 = l2.next;
        }
        BigInteger bi1 = new BigInteger(value1);
        BigInteger bi2 = new BigInteger(value2);
        BigInteger b3 = bi1.add(bi2);

        String stringSum = b3 + "";

        ListNode result = new ListNode();
        ListNode temp = result;

        for (int i = stringSum.length(); i > 0; i--) {
            temp.next = new ListNode(Integer.parseInt(stringSum.substring(i - 1, i)));
            temp = temp.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        // 321 + 765 = 1086

        AddTwoNumbers addTwoNumbersClass = new AddTwoNumbers();
        AddTwoNumbers.ListNode listNode1 = addTwoNumbersClass.new ListNode(1);
        listNode1.next = addTwoNumbersClass.new ListNode(2);
        listNode1.next.next = addTwoNumbersClass.new ListNode(3);

        AddTwoNumbers.ListNode listNode2 = addTwoNumbersClass.new ListNode(5);
        listNode2.next = addTwoNumbersClass.new ListNode(6);
        listNode2.next.next = addTwoNumbersClass.new ListNode(7);

        AddTwoNumbers.ListNode temp = listNode1;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println("=====");
        AddTwoNumbers.ListNode temp1 = listNode2;
        while (temp1 != null) {
            System.out.println(temp1.val);
            temp1 = temp1.next;
        }

        System.out.println("=====");
        AddTwoNumbers.ListNode temp3 = addTwoNumbersClass.addTwoNumbers(listNode1, listNode2);
        System.out.println("=====");

        String result = "";
        while (temp3 != null) {
            System.out.println(temp3.val);
            result += Integer.toString(temp3.val);
            temp3 = temp3.next;
        }
        System.out.println("Result = " + result);

    }
}