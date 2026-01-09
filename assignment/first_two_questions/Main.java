package xml.assignment.first_two_questions;

public class Main {

    public static Book initializeBook(String book_id , String title , String author , int year){
        return new Book(book_id , title , author , year);
    }

    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        ll.insertLast(initializeBook("T_2", "Thousand Splendid Suns", "Khaled Hoseini", 2022));
        ll.insertLast(initializeBook("K_2", "Kite Runner", "Khaled", 2082));
        ll.insertLast(initializeBook("R_2", "Runner", "Dronker", 2082));
        ll.insertLast(initializeBook("D_2", "David Goggins", "David", 2082));
//        ll.insertLast(initializeBook("N_2", "nnn", "Vkand", 2082));
//        ll.display();

        ll.sortBySelectionSort();
        ll.display();
        System.out.println();
//        ll.sort();
//        ll.display();
//        ll.searchById("V_8");
//        ll.searchByIdByBinary("D_2");
    }
}
