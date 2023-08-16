package LinkedLists;

class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
        this.next = null;
    }
}

public class Rotate_List {
    public static Node brute(Node head, int k){
        if(head == null || head.next == null || k == 0) return head;

        int length = 1;
        Node curr = head;

        while (curr.next!= null){
            curr = curr.next;
            length++;
        }

        k = k % length; // effective no of rotations

        for(int i=0; i<k; i++){
            curr = head;
            while(curr.next.next != null){
                curr = curr.next;
            }
            Node newHead = curr.next;
            curr.next = null;
            newHead.next = head;
            head = newHead;
        }
        return head;
    }

    public static void printList(Node head){
        while(head != null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }
    public static void main(String[] args) {
        // base linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int k = 2;
        System.out.println("Base List");
        printList(head);
        Node newList =brute(head, k);
        System.out.println("\nBrute Force Approach");
        printList(newList);
    }
}
