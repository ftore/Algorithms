package graphs.dijkstra2;

import java.util.*;

/**
 * Created by e068529 on 8/20/17.
 */
public class Dijsktra {
    public static List<Node> search(int start, int end, List<List<Node>> adj, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node curr = pq.remove();
            int currN = curr.val;

            Iterator<Node> it = adj.get(currN).iterator();
            while(it.hasNext()) {
                Node temp = it.next();

                if(dist[temp.val] > dist[currN] + temp.cost) {
                    pq.add(new Node(temp.val, dist[currN] + temp.cost));
                    dist[temp.val] = dist[currN] + temp.cost;
                }
            }
        }

        List<Node> path = new ArrayList<>();
        for(int i = 0; i < dist.length; i++) {
            //dist[i] == Integer.MAX_VALUE ? path.add(-1) ;
            if(i == end) {
                break;
            }
        }

        return path;
    }


}
