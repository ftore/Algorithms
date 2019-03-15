package graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by e068529 on 8/8/17.
 */
public class GraphSearch {
    public boolean DFS(int start, int goal, Digraph G) {
        Stack<Integer> toExplore = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        toExplore.push(start);
        visited.add(start);

        while (!toExplore.isEmpty()) {
            int curr = toExplore.pop();

            if(curr == goal) return true;

            List<Integer> neighbors = G.getAdjList(curr);
            for(Integer i : neighbors) {
                if(!visited.contains(i)) {
                    visited.add(i);
                    toExplore.push(i);
                }
            }
        }

        return false;
    }

    public boolean BFS(int start, int goal, Digraph G) {
        Queue<Integer> toExplore = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        toExplore.add(start);
        visited.add(start);

        while(!toExplore.isEmpty()) {
            int curr = toExplore.remove();

            if(curr == goal) return true;

            List<Integer> neighbors = G.getAdjList(curr);
            for(Integer i : neighbors) {
                if(!visited.contains(i)) {
                    visited.add(i);
                    toExplore.add(i);
                }
            }
        }

        return false;
    }

//    public Iterable<WeightedEdge> dijkstraSP(int start, int goal, WeightedDigraph G) {
//        PriorityQueue<WeightedEdge> toExplore = new PriorityQueue<>(new Comparator<WeightedEdge>() {
//            @Override
//            public int compare(WeightedEdge o1, WeightedEdge o2) {
//                return o1.weight.compareTo(o2.weight);
//            }
//        });
//        Set<Integer> visited = new HashSet<>();
//        Map<WeightedEdge, WeightedEdge> parent = new HashMap<>();
//        List<WeightedEdge> path = new ArrayList<>();
//
//        visited.add(start);
//
//        // start's distance from itself is 0,
//        // so create 0 wighted edge
//        toExplore.add(new WeightedEdge(start, 0));
//        path.add(new WeightedEdge(start, 0));
//        double totalPath = Double.POSITIVE_INFINITY;
//
//        while(!toExplore.isEmpty()) {
//            WeightedEdge curr = toExplore.poll();
//
//            if(curr.V == goal) {
//                //return constructPath(start, goal, parent);
//            }
//
//            List<WeightedEdge> neighbors = G.getAdjList(curr.V);
//
//            for (WeightedEdge i : neighbors) {
//                if(!visited.contains(i.V)) {
//                    double currDistance =
//                    double sumDistance = totalPath + i.weight;
//
//                    //if(sumDistance )
//                    visited.add(i.V);
//                    toExplore.add(i);
//                    path.add(i);
//
//                }
//            }
//        }
//
//        return path;
//    }

    public Iterable<WeightedEdge> dijkstraSP(int start, int goal, WeightedDigraph G) {
        double[] distances = new double[G.vertices()];
        WeightedEdge[] edges = new WeightedEdge[G.vertices()];

        PriorityQueue<WeightedEdge> toExplore = new PriorityQueue<>(new Comparator<WeightedEdge>() {
            @Override
            public int compare(WeightedEdge o1, WeightedEdge o2) {
                return o1.weight.compareTo(o2.weight);
            }
        });

        // set distances to positive infinity
        for(int i = 0; i < G.vertices(); i++) {
            distances[i] = Double.POSITIVE_INFINITY;
        }
        distances[start] = 0.0;

        toExplore.add(new WeightedEdge(start, start, distances[start]));

        while(!toExplore.isEmpty()) {
            WeightedEdge curr = toExplore.poll();

            List<WeightedEdge> neighbors = G.getAdjList(curr.from);
            for(WeightedEdge weightedEdge : neighbors) {

                // relax the edge and update PQ
                int from = weightedEdge.from;
                int to = weightedEdge.to;
                if(distances[to] > distances[from] + weightedEdge.weight) {
                    distances[to] = distances[from] + weightedEdge.weight;
                    edges[to] = weightedEdge;
                    if(toExplore.contains(weightedEdge)) {
                        WeightedEdge e = toExplore.poll();
                        e.weight = distances[to];
                        toExplore.add(e);
                    } else {
                        toExplore.add(weightedEdge);
                    }
                }
            }
        }

        Stack<WeightedEdge> path = new Stack<>();
//        for(WeightedEdge e = edges[start]; e != null; e = edges[e.from]) {
//            path.push(e);
//        }

        for(int i = start; i <= goal; i++) {
            if(edges[i] != null)
                path.push(edges[i]);
        }
        return path;
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new File("tinyEWD.txt"));
            int V = in.nextInt();
            int E = in.nextInt();
            WeightedDigraph weightedDigraph = new WeightedDigraph(V);

            for(int i = 0; i < E; i++) {
                int v = in.nextInt();
                int w = in.nextInt();
                int weight = in.nextInt();
                weightedDigraph.addEdge(v, w, weight);
            }

            GraphSearch graphSearch = new GraphSearch();
            Iterable<WeightedEdge> path = graphSearch.dijkstraSP(0, 6, weightedDigraph);
            for(WeightedEdge i : path) {
                if(i.weight < Double.POSITIVE_INFINITY)
                    System.out.print(i.from + " -> " + i.to);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
