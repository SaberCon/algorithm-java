package cn.sabercon.algorithm.q300.q210;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Course Schedule
 * <p>
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses? 
 * <p>
 * Example 1:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible. 
 * <p>
 * Constraints:
 * <p>
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 * 1 <= numCourses <= 10^5
 *
 * @author ywk
 * @date 2020-04-01
 */
public class Q207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            if (map.containsKey(prerequisite[0])) {
                map.get(prerequisite[0]).add(prerequisite[1]);
            } else {
                HashSet<Integer> set = new HashSet<>();
                set.add(prerequisite[1]);
                map.put(prerequisite[0], set);
            }
        }
        boolean flag = true;
        while (flag) {
            flag = false;
            for (Set<Integer> set : map.values()) {
                if (set.removeIf(num -> !map.containsKey(num) || map.get(num).isEmpty())) {
                    flag = true;
                }
            }
        }
        return map.values().stream().allMatch(Set::isEmpty);
    }
}
