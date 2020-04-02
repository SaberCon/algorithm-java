package cn.sabercon.algorithm.q300.q210;

import java.util.*;

/**
 * Course Schedule II
 * <p>
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * <p>
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 * <p>
 * Example 1:
 * <p>
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 *              course 0. So the correct course order is [0,1] .
 * Example 2:
 * <p>
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 * courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 *              So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 * Note:
 * <p>
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 *
 * @author ywk
 * @date 2020-04-02
 */
public class Q210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ints = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            ints[prerequisite[0]]++;
            if (map.containsKey(prerequisite[1])) {
                map.get(prerequisite[1]).add(prerequisite[0]);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(prerequisite[0]);
                map.put(prerequisite[1], list);
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 0) {
                queue.push(i);
            }
        }
        int[] ans = new int[numCourses];
        int length = 0;
        while (!queue.isEmpty()) {
            Integer index = queue.poll();
            ans[length++] = index;
            if (map.containsKey(index)) {
                map.get(index).forEach(i -> {
                    ints[i]--;
                    if (ints[i] == 0) {
                        queue.push(i);
                    }
                });
            }
        }
        if (length != numCourses) {
            return new int[0];
        } else {
            return ans;
        }
    }
}
