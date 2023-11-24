import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution{

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the linked list
        ListNode middle = findMiddle(head);

        // Step 2: Reverse the second half of the linked list
        ListNode reversedSecondHalf = reverseList(middle.next);
        middle.next = null; // Break the original list into two parts

        // Step 3: Merge the first and reversed second halves
        mergeLists(head, reversedSecondHalf);
    }

    // Helper function to find the middle of the linked list
    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Helper function to reverse a linked list
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    // Helper function to merge two linked lists
    private static void mergeLists(ListNode list1, ListNode list2) {
        while (list1 != null && list2 != null) {
            ListNode next1 = list1.next;
            ListNode next2 = list2.next;

            list1.next = list2;
            list2.next = next1;

            list1 = next1;
            list2 = next2;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Call the reorderList function
        reorderList(head);

        // Print the modified linked list
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}