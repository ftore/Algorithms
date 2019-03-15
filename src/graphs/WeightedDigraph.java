package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by e068529 on 8/8/17.
 */
public class WeightedDigraph {
    private Integer V;
    private Integer E;
    Double minDistance = Double.POSITIVE_INFINITY;

    private Map<Integer, List<WeightedEdge>> adjList;

    public WeightedDigraph(int size) {
        if(size < 0) {
            throw new IllegalArgumentException("Illegal argument.");
        }

        V = size;
        E = 0;
        adjList = new HashMap<>();
        for(int i = 0; i < V; i++) {
            adjList.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int i, int j, double weight) {
        WeightedEdge we = new WeightedEdge(i, j, weight);
        adjList.get(i).add(we);
        E++;
    }

    public List<WeightedEdge> getAdjList(int i) {
        return adjList.get(i);
    }

    public int vertices() {
        return V;
    }
}
