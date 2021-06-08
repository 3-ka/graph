import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Graph {

    static class Node {
        private Node next;

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private final Node node;

    public Graph(Node node) {
        this.node = Objects.requireNonNull(node);
    }

    public boolean isCyclic() {

        Node current = node;

        List<Node> traversed = new LinkedList<>();

        while (current.next != null) {
            traversed.add(current);

            if (traversed.contains(current.next)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }
}
