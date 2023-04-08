import org.junit.Test;

import static org.junit.Assert.*;

public class TreeTest {
    public Node createTree() {
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

    @Test
    public void numberOfLeaves() {
        Tree tree = new Tree(createTree());
        assertEquals(tree.numberOfLeaves(), 5);

        Tree treeNull = new Tree(null);
        assertEquals(treeNull.numberOfLeaves(), 0);

        Tree treeOneNode = new Tree(new Node(0, null, null));
        assertEquals(treeOneNode.numberOfLeaves(), 1);

        Node n2 = new Node(0, null, null);
        Node n1 = new Node(0, null, null);
        Node n0 = new Node(0, n1, n2);
        Tree treeTriangle = new Tree(n0);
        assertEquals(treeTriangle.numberOfLeaves(), 2);
    }

    @Test
    public void pathLength() {
        Tree tree = new Tree(createTree());
        assertEquals(tree.pathLength(), 4);

        Tree treeNull = new Tree(null);
        assertEquals(treeNull.pathLength(), 0);

        Tree treeOneNode = new Tree(new Node(0, null, null));
        assertEquals(treeOneNode.pathLength(), 0);

        Node n2 = new Node(0, null, null);
        Node n1 = new Node(0, null, null);
        Node n0 = new Node(0, n1, n2);
        Tree treeTriangle = new Tree(n0);
        assertEquals(treeTriangle.pathLength(), 1);

        Node childNode = new Node(0, null, null);
        Node rootNode = new Node(0, null, childNode);
        Tree treePath = new Tree(rootNode);
        assertEquals(treePath.pathLength(), 1);

        rootNode = new Node(0, childNode, null);
        treePath = new Tree(rootNode);
        assertEquals(treePath.pathLength(), 1);
    }

    @Test
    public void equals() {
        Tree tree = new Tree(createTree());
        Tree treeCopy = new Tree(createTree());
        assertEquals(tree, treeCopy);

        Node n0 = new Node(0, null, null);
        Node n1 = new Node(0, null, null);
        Node n2 = new Node(1, null, null);
        assertEquals(new Tree(n0), new Tree(n0));
        assertEquals(new Tree(n0), new Tree(n1));
        assertNotEquals(new Tree(n0), new Tree(n2));

        n1 = new Node(0, n2, null);
        assertNotEquals(new Tree(n0), new Tree(n1));

        n1 = new Node(0, null, n2);
        assertNotEquals(new Tree(n0), new Tree(n1));

    }
}
