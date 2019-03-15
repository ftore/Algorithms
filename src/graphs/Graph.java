package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by e068529 on 8/8/17.
 */
public class Graph {
    private final Integer V;
    private Integer E;
    private Map<Integer, List<Integer>> adjList;

    public Graph(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Invalid argument.");
        }

        V = size;
        E = 0;
        adjList = new HashMap<>();

        for(int i = 0; i < V; i++) {
            adjList.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int i, int j) {
        adjList.get(i).add(j);
        adjList.get(j).add(i);
        E++;
    }

    public List<Integer> getAdjList(int i) {
        return adjList.get(i);
    }

    public int degree(int i) {
        return adjList.get(i).size();
    }
}
