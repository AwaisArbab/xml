package BinarySearchTree;

import java.util.*;

public class BST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    // ---------------------------------------------------------
    // INSERT NODE
    // Time Complexity:  O(h) → O(log n) best, O(n) worst (skewed)
    // Space Complexity: O(1) (iterative)
    // ---------------------------------------------------------
    public void insertNode(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
            return;
        }

        Node temp = root;

        while (true) {
            if (data < temp.data) {
                if (temp.left == null) {
                    temp.left = newNode;
                    break;
                }
                temp = temp.left;
            } else if (data > temp.data) {
                if (temp.right == null) {
                    temp.right = newNode;
                    break;
                }
                temp = temp.right;
            } else {
                break; // duplicate not inserted
            }
        }
    }

    // ---------------------------------------------------------
    // PREORDER TRAVERSAL (Root-Left-Right)
    // Time Complexity:  O(n)
    // Space Complexity: O(h) → O(n) worst
    // ---------------------------------------------------------
    public void PreOrderTraversal(Node temp) {
        if (temp == null) return;
        System.out.print(temp.data + " ");
        PreOrderTraversal(temp.left);
        PreOrderTraversal(temp.right);
    }

    // ---------------------------------------------------------
    // INORDER TRAVERSAL (Left-Root-Right)
    // Time Complexity:  O(n)
    // Space Complexity: O(h)
    // ---------------------------------------------------------
    public void InOrderTraversal(Node temp) {
        if (temp == null) return;
        InOrderTraversal(temp.left);
        System.out.print(temp.data + " ");
        InOrderTraversal(temp.right);
    }

    // ---------------------------------------------------------
    // POSTORDER TRAVERSAL (Left-Right-Root)
    // Time Complexity:  O(n)
    // Space Complexity: O(h)
    // ---------------------------------------------------------
    public void PostOrderTraversal(Node temp) {
        if (temp == null) return;
        PostOrderTraversal(temp.left);
        PostOrderTraversal(temp.right);
        System.out.print(temp.data + " ");
    }

    // ---------------------------------------------------------
    // DFS() — Calls Pre, In & Post Order
    // Time Complexity:  O(n)
    // Space Complexity: O(h)
    // ---------------------------------------------------------
    public void DFS() {
        System.out.print("PreOrder: ");
        PreOrderTraversal(root);
        System.out.println();

        System.out.print("InOrder: ");
        InOrderTraversal(root);
        System.out.println();

        System.out.print("PostOrder: ");
        PostOrderTraversal(root);
        System.out.println();
    }

    // ---------------------------------------------------------
    // BFS (Level Order Traversal)
    // Time Complexity:  O(n)
    // Space Complexity: O(n)
    // ---------------------------------------------------------
    public void bfs() {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node current = q.poll();
            System.out.print(current.data + " ");

            if (current.left != null) q.add(current.left);
            if (current.right != null) q.add(current.right);
        }
    }

    // ---------------------------------------------------------
    // FIND MAX (Rightmost Node)
    // Time Complexity:  O(h)
    // Space Complexity: O(1)
    // ---------------------------------------------------------
    public Node findMax(Node temp) {
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }

    // ---------------------------------------------------------
    // DELETE NODE
    // Time Complexity:  O(h) → O(log n) best, O(n) worst
    // Space Complexity: O(h) (recursive stack)
    // ---------------------------------------------------------
    public Node deleteNode(Node temp, int data) {
        if (temp == null) return null;

        if (data < temp.data) {
            temp.left = deleteNode(temp.left, data);
        } else if (data > temp.data) {
            temp.right = deleteNode(temp.right, data);
        } else {

            // Case 1: Leaf node
            if (temp.left == null && temp.right == null) return null;

            // Case 2: One child
            if (temp.left == null) return temp.right;
            if (temp.right == null) return temp.left;

            // Case 3: Two children (Use inorder predecessor)
            Node maxLeft = findMax(temp.left);
            temp.data = maxLeft.data;
            temp.left = deleteNode(temp.left, maxLeft.data);
        }

        return temp;
    }

    // ---------------------------------------------------------
    // HEIGHT OF TREE
    // Time Complexity:  O(n)
    // Space Complexity: O(h)
    // ---------------------------------------------------------
    public int height(Node temp) {
        if (temp == null) return 0;
        return Math.max(height(temp.left), height(temp.right)) + 1;
    }

    // ---------------------------------------------------------
    // CHECK IF TREE IS BALANCED (Height Balanced)
    // Time Complexity:  O(n²)  (height() called at every node)
    // Space Complexity: O(h)
    // ---------------------------------------------------------
    public boolean isBalanced(Node temp) {
        if (temp == null) return true;

        int leftH = height(temp.left);
        int rightH = height(temp.right);

        if (Math.abs(leftH - rightH) > 1) return false;

        return isBalanced(temp.left) && isBalanced(temp.right);
    }
}
