package linked_list.Intersection_of_Two_Linked_Lists;

import linked_list.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        while (pointerA != pointerB) {
            pointerA = (pointerA != null) ? pointerA.next : headB;
            pointerB = (pointerB != null) ? pointerB.next : headA;
        }
        return pointerA;
    }
}