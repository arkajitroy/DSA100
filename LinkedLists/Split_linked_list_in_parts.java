class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution {

    public static ListNode[] splitListToParts(ListNode head, int k) {
        
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // Calculate the size of each part and the remainder.
        int partSize = length / k;
        int remainder = length % k;

        // Initialize the result array.
        ListNode[] result = new ListNode[k];

        // Reset the current pointer to the head of the linked list.
        current = head;

        // Traverse the linked list to split it into parts.
        for (int i = 0; i < k; i++) {
            result[i] = current; // Set the head of the current part.

            // Calculate the size of the current part.
            int currentPartSize = partSize + (i < remainder ? 1 : 0);

            // Traverse to the end of the current part.
            for (int j = 1; j < currentPartSize && current != null; j++) {
                current = current.next;
            }

            // Mark the end of the current part.
            if (current != null) {
                ListNode next = current.next;
                current.next = null;
                current = next;
            }
        }

        return result;
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 3;

        // LinkedList => 1 -> 2 -> 3 -> 4 -> 5

        ListNode[] result = splitListToParts(head, k);

        // Print the results.
        for (ListNode partHead : result) {
            printList(partHead);
        }
    }
}
