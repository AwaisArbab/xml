package BinarySearchTree;

public class Main {
    public static void main(String[] args) {

    BST binarytree=new BST();
    binarytree.insertNode(5);
    binarytree.insertNode(6);
    binarytree.insertNode(4);
    binarytree.insertNode(1);
    binarytree.insertNode(14);
    binarytree.insertNode(12);
    binarytree.insertNode(19);


    System.out.println("Pre Order");
    binarytree.PreOrderTraversal(binarytree.root);
    System.out.println();
    System.out.println("In Order");
    binarytree.InOrderTraversal(binarytree.root);
    System.out.println();
    System.out.println("Post Order");
    binarytree.PostOrderTraversal(binarytree.root);
    System.out.println();
    binarytree.bfs();


    }
}