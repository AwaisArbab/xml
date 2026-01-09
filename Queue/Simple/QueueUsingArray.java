package Queue.Simple;

public class QueueUsingArray {
    int[] data;
    int end = 0;

    // Constructor
    public QueueUsingArray(int size) {
        this.data = new int[size];
    }

    // Insert element at the end of the queue
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public boolean insert(int value){
        if(isFull()){
            System.out.println("Queue is Full!!");
            return false;
        }
        data[end++] = value;
        return true;
    }

    // Remove element from front
    // Time Complexity: O(n) -> shift all elements left
    // Space Complexity: O(1)
    public int remove() {
        if(isEmpty()){
            System.out.println("Queue is Empty!!");
            return -1;
        }
        int removedItem = data[0];
        for(int i = 0 ; i < end -1; i++){
            data[i] = data[i+1]; // shifting elements
        }
        end--;
        return removedItem;
    }

    // Get front element without removing
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public int front() {
        if(isEmpty()){
            System.out.println("Queue is Empty!!");
            return -1;
        }
        return data[0];
    }

    // Print all queue elements
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void display(){
        for(int i = 0 ; i < end; i++){
            System.out.print(data[i] + " <- ");
        }
        System.out.println("End");
    }

    public boolean isFull(){
        return end == data.length;
    }

    public boolean isEmpty(){
        return end == 0;
    }

    // Find minimum element
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int min() {
        if(isEmpty()) return -1;
        int min = data[0];
        for(int i = 1; i < end; i++){
            if(data[i] < min){
                min = data[i];
            }
        }
        return min;
    }

    // Find maximum element
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int max() {
        if(isEmpty()) return -1;
        int max = data[0];
        for(int i = 1; i < end; i++){
            if(data[i] > max){
                max = data[i];
            }
        }
        return max;
    }

    // Reverse the queue
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void reverse() {
        int start = 0;
        int last = end - 1;
        while(start < last){
            int temp = data[start];
            data[start] = data[last];
            data[last] = temp;
            start++;
            last--;
        }
    }

    public static void main(String[] args) {
       QueueUsingArray queue = new QueueUsingArray(5);
        queue.insert(10);
        queue.insert(20);
        queue.insert(5);
        queue.insert(30);

        System.out.println("Queue elements:");
        queue.display(); // 10 <- 20 <- 5 <- 30 <- End

        System.out.println("Min: " + queue.min()); // 5
        System.out.println("Max: " + queue.max()); // 30

        queue.reverse();
        System.out.println("Reversed Queue:");
        queue.display(); // 30 <- 5 <- 20 <- 10 <- End

        queue.remove();
        System.out.println("After remove:");
        queue.display(); // 5 <- 20 <- 10 <- End
    }
}
