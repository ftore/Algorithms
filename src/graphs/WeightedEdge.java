package graphs;

/**
 * Created by e068529 on 8/10/17.
 */
public class WeightedEdge {
    final int from, to;
    Double weight;

    public WeightedEdge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int from() {
        return from;
    }

    public int to() {
        return to;
    }

    public double weight() {
        return weight;
    }
}
