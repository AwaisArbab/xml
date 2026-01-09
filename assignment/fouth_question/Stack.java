package xml.assignment.fouth_question;

public class Stack {
    private Book[] arr;
    private int top = 0;

    Stack(int size){
        arr = new Book[size];
    }

    public void push(Book data){
        if(isFull()){
            System.out.println("Stack Overflow");
            return;
        }
        arr[top++] = data;
    }

    public String pop(){
        if(isEmpty()) {
            System.out.println("Stack underflow");
            return null;
        }
        return arr[--top].getTitle();
    }

    public void update(String id, String newTitle){
        for(int i = top - 1; i >= 0; i--){
            if(arr[i].getBook_id().equals(id)){
                arr[i].setTitle(newTitle);
                break;
            }
        }
    }

    public void display(){
        System.out.print("BOOKS:-  ");
        for(int i = top - 1; i >= 0; i--){
            System.out.print(arr[i].getTitle() + " , ");
        }
        System.out.println();
    }

    private boolean isFull(){
        return top == arr.length ;
    }

    private boolean isEmpty(){
        return top == 0;
    }



}
