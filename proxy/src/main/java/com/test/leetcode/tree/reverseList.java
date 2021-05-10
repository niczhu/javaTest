package com.test.leetcode.tree;

public class reverseList {

    public static void main(String[] args) {


    }

    // 有环
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head, fast = head;
        while (null != fast && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static ListNode reverseList(ListNode head) {
        if (null == head || head.next == null) return head;

        ListNode cur = head;
        ListNode tempNode = reverseList(head.next);
        cur.next.next = cur;
        cur.next = null;
        return tempNode;
    }


    public static class ListNode {
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
}
