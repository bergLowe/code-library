import java.util.Deque;
import java.util.LinkedList;

class QNode {
    public TreeNode node;
    public int depth;

    public QNode (TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Deque<QNode> q = new LinkedList<>();
        QNode qNode = new QNode(root, 1);

        q.offer(qNode);

        while (q.size() != 0) {
            qNode = q.poll();

            System.out.println(qNode.node.val + " " + qNode.depth);

            TreeNode tempNode = qNode.node;
            int depth = qNode.depth;

            if (tempNode.left == null && tempNode.right == null) {
                return depth;
            }

            if (tempNode.left != null) {
                qNode = new QNode(tempNode.left, depth + 1);
                q.offer(qNode);
            }

            if (tempNode.right != null) {
                qNode = new QNode(tempNode.right, depth + 1);
                q.offer(qNode);
            }
        }

        return 0;
    }
}