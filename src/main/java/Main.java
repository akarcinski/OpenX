public class Main {

    public static Node createTree() {
        Node n9 = new Node(5, null, null);
        Node n8 = new Node(8, null, n9);
        Node n7 = new Node(2, null, null);
        Node n6 = new Node(0, n7, n8);
        Node n5 = new Node(1, null, null);
        Node n4 = new Node(5, null, null);
        Node n3 = new Node(2, null, null);
        Node n2 = new Node(7, n5, n6);
        Node n1 = new Node(3, n3, n4);
        Node n0 = new Node(5, n1, n2);

        return n0;
    }

    public static void main(String[] args) {
        Node root = createTree();
        Node copy = createTree();
        Node changed = createTree();
        changed.getRight().getRight().getLeft().setRight(new Node(2, null, null));

        Tree tree = new Tree(root);
        Tree copyTree = new Tree(copy);
        Tree changedTree = new Tree(changed);

        // example of using Tree class methods
        int leaves = tree.numberOfLeaves();
        System.out.println("Number of leaves: " + leaves);

        boolean same = tree.equals(copyTree);
        System.out.println("Comparing 2 equal trees: " + same);

        boolean different = tree.equals(changedTree);
        System.out.println("Comparing 2 different trees: " + different);

        int size = tree.pathLength();
        System.out.println("Largest number of edges: " + size);
    }
}
