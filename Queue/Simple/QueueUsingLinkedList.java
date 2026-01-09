package Queue.Simple;


public class QueueUsingLinkedList {
    Node front = null;
    Node rear = null;

    // Node class for linked list
    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Enqueue operation - add element at rear
    // Time Complexity: O(1)
    // Space Complexity: O(1) per new node
    public void enqueue(int data) {
        Node nn = new Node(data);
        if(front == null){
            front = nn;
            rear = nn;
        } else {
            rear.next = nn;
            rear = nn;
        }
    }

    // Dequeue operation - remove element from front
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public int dequeue() {
        if(front == null){
            System.out.println("Queue is Empty!!");
            return -1;
        }
        int value = front.data;
        front = front.next;
        if(front == null) rear = null;
        return value;
    }

    // Print queue elements
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void print() {
        if(front == null) return;
        Node temp = front;
        while(temp != null){
            System.out.print(temp.data + " <- ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    // Find minimum element
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int min() {
        if(front == null) return -1;
        int min = front.data;
        Node temp = front.next;
        while(temp != null){
            if(temp.data < min) min = temp.data;
            temp = temp.next;
        }
        return min;
    }

    // Find maximum element
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int max() {
        if(front == null) return -1;
        int max = front.data;
        Node temp = front.next;
        while(temp != null){
            if(temp.data > max) max = temp.data;
            temp = temp.next;
        }
        return max;
    }

    // Reverse the queue
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void reverse() {
        Node prev = null;
        Node current = front;
        Node next;
        rear = front; // original front becomes rear after reverse
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        front = prev;
    }

    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(5);
        queue.enqueue(30);

        System.out.println("Queue elements:");
        queue.print(); // 10 <- 20 <- 5 <- 30 <- End

        System.out.println("Min: " + queue.min()); // 5
        System.out.println("Max: " + queue.max()); // 30

        queue.reverse();
        System.out.println("Reversed Queue:");
        queue.print(); // 30 <- 5 <- 20 <- 10 <- End

        queue.dequeue();
        System.out.println("After dequeue:");
        queue.print(); // 5 <- 20 <- 10 <- End
    }
}

