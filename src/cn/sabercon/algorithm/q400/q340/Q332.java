package cn.sabercon.algorithm.q400.q340;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Reconstruct Itinerary
 * <p>
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order.
 * All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 * <p>
 * Note:
 * <p>
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * Example 1:
 * <p>
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * Example 2:
 * <p>
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 *              But it is larger in lexical order.
 *
 * @author ywk
 * @date 2020-04-26
 */
public class Q332 {

    private LinkedList<String> ans;

    public List<String> findItinerary(List<List<String>> tickets) {
        ans = new LinkedList<>();
        int count = tickets.size();
        Map<String, TreeMap<String, Integer>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            map.putIfAbsent(ticket.get(0), new TreeMap<>());
            map.get(ticket.get(0)).merge(ticket.get(1), 1, Integer::sum);
        }
        ans.add("JFK");
        dfs(map, count, "JFK");
        return ans;
    }

    private boolean dfs(Map<String, TreeMap<String, Integer>> map, int count, String from) {
        if (!map.containsKey(from)) {
            return count == 0;
        }
        TreeMap<String, Integer> destinations = map.get(from);
        for (Map.Entry<String, Integer> entry : destinations.entrySet()) {
            String k = entry.getKey();
            Integer v = entry.getValue();
            if (v > 0) {
                ans.addLast(k);
                destinations.put(k, v - 1);
                if (dfs(map, count - 1, k)) {
                    return true;
                }
                destinations.put(k, v);
                ans.removeLast();
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        String ticketsStr = "\"AXA\",\"EZE\"],[\"EZE\",\"AUA\"],[\"ADL\",\"JFK\"],[\"ADL\",\"TIA\"],[\"AUA\",\"AXA\"],[\"EZE\",\"TIA\"],[\"EZE\",\"TIA\"],[\"AXA\",\"EZE\"],[\"EZE\",\"ADL\"],[\"ANU\",\"EZE\"],[\"TIA\",\"EZE\"],[\"JFK\",\"ADL\"],[\"AUA\",\"JFK\"],[\"JFK\",\"EZE\"],[\"EZE\",\"ANU\"],[\"ADL\",\"AUA\"],[\"ANU\",\"AXA\"],[\"AXA\",\"ADL\"],[\"AUA\",\"JFK\"],[\"EZE\",\"ADL\"],[\"ANU\",\"TIA\"],[\"AUA\",\"JFK\"],[\"TIA\",\"JFK\"],[\"EZE\",\"AUA\"],[\"AXA\",\"EZE\"],[\"AUA\",\"ANU\"],[\"ADL\",\"AXA\"],[\"EZE\",\"ADL\"],[\"AUA\",\"ANU\"],[\"AXA\",\"EZE\"],[\"TIA\",\"AUA\"],[\"AXA\",\"EZE\"],[\"AUA\",\"SYD\"],[\"ADL\",\"JFK\"],[\"EZE\",\"AUA\"],[\"ADL\",\"ANU\"],[\"AUA\",\"TIA\"],[\"ADL\",\"EZE\"],[\"TIA\",\"JFK\"],[\"AXA\",\"ANU\"],[\"JFK\",\"AXA\"],[\"JFK\",\"ADL\"],[\"ADL\",\"EZE\"],[\"AXA\",\"TIA\"],[\"JFK\",\"AUA\"],[\"ADL\",\"EZE\"],[\"JFK\",\"ADL\"],[\"ADL\",\"AXA\"],[\"TIA\",\"AUA\"],[\"AXA\",\"JFK\"],[\"ADL\",\"AUA\"],[\"TIA\",\"JFK\"],[\"JFK\",\"ADL\"],[\"JFK\",\"ADL\"],[\"ANU\",\"AXA\"],[\"TIA\",\"AXA\"],[\"EZE\",\"JFK\"],[\"EZE\",\"AXA\"],[\"ADL\",\"TIA\"],[\"JFK\",\"AUA\"],[\"TIA\",\"EZE\"],[\"EZE\",\"ADL\"],[\"JFK\",\"ANU\"],[\"TIA\",\"AUA\"],[\"EZE\",\"ADL\"],[\"ADL\",\"JFK\"],[\"ANU\",\"AXA\"],[\"AUA\",\"AXA\"],[\"ANU\",\"EZE\"],[\"ADL\",\"AXA\"],[\"ANU\",\"AXA\"],[\"TIA\",\"ADL\"],[\"JFK\",\"ADL\"],[\"JFK\",\"TIA\"],[\"AUA\",\"ADL\"],[\"AUA\",\"TIA\"],[\"TIA\",\"JFK\"],[\"EZE\",\"JFK\"],[\"AUA\",\"ADL\"],[\"ADL\",\"AUA\"],[\"EZE\",\"ANU\"],[\"ADL\",\"ANU\"],[\"AUA\",\"AXA\"],[\"AXA\",\"TIA\"],[\"AXA\",\"TIA\"],[\"ADL\",\"AXA\"],[\"EZE\",\"AXA\"],[\"AXA\",\"JFK\"],[\"JFK\",\"AUA\"],[\"ANU\",\"ADL\"],[\"AXA\",\"TIA\"],[\"ANU\",\"AUA\"],[\"JFK\",\"EZE\"],[\"AXA\",\"ADL\"],[\"TIA\",\"EZE\"],[\"JFK\",\"AXA\"],[\"AXA\",\"ADL\"],[\"EZE\",\"AUA\"],[\"AXA\",\"ANU\"],[\"ADL\",\"EZE\"],[\"AUA\",\"EZE\"";
        List<List<String>> tickets = Arrays.stream(ticketsStr.split("],\\[")).map(s -> Arrays.stream(s.split(",")).map(str -> str.substring(1, str.length() - 1)).collect(Collectors.toList())).collect(Collectors.toList());
        Q332 q332 = new Q332();
        System.out.println(q332.findItinerary(tickets));
    }
}
