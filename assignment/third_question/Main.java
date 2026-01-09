package xml.assignment.third_question;


public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(20);
        queue.enqueue("Vivek");
        queue.enqueue("Anand");
        queue.display();
        queue.dequeue();
        queue.display();
    }
}
