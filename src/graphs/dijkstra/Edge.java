package graphs.dijkstra;

/**
 * Created by e068529 on 8/9/17.
 */
public class Edge {
    Node node1, node2;
    double weight;

    public Edge(Node node1, Node node2, double weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }
}
