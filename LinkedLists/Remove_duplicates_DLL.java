
// Remove all the duplicates from the Doubly LL

import java.util.HashSet;

class Node {
    public int data;
    public Node prev;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class Main {
    // TC: O(n^2)
    public static Node removeDuplicatesDLL(Node head){
        if(head == null || head.next == null) return head;

        Node curr = head;

        while (curr != null) {
            Node checker = curr.next;
            while (checker != null) {
                if(curr.data == checker.data){
                    checker.prev.next = checker.next;
                    if(checker.next != null){
                        checker.next.prev = checker.prev;
                    }
                }
                checker = checker.next;
            }
            curr = curr.next;
        }
        return head;
    }

    // TC: O(n)
    public static Node removeDuplicatesDLL_Hashset(Node head){
        if(head == null || head.next == null) return head;

        HashSet<Integer> unique = new HashSet<>();
        Node current = head;

        while (current != null) {
            // if the set does not contains data then insert it
            if(!unique.contains(current.data)){
                unique.add(current.data);
                current = current.next;
            }else{
                // if the dup-element is found then remove and change the prev & next pointers
                current.prev.next = current.next;
                if(current.next != null) current.next.prev = current.prev;
                current = current.next;
            }
        }
        return head;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(2);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.prev = head.next.next.next;

        System.out.println("Original Doubly Linked List:");
        printList(head);

        // Call the uniqueSortedList function
        head = removeDuplicatesDLL(head);

        System.out.println("Doubly Linked List after removing duplicates:");
        printList(head);
    }
}
