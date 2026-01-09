package xml.assignment.fouth_question;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(new Book("T_2", "Thousand Splendid Suns", "Khaled Hoseini", 2022));
        stack.push(new Book("E_2", "Splendid Suns", "Khaled Hoseini", 2022));
        stack.display();
        stack.update("T_2", "Hundred Splendid suns");
        stack.display();
        stack.pop();
        stack.display();

        //undo
        stack.pop();
        stack.display();

    }
}
