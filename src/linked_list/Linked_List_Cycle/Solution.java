package linked_list.Linked_List_Cycle;

import linked_list.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /* Hash set
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while (head != null) {
            if (nodes.contains(head))
                return true;
            else
                nodes.add(head);
            head = head.next;
        }
        return false;
    } */

    // Two Pointers
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}