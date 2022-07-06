package graph;

import java.util.*;

public class ReconstructFlightItinerary {
    HashMap<String, List<String>> graph = new HashMap<>();
    HashMap<String, boolean[]> visited = new HashMap<>();
    int flights = 0;
    List<String> result = null;

    //TC -> O(E^d) -> E = total flights , d = max no of flight from airport 
    public List<String> findItinerary(List<List<String>> tickets) {

        //construct a graph (adj List) of src -> sorted[list of dest]
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dest = ticket.get(1);

            if (graph.containsKey(src)) {
                List<String> neighbors = graph.get(src);
                neighbors.add(dest);
            } else {
                List<String> neighbors = new LinkedList<>();
                neighbors.add(dest);
                graph.put(src, neighbors);
            }
        }

        //initialise the boolean array with -> no of Dest possible from this Src
        // sort the Dest -> bcoz result is needed in Lexo order

        for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
            Collections.sort(entry.getValue());
            visited.put(entry.getKey(), new boolean[entry.getValue().size()]);
        }

        this.flights = tickets.size();
        LinkedList<String> route = new LinkedList<String>();
        route.add("JFK");

        backtrack("JFK", route);
        return result;
    }

    private boolean backtrack(String origin, LinkedList<String> route) {
        if (route.size() == flights + 1) {
            this.result = (List<String>) route.clone();
            return true;
        }
        if (!this.graph.containsKey(origin))
            return false;

        boolean[] visitedFromGivenOrigin = this.visited.get(origin);
        int i = 0;

        for (String dest : graph.get(origin)) {
            if (!visitedFromGivenOrigin[i]) {
                visitedFromGivenOrigin[i] = true;
                route.addLast(dest);
                boolean ret = backtrack(dest, route);

                route.pollLast();
                visitedFromGivenOrigin[i] = false;

                if (ret) return true;
            }
            i++;
        }
        return false;
    }

}

