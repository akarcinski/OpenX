public class Node {
    private int value;
    private Node right;
    private Node left;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.right = right;
        this.left = left;
    }

    public int getValue() {
        return value;
    }

    public Node getRight() {
        return right;
    }

    public Node getLeft() {
        return left;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public boolean isLeaf() {
        return (right == null && left == null);
    }

    private boolean childrenEquals(Node other) {
        boolean eq;
        if (left == null && other.left == null) eq = true;
        else eq = (left == null) == (other.left == null);

        if(!eq) return false;

        if (right == null && other.right == null) eq = true;
        else eq = (right == null) == (other.right == null);

        return eq;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Node other = (Node) object;

        return this.value == other.value && childrenEquals(other);
    }
}
