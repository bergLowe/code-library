import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Tree_Level_Order_Traversal {

    public static void levelOrder(Node root) {
        Deque<Node> q = new LinkedList<>();
        Node temp = root;

        while (temp != null) {
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                q.offerLast(temp.left);
            }
            if (temp.right != null) {
                q.offerLast(temp.right);
            }
            temp = q.pollFirst();
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }
}