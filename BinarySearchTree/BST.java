package  BinarySearchTree;
import java.util.*;

public class BST {

    static class Node{
        int data;
        Node left;
        Node right;


    Node(int data){

     this.data=data;
     this.left=null;
     this.right=null;

    }}


    Node root;

    public void insertNode(int data){
        Node newNode = new Node(data);

        if(root==null)
        {
            root=newNode;
            return;
        }

        Node temp=root;
        while(true) {
            if (newNode.data < temp.data) {
                if (temp.left == null) {
                    temp.left = newNode;
                    break;
                }
                temp = temp.left;
            } else if (newNode.data > temp.data) {
                if (temp.right == null) {
                    temp.right = newNode;
                    break;
                }
                temp = temp.right;
            }}}

    public void PreOrderTraversal(Node temp){

        if(temp==null){
            return;
        }

        System.out.print(temp.data+" ");
        PreOrderTraversal(temp.left);
        PreOrderTraversal(temp.right);
    }

    public void bfs() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public void InOrderTraversal(Node temp){

        if(temp==null){
            return;
        }

        InOrderTraversal(temp.left);
        System.out.print(temp.data+" ");
        InOrderTraversal(temp.right);
    }

    public void PostOrderTraversal(Node temp){

        if(temp==null){
            return;
        }

        PostOrderTraversal(temp.left);
        PostOrderTraversal(temp.right);
        System.out.print(temp.data+" ");
    }

    public Node findMax(Node temp) {
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }

    public Node deleteNode(Node temp, int data) {

        if(temp==null)
        {
            return null;
        }
        if(data<temp.data){
            temp.left=deleteNode(temp.left, data);
        }

        else if(data>temp.data){
            temp.right=deleteNode(temp.right, data);
        }

        else {

            if (temp.left == null && temp.right == null) {
                return null;
            } else if (temp.left == null) {
                return temp.right;
            } else if (temp.right == null) {
                return temp.left;
            }

            Node MaxPredecessor = findMax(temp.left);
            temp.data = MaxPredecessor.data;
            temp.left = deleteNode(temp.left, MaxPredecessor.data);
        }
        return temp;
        }

    }


