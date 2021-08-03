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

public class Tree_Check_If_BST {
    Node prev = null;
    boolean checkBST(Node root) {
        if (root != null) {
            if (!checkBST(root.left)) {
                return false;
            }
            if (prev != null && root.data <= prev.data) {
                return false;
            }
            prev = root;
            return checkBST(root.right);
        }
        return true;
    }
}