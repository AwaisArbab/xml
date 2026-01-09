package Stack;


public class StackUsingArray {
    public int[] data;
    int ptr = -1;

    // Constructor
    public StackUsingArray(int size) {
        this.data = new int[size];
    }

    // Push operation adds an element to the top of the stack
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public boolean push(int value){
        if(isFull()){
            System.out.println("Stack is Full!!");
            return false;
        }
        data[++ptr] = value;
        return true;
    }

    // Pop operation removes the top element
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public int pop() {
        if(isEmpty()){
            return -1;
        }
        return data[ptr--];
    }

    // Peak operation returns top element without removing
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public int peak(){
        if(isEmpty()){
            return -1;
        }
        return data[ptr];
    }

    // Display all elements in the stack
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void display(){
        if(isEmpty()){
            return;
        }
        for(int i = 0; i <= ptr; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public boolean isFull(){
        return ptr == data.length - 1;
    }

    public boolean isEmpty(){
        return ptr == -1;
    }

    // Find minimum element in the stack
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int min() {
        if(isEmpty()) return -1;
        int min = data[0];
        for(int i = 1; i <= ptr; i++){
            if(data[i] < min){
                min = data[i];
            }
        }
        return min;
    }

    // Find maximum element in the stack
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int max() {
        if(isEmpty()) return -1;
        int max = data[0];
        for(int i = 1; i <= ptr; i++){
            if(data[i] > max){
                max = data[i];
            }
        }
        return max;
    }

    // Reverse the stack
    // Time Complexity: O(n)
    // Space Complexity: O(1) -> in-place
    public void reverse() {
        int start = 0;
        int end = ptr;
        while(start < end){
            int temp = data[start];
            data[start] = data[end];
            data[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(5);
        stack.push(10);
        stack.push(20);
        stack.push(5);

        System.out.println("Stack elements:");
        stack.display(); // 10 20 5

        System.out.println("Min: " + stack.min()); // 5
        System.out.println("Max: " + stack.max()); // 20

        stack.reverse();
        System.out.println("Reversed stack:");
        stack.display(); // 5 20 10

        stack.pop();
        System.out.println("After pop:");
        stack.display(); // 5 20
    }
}
