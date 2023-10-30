import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public static ListNode detectCycle(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;
        ListNode meetingPoint = null;

        // Phase 1: Detect a meeting point
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            if (tortoise == hare) {
                meetingPoint = tortoise;
                break;
            }
        }

        // If no meeting point, there's no cycle
        if (meetingPoint == null) {
            return null;
        }

        // Phase 2: Find the entrance to the cycle
        tortoise = head;
        while (tortoise != hare) {
            tortoise = tortoise.next;
            hare = hare.next;
        }

        return tortoise; // This is the starting node of the cycle
    }

    public static void main(String[] args) {
        // Create a sample linked list with a cycle
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode nodeM4 = new ListNode(-4);

        head.next = node2;
        node2.next = node0;
        node0.next = nodeM4;
        nodeM4.next = node2; // Cycle: 2 -> 0 -> -4 -> 2

        ListNode cycleStart = detectCycle(head);

        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle found in the linked list.");
        }
    }
}