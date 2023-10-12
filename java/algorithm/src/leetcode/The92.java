package leetcode;

import leetcode.util.ListNode;

public class The92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        if (left == 1) {
            ListNode temp = new ListNode();
            temp.next = head;
            return helper(temp, right);
        } else {
            int t = 1;
            ListNode p = head;
            while (t++ < left) {
                p = p.next;
            }
            helper(p, right - left);
            return head;
        }
    }

    private ListNode helper(ListNode parent, int count) {
        int c = 1;
        ListNode p = parent.next;
        while (c++ < count) {
            ListNode next = p.next;
            if (next == null) break;
            p.next = next.next;
            next.next = parent.next;
            parent.next = next;
        }
        return parent.next;
    }
}
