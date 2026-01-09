package Queue.Circular;

public class QueueUsingArray {
    int front = -1;
    int rear = -1;
    int[] arr;

    QueueUsingArray(int size){
        arr = new int[size];
    }

    // Insert element into circular queue
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public void insert(int data){
        if(isFull()){
            System.out.println("Queue is full!");
            return;
        }
        if(front == -1) front = 0;
        rear = (rear + 1) % arr.length;
        arr[rear] = data;
    }

    // Remove element from circular queue
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public int remove(){
        if(isEmpty()){
            return -1;
        }

        int removed = arr[front];
        if(front == rear){
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % arr.length;
        }
        return removed;
    }

    // Print queue elements
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void print() {
        if (isEmpty()) return;

        int i = front;
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear) break;
            i = (i + 1) % arr.length;
        }
        System.out.println();
    }

    public boolean isFull(){
        return (rear + 1) % arr.length == front;
    }

    public boolean isEmpty(){
        return front == -1 && rear == -1;
    }

    // Find minimum element in queue
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int min() {
        if(isEmpty()) return -1;
        int min = arr[front];
        int i = front;
        while(true){
            if(arr[i] < min){
                min = arr[i];
            }
            if(i == rear) break;
            i = (i + 1) % arr.length;
        }
        return min;
    }

    // Find maximum element in queue
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int max() {
        if(isEmpty()) return -1;
        int max = arr[front];
        int i = front;
        while(true){
            if(arr[i] > max){
                max = arr[i];
            }
            if(i == rear) break;
            i = (i + 1) % arr.length;
        }
        return max;
    }

    // Reverse the queue elements
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void reverse() {
        if(isEmpty()) return;

        int size = (rear >= front) ? (rear - front + 1) : (arr.length - front + rear + 1);
        for(int i = 0; i < size / 2; i++){
            int idx1 = (front + i) % arr.length;
            int idx2 = (front + size - 1 - i) % arr.length;
            int temp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = temp;
        }
    }

    public static void main(String[] args) {
        QueueUsingArray cq = new QueueUsingArray(5);
        cq.insert(5);
        cq.insert(3);
        cq.insert(7);
        cq.insert(1);
        cq.print(); // 5 3 7 1

        System.out.println("Min: " + cq.min()); // 1
        System.out.println("Max: " + cq.max()); // 7

        cq.reverse();
        System.out.println("Reversed queue:");
        cq.print(); // 1 7 3 5

        cq.remove();
        System.out.println("After remove:");
        cq.print(); // 7 3 5
    }
}
