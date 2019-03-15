package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by e068529 on 8/8/17.
 */
public class Digraph {
    private final Integer V;
    private Integer E;
    private Map<Integer, List<Integer>> adjList;

    public Digraph(int size) {
        if(size < 0) {
            throw new IllegalArgumentException("Illegal arguments");
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
        E++;
    }

    public List<Integer> getAdjList(int i) {
        return adjList.get(i);
    }

}
