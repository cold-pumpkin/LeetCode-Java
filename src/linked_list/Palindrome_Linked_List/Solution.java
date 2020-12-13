package linked_list.Palindrome_Linked_List;

import linked_list.ListNode;

class Solution {
    public boolean isPalindrome(ListNode head) {
        // 중간 값 찾기 slow & fast
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow);
        while (slow != null) {
            if (head.val != slow.val)
                return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    // head 부터 뒤집기 (#206. Reverse Linked List)
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}