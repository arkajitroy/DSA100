import java.util.Stack;

class Q {
    Stack<Integer> temp;
    Stack<Integer> value;

    public Q() {
        temp = new Stack<>();
        value = new Stack<>();
    }

    public void enqueue(int data) {
        temp.push(data);
    }

    public int dequeue() {
        if (value.isEmpty()) {
            transferElements();
        }
        return value.pop();
    }

    public int peek() {
        if (value.isEmpty()) {
            transferElements();
        }
        return value.peek(); // Check the value stack for peek
    }

    public boolean empty() {
        return temp.isEmpty() && value.isEmpty();
    }

    private void transferElements() {
        while (!temp.isEmpty()) {
            value.push(temp.pop());
        }
    }
}

class Main {
    public static void main(String[] args) {
        Q queue = new Q();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Dequeue: " + queue.dequeue()); // Dequeue: 1
        System.out.println("Peek: " + queue.peek()); // Peek: 2
        System.out.println("Is empty: " + queue.empty()); // Is empty: false
    }
}
