class QueueLinkedList {

    class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }

    Node front, rear;

    void enqueue(int val) {
        Node n = new Node(val);
        if (rear == null) {
            front = rear = n;
        } else {
            rear.next = n;
            rear = n;
        }
    }
    int dequeue() {
        if (front == null) return -1;
        int val = front.data;
        front = front.next;
        if (front == null) rear = null;
        return val;
    }
    int peek() {
        if (front == null) return -1;
        return front.data;
    }

    void findMinMax() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return;
        }
        Node temp = front;
        int min = temp.data, max = temp.data;
        while (temp != null) {
            if (temp.data < min) min = temp.data;
            if (temp.data > max) max = temp.data;
            temp = temp.next;
        }
        System.out.println("Min = " + min + "  Max = " + max);
    }

    void display() {
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class QueueUsingLinkedList {
    public static void main(String[] args) {
        QueueLinkedList q = new QueueLinkedList();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(5);
        q.enqueue(40);

        System.out.print("Queue: ");
        q.display();

        System.out.println("Peek: " + q.peek());

        System.out.println("Dequeue: " + q.dequeue());

        System.out.print("Queue after dequeue: ");
        q.display();

        q.findMinMax();
    }
}
