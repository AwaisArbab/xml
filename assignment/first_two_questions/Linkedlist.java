package xml.assignment.first_two_questions;

//circular linkedlist

class Linkedlist {
    private Node head;
    private Node tail = null;

    public void insertLast(Book book){
        Node nn = new Node(book);
        if(head == null){
            head = nn;
            tail = nn;
            return;
        }
        tail.next = nn;
        nn.prev = tail;
        tail = nn;
    }

    private int totalLength(Node start ,Node end){
        int l = 1;
        Node temp = start;
        while(temp != end){
            l++;
            temp = temp.next;
        }
        return l;
    }

    private Node findMiddle(Node start , Node end){
        int length = totalLength(start , end);
        int track = 0;
        int mid = length / 2 ;
        while(track < mid){
            start = start.next;
            track++;
        }
        return start;
    }

    //Question 1:- Sort the list
    public void sort(){
        //checking if list is empty
        if(head == null){
            System.out.println("List Empty");
            return;
        }

        // sorting using insertion sort
        //Explanation
            // Initialize curr as head.next;
            //iterate over the curr till curr != null
                //Inside the loop
                //Iterate with the condition of if prev node's id is bigger and if prev == null
                // if prev node's id is bigger swap the values and move curr behind to keep checking prev values
            //move curr ahead curr = curr.next;

        //temp variable to iterate over ll
        Node curr = head.next;

        // loop will run till last element
        while(curr != null) {
            // will keep running if prev node's id is lesser than the curr, then the condition will be met
            while(curr.prev != null && curr.data.getBook_id().compareTo(curr.prev.data.getBook_id()) < 0) {

                    //swap the data
                Book tempData = curr.data;
                curr.data = curr.prev.data;
                curr.prev.data = tempData;
                // moving curr behind
                curr = curr.prev;

            }
            //moving curr ahead
            curr = curr.next;
        }

    }

    public void sortBySelectionSort(){
        int length = totalLength(head , tail);
        Node tempTail = tail;
        while(length > 0){
        Node tempHead = head;
        Node max = head;
        int track = 0;

        while(track < length - 1){
            if(tempHead.next.data.getBook_id().compareTo(max.data.getBook_id()) > 0){
                max = tempHead.next;
            }
            tempHead = tempHead.next;
            track++;
        }

        if(max == tempTail){
            if(tempTail != head){
                tempTail = tempTail.prev;
            }
            length--;
            continue;
        }

        max.next.prev = max.prev;

        if(max != head){
            max.prev.next = max.next;
        }else{
            head = head.next;
        }

        if(tempTail.next != null){
            tempTail.next.prev = max;
        }
        max.next = tempTail.next;
        max.prev = tempTail;
        tempTail.next = max;
//            System.out.println(length);

        length--;
        }
//        System.out.println(tempTail.data.getTitle());
        while(tempTail.next != null){
            tempTail = tempTail.next;
        }
        tail = tempTail;

    }

    public void searchById(String id){
        //checking if list is empty
        if(head == null){
            System.out.println("List Empty");
            return;
        }
        //using linear search

        Node temp = head;
        int track = 0;
        while(temp != null){
            if(temp.data.getBook_id().equals(id)){
                System.out.println("BOOK FOUND at index:- " + track);
                System.out.println("TITLE:- " + temp.data.getTitle());
                return;
            }
            track++;
            temp = temp.next;
        }
        System.out.println("BOOK NOT FOUND!!");

    }

    public void searchByIdByBinary(String id){
        //checking if list is empty
        if(head == null){
            return;
        }
        //using Binary search

        Node start = head;
        Node end = tail;

        int length = totalLength(start , end);

        int index = length / 2 ; // index of middle node

        while(start != null && end != null){
            // middle node of the list
            Node mid = findMiddle(start , end);
            //if middle equals id
            if(mid.data.getBook_id().equals(id)){
                System.out.println("BOOK FOUND " + mid.data.getTitle());
                System.out.println("INDEX is " + index);
                return;
            }
            // if mid is lesser than given id
            if(mid.data.getBook_id().compareTo(id) < 0){
                start = mid.next;
                index+=1;
            }else{
                end = mid.prev;
                index-=1;
                end.next = null;
            }
        }
        System.out.println("Book not found!!");

    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.println("ID:- " + temp.data.getBook_id() + " TITLE:- " + temp.data.getTitle());
            temp = temp.next;
        }
    }

    private class Node{
        Book data;
        Node next = null;
        Node prev = null;
        Node(Book data){
            this.data = data;
        }
    }
}
