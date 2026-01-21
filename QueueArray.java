import java.util.Arrays;

public class QueueArray {
    private int[] arr;
    private int front, rear, size;

    public QueueArray(int capacity) {
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int val) {
        if (size == arr.length) { // resize
            System.out.println("Resizing array from " + arr.length + " to " + (arr.length * 2));
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        rear = (rear + 1) % arr.length;
        arr[rear] = val;
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int val = arr[front];
        front = (front + 1) % arr.length;
        size--;
        return val;
    }

    public int peek() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return arr[front];
    }

    public void display() {
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++)
            System.out.print(arr[(front + i) % arr.length] + " ");
        System.out.println();
    }

    public void findMinMax() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return;
        }
        int min = arr[front], max = arr[front];
        for (int i = 1; i < size; i++) {
            int val = arr[(front + i) % arr.length];
            if (val < min) min = val;
            if (val > max) max = val;
        }
        System.out.println("Min = " + min + ", Max = " + max);
    }

    public static void main(String[] args) {
        QueueArray q = new QueueArray(3);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();

        q.enqueue(40);
        q.display();

        System.out.println("Peek: " + q.peek());
        System.out.println("Dequeued: " + q.dequeue());
        q.display();

        q.findMinMax();
    }
}
