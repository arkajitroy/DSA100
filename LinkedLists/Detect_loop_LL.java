class Node {
    int val;
    Node next;

    Node(int x) {
        val = x;
        next = null;
    }
}

class Main {
    // Brute Force
    public static boolean hasCycle(Node head){
        if(head == null) return false;
        Node current = head;

        while (current != null) {
            Node checker = current.next;
            while (checker != null) {
                if(current == checker) return true; // if cycle found   
                checker = checker.next;
            }
            current = current.next;
        }
        return false;
    }

    public static boolean hasCycle_Tortoise_Hare(Node head){
        if(head == null || head.next == null) return false;

        Node slow = head, fast = head.next;

        while (slow != fast) {
            // if fast reaches null then there is no cycle
            if(fast == null || fast.next == null) return false;

            // move slow by 1 step & move fast by 2-step
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(0);
        head.next.next.next = new Node(-4);

        // Creating a cycle for demonstration purposes
        head.next.next.next.next = head.next;

        System.out.println(hasCycle(head));
    }    
}
