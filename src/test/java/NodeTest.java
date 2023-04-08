import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
    @Test
    public void equals() {
        Node node1 = new Node(0, null, null);
        Node node1Copy = new Node(0, null, null);

        Node node2 = new Node(1, null, null);
        Node node3 = new Node(0, node2, null);
        Node node4 = new Node(0, null, node2);
        Node node5 = new Node(0, node2, node3);

        assertEquals(node1, node1Copy);
        assertNotEquals(node1, node2);
        assertNotEquals(node1, node3);
        assertNotEquals(node1, node4);
        assertNotEquals(node1, node5);

        assertEquals(node1, node1);
        assertNotEquals(node1, null);
    }
}
