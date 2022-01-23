package leetcode_web;

import org.junit.Test;

public class 两数相加_2 {

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

        ListNode head;

        ListNode l = new ListNode(0, null);


        head = l;

        while (l1 != null || l2 != null) {

            if (l1 == null) l1 = new ListNode(0,null);
            if (l2 == null) l2 = new ListNode(0,null);


            if (l1.val + l2.val <= 9){
                l.val = l1.val + l2.val;
            }else {
                l.val = l1.val + l2.val - 10;
                l2.next = l2add1(l2.next);
            }


            l1 = l1.next;
            l2 = l2.next;

            if (l1 != null || l2 != null) {
                l.next = new ListNode(0, null);
                l = l.next;
            }
        }
        return head;

    }



    public ListNode l2add1(ListNode l2){
        if (l2 == null){
            l2 = new ListNode(1,null);
        }else {
            if (l2.val < 9){
                l2.val += 1;
            }else {
                l2.val = 0;
                l2.next = l2add1(l2.next);
            }
        }
        return l2;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode head;
        ListNode l = new ListNode(0, null);
        head = l;

        int carry = 0;

        while (l1 != null || l2 != null || carry == 1) {
            if (l1 == null) l1 = new ListNode(0,null);
            if (l2 == null) l2 = new ListNode(0,null);

            l.val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;


            l1 = l1.next;
            l2 = l2.next;

            if (l1 != null || l2 != null || carry == 1) {
                l.next = new ListNode(0, null);
                l = l.next;
            }
        }
        return head;

    }

    @Test
    public void T0() {
        ListNode l1 = new ListNode(5, null);
        l1.next = new ListNode(9, null);
        ListNode l2 = new ListNode(5, null);

        ListNode l = addTwoNumbers(l1, l2);

        while (l != null){
            System.out.println(l.val);
            l = l.next;
        }
    }

    @Test
    public void T1() {
        ListNode l2 = new ListNode(9, null);
        l2.next = new ListNode(9, null);

        l2 = l2add1(l2);

        while (l2 != null){
            System.out.println(l2.val);
            l2 = l2.next;
        }
    }

    @Test
    public void Test_addTwoNumbers2() {
        ListNode l1 = new ListNode(5, null);
        l1.next = new ListNode(9, null);
        ListNode l2 = new ListNode(5, null);

        ListNode l = addTwoNumbers2(l1, l2);

        while (l != null){
            System.out.println(l.val);
            l = l.next;
        }
    }

}
