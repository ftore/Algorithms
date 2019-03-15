package algorithms;

import java.util.*;

public class ReconstructItinerary {
    public static List<String> findItinerary(String[][] tickets) {
        Map<String, List<String>> adjList = new HashMap<>();

        for(int i = 0; i < tickets.length; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];

            if(adjList.containsKey(from)) {
                adjList.get(from).add(to);
            } else {
                List<String> toList = new ArrayList<>();
                toList.add(to);
                adjList.put(from, toList);
            }
        }

        Stack<String> toExplore = new Stack<>();
        toExplore.push("JFK");



        List<String> result = new ArrayList<>();

        while(!toExplore.isEmpty()) {
            String curr = toExplore.pop();
            result.add(curr);

            List<String> toList = adjList.get(curr);

            if(toList == null || toList.size() == 0) break;

            toExplore.push(toList.get(0));
            toList.remove(0);
        }

        return result;
    }

    public static void main(String[] args) {
        String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};

        List<String> itinerary = findItinerary(tickets);

        for(String i : itinerary) {
            System.out.println(i);
        }
    }
}
