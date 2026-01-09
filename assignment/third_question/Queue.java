package xml.assignment.third_question;

public class Queue {
    String[] arr;
    int front = -1;
    int rear = -1;

    Queue(int length){
        arr = new String[length];
    }

    public void enqueue(String data){
        if(isFull()){
            System.out.println("Queue Overflow");
            return;
        }
        if(isEmpty()){
            front = 0;
        }
        rear = (rear+1) % arr.length;
        arr[rear] = data;
    }

    public String dequeue(){
        if(isEmpty()){
            System.out.println("Queue Underflow");
            return "";
        }

        String data =  arr[front];
        if(front == rear){
            front = rear = -1;
        }else{
            front = (front+1) % arr.length;
        }
        return data;
    }


    public void display(){
        if(isEmpty()) {
            System.out.println("Queue Empty");
            return;
        }

        for(int i = front; i <= rear; i = (i+1) % arr.length ){
            System.out.println(arr[i]);
        }

    }


    private boolean isFull(){
        return (rear + 1) % arr.length == front;
    }
    private boolean isEmpty(){
        return front == -1 && rear == -1;
    }



}
