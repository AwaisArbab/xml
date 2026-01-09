package Stack;

public class StackUsingLinkedList {
    Node head = null;

    // Node class for linked list
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Push operation adds an element to the top of the stack
    // Time Complexity: O(1)
    // Space Complexity: O(1) per new node
    public void push(int value){
        Node nn = new Node(value);
        nn.next = head;
        head = nn;
    }

    // Pop operation removes the element from the top of the stack
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public int pop(){
        if(head == null){
            return -1; // stack is empty
        }
        int removed = head.data;
        head = head.next;
        return removed;
    }

    // Print all elements of the stack
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void print(){
        if(head == null) return;
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

    // Find minimum element in the stack
    // Time Complexity: O(n) -> need to check all nodes
    // Space Complexity: O(1)
    public int min() {
        if(head == null) return -1; // stack empty
        int min = head.data;
        Node temp = head.next;
        while(temp != null){
            if(temp.data < min){
                min = temp.data;
            }
            temp = temp.next;
        }
        return min;
    }

    // Find maximum element in the stack
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int max() {
        if(head == null) return -1; // stack empty
        int max = head.data;
        Node temp = head.next;
        while(temp != null){
            if(temp.data > max){
                max = temp.data;
            }
            temp = temp.next;
        }
        return max;
    }

    // Reverse the stack
    // Time Complexity: O(n)
    // Space Complexity: O(1) -> in-place reversal
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(10);
        stack.push(20);
        stack.push(5);

        System.out.println("Stack elements:");
        stack.print(); // 5 20 10

        System.out.println("Min: " + stack.min()); // 5
        System.out.println("Max: " + stack.max()); // 20

        stack.reverse();
        System.out.println("Reversed stack:");
        stack.print(); // 10 20 5

        stack.pop();
        System.out.println("After pop:");
        stack.print(); // 20 5
    }
}
