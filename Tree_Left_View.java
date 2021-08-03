import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class Tree {
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<Node> q = new LinkedList<>();

        q.offerLast(root);
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Node temp = q.pollFirst();
                if (i == 0) {
                    list.add(temp.data);
                }
                if (temp.left != null) {
                    q.offerLast(temp.left);
                }
                if (temp.right != null) {
                    q.offerLast(temp.right);
                }
            }
        }

        return list;
    }
}