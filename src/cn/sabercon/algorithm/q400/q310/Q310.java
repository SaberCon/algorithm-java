package cn.sabercon.algorithm.q400.q310;

import java.util.*;

/**
 * Minimum Height Trees
 * <p>
 * For an undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree.
 * Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph,
 * write a function to find all the MHTs and return a list of their root labels.
 * <p>
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 * <p>
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * <p>
 * Example 1 :
 * <p>
 * Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 * <p>
 * 0
 * |
 * 1
 * / \
 * 2   3
 * <p>
 * Output: [1]
 * Example 2 :
 * <p>
 * Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * <p>
 * 0  1  2
 * \ | /
 * 3
 * |
 * 4
 * |
 * 5
 * <p>
 * Output: [3, 4]
 * Note:
 * <p>
 * According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path.
 * In other words, any connected graph without simple cycles is a tree.”
 * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 *
 * @author ywk
 * @date 2020-04-20
 */
public class Q310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 0) {
            return Collections.emptyList();
        }
        if (n == 1) {
            return Collections.singletonList(0);
        }
        Map<Integer, List<Integer>> map = new HashMap<>(n);
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        List<Integer> ans = new LinkedList<>();
        int[] degree = new int[n];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Integer k = entry.getKey();
            List<Integer> v = entry.getValue();
            if (v.size() == 1) {
                ans.add(k);
            } else {
                degree[k] = v.size();
            }
        }
        while (true) {
            List<Integer> nextAns = new LinkedList<>();
            for (Integer num : ans) {
                for (Integer connectedNum : map.get(num)) {
                    degree[connectedNum]--;
                    if (degree[connectedNum] == 1) {
                        nextAns.add(connectedNum);
                    }
                }
            }
            if (nextAns.isEmpty()) {
                return ans;
            }
            ans = nextAns;
        }
    }
}
