class DLL{
    class Node {
        int data;
        Node next, prev;
        Node(int d) { data = d; }
    }

    Node head, tail;

    // Insert at beginning
    void insertAtStart(int val) {
        Node n = new Node(val);
        if(head == null) {
            head = tail = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
        }
    }
    // Insert at end
    void insertAtEnd(int val) {
        Node n = new Node(val);
        if(head == null) {
            head = tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
    }
    // Forward display
    void displayForward() {
        Node t = head;
        while(t != null) {
            System.out.print(t.data + " ");
            t = t.next;
        }
        System.out.println();
    }

    // Backward display
    void displayBackward() {
        Node t = tail;
        while(t != null) {
            System.out.print(t.data + " ");
            t = t.prev;
        }
        System.out.println();
    }

    // Delete first node
    void deleteFirst() {
        if(head == null) return;
        if(head == tail) head = tail = null;
        else {
            head = head.next;
            head.prev = null;
        }
    }

    // Delete last node
    void deleteLast() {
        if(tail == null) return;
        if(head == tail) head = tail = null;
        else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Delete by value
    void deleteByValue(int val) {
        Node t = head;
        while(t != null && t.data != val) t = t.next;
        if(t == null) return;
        if(t == head) deleteFirst();
        else if(t == tail) deleteLast();
        else {
            t.prev.next = t.next;
            t.next.prev = t.prev;
        }
    }

    // Delete node before value
    void deleteBeforeValue(int val) {
        Node t = head;
        while(t != null && t.data != val) t = t.next;
        if(t == null || t.prev == null) return;
        Node del = t.prev;
        if(del == head) deleteFirst();
        else {
            del.prev.next = t;
            t.prev = del.prev;
        }
    }

    // Delete node after value
    void deleteAfterValue(int val) {
        Node t = head;
        while(t != null && t.data != val) t = t.next;
        if(t == null || t.next == null) return;
        Node del = t.next;
        if(del == tail) deleteLast();
        else {
            t.next = del.next;
            del.next.prev = t;
        }
    }

    // Find min & max
    void findMinMax() {
        if(head == null) return;
        int min = head.data, max = head.data;
        Node t = head.next;
        while(t != null) {
            min = Math.min(min, t.data);
            max = Math.max(max, t.data);
            t = t.next;
        }
        System.out.println("Min = " + min + "  Max = " + max);
    }
}
public class DoublyLinkedList {
    public static void main(String[] args) {
        DLL dll = new DLL();

        dll.insertAtStart(10);
        dll.insertAtStart(20);

        dll.insertAtEnd(30);
        dll.insertAtEnd(40);
        dll.insertAtEnd(5);
        dll.insertAtEnd(50);

        System.out.print("Forward: ");
        dll.displayForward();
        System.out.print("Backward: ");
        dll.displayBackward();

        dll.deleteFirst();
        dll.deleteLast();
        dll.deleteByValue(20);
        dll.deleteBeforeValue(30);
        dll.deleteAfterValue(20);

        dll.findMinMax();

        System.out.println("\nTime Complexity:");
        System.out.println("Insert at Start/End: O(1)");
        System.out.println("Delete First/Last: O(1)");
        System.out.println("Delete by Value: O(n)");
        System.out.println("Find Min/Max: O(n)");
    }
}
