import java.util.*;

public class Tree {
    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    private int lookSubtree(Node actual) {
        if (!actual.isLeaf()) {
            int subtreeLeaves = 0;
            if (actual.getLeft() != null)
                subtreeLeaves += lookSubtree(actual.getLeft());

            if (actual.getRight() != null)
                subtreeLeaves += lookSubtree(actual.getRight());

            return subtreeLeaves;
        }

        return 1;
    }

    public int numberOfLeaves() {
        if (root == null) return 0;
        return lookSubtree(root);
    }

    public int pathLength() {
        if (root == null) return 0;
        record NodeElement(Node node, int distance) {}

        Queue<NodeElement> queue = new ArrayDeque<>();
        queue.add(new NodeElement(root, 0));
        int theFarthest = 0;

        while (!queue.isEmpty()) {
            NodeElement actual = queue.remove();
            if (actual.node.getLeft() != null) {
                queue.add(new NodeElement(actual.node.getLeft(), actual.distance() + 1));
                theFarthest = Math.max(theFarthest, actual.distance() + 1);
            }

            if (actual.node.getRight() != null) {
                queue.add(new NodeElement(actual.node.getRight(), actual.distance() + 1));
                theFarthest = Math.max(theFarthest, actual.distance() + 1);
            }
        }
        return theFarthest;
    }

    private boolean checkSubtreeEq(Node actual, Node other) {
        if (actual.equals(other)) {
            boolean same = true;
            if (actual.getLeft() != null)
                same = checkSubtreeEq(actual.getLeft(), other.getLeft());

            if(!same) return false;

            if (actual.getRight() != null)
                same = checkSubtreeEq(actual.getRight(), other.getRight());

            return same;
        }
        return false;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Tree other = (Tree) object;

        return checkSubtreeEq(this.root, other.root);

    }
}

