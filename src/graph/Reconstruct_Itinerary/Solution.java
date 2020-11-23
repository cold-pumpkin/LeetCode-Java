package graph.Reconstruct_Itinerary;

import java.util.*;

class Solution {
    // {출발 : [도착, 도착, ...]}
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> result = new LinkedList<>();

    public void dfs(String now) {
        while(graph.containsKey(now) && !graph.get(now).isEmpty()) {
            dfs(graph.get(now).poll());
        }
        result.add(0, now);
    }

    public List<String> findItinerary(List<List<String>> tickets) {

        for(List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (!graph.containsKey(from)) {
                // 사전 순으로 저장
                PriorityQueue<String> priorityQ = new PriorityQueue<>();
                priorityQ.add(to);
                graph.put(from, priorityQ);
            } else {
                graph.get(from).add(to);
            }
        }
        dfs("JFK");
        return result;
    }

    public static void main(String[] args) {

        List<List<String>> tickets = new LinkedList<>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));
        System.out.println(new Solution().findItinerary(tickets));
         //["JFK", "MUC", "LHR", "SFO", "SJC"]
    }
}