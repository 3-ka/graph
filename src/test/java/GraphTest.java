import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GraphTest {

    private Graph.Node first;
    private Graph.Node second;
    private Graph.Node third;
    private Graph.Node fourth;

    @Before
    public void initNodes() {
        first = new Graph.Node();
        second = new Graph.Node();
        third = new Graph.Node();
        fourth = new Graph.Node();
    }

    @Test
    public void testCyclicLastToFirst() {
        first.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(first);

        Graph graph = new Graph(first);
        Assert.assertTrue(graph.isCyclic());
    }

    @Test
    public void testCycleLastToNonFirst() {

        first.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(second);

        Graph graph = new Graph(first);
        Assert.assertTrue(graph.isCyclic());
    }

    @Test
    public void testCyclicLastNode() {
        first.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(fourth);

        Graph graph = new Graph(first);
        Assert.assertTrue(graph.isCyclic());
    }

    @Test
    public void testCyclicSingleNode() {
        first.setNext(first);

        Graph graph = new Graph(first);
        Assert.assertTrue(graph.isCyclic());
    }

    @Test
    public void testNotCyclic() {
        first.setNext(second);
        second.setNext(third);
        third.setNext(fourth);

        Graph graph = new Graph(first);
        Assert.assertFalse(graph.isCyclic());
    }

    @Test
    public void testNotCyclicSingleNode() {
        Graph graph = new Graph(first);
        Assert.assertFalse(graph.isCyclic());
    }

}