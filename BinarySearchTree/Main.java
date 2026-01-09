package BinarySearchTree;

public class Main {
    public static void main(String[] args) {

        BST tree = new BST();

        tree.insertNode(50);
        tree.insertNode(30);
        tree.insertNode(70);
        tree.insertNode(20);
        tree.insertNode(40);
        tree.insertNode(60);
        tree.insertNode(80);

        tree.DFS(); // prints preorder, inorder, postorder

        System.out.println("BFS:");
        tree.bfs();

        System.out.println("\nIs Balanced? " + tree.isBalanced(tree.root));
    }
}
