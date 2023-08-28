import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


class Solution {
    public static ListNode middle_TwoPointer(ListNode head){
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow =slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Not Recommended approach - O(n)
    public static ListNode middle_Counter(ListNode head){
        int count = 0;
        ListNode current = head;

        while(current != null){
            count++;
            current = current.next;
        }
        current = head;
        for(int i=0; i < count/2; i++){
            current = current.next;
        }
        return current;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode middle_TwoPointer = middle_TwoPointer(head);
        ListNode middle_Counter = middle_Counter(head);

        System.out.println("Middle of Linked List (Two Pointer ) => "+ middle_TwoPointer.val);
        System.out.println("Middle of Linked List (Counter) => "+ middle_TwoPointer.val);
    }
}