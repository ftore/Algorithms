package graphs.dijkstra2;

/**
 * Created by e068529 on 8/20/17.
 */
public class Node implements Comparable<Node> {

    int val, cost;

    public Node(int v, int c) {
        val = v;
        cost = c;
    }

    @Override
    public int compareTo(Node that) {
        return 0;
    }
}
