package cn.sabercon.algorithm.q100.q40;

import java.util.*;

/**
 * Combination Sum II
 * <p>
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * <p>
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * <p>
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * @author ywk
 * @date 2020-03-12
 */
public class Q40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> results = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int candidate : candidates) {
            if (map.containsKey(candidate)) {
                map.put(candidate, map.get(candidate) + 1);
            } else {
                map.put(candidate, 1);
            }
        }
        combination(results, new Integer[0], target, map);
        return results;
    }

    private void combination(List<List<Integer>> results, Integer[] result, int target, TreeMap<Integer, Integer> map) {
        if (map.isEmpty() || map.firstKey() > target) {
            return;
        }
        Map.Entry<Integer, Integer> entry = map.pollFirstEntry();
        combination(results, result, target, (TreeMap<Integer, Integer>) map.clone());
        for (int i = 1; i <= entry.getValue(); i++) {
            if (target < entry.getKey()) {
                return;
            }
            result = Arrays.copyOf(result, result.length + 1);
            result[result.length - 1] = entry.getKey();
            if (target == entry.getKey()) {
                results.add(Arrays.asList(result));
                return;
            }
            target -= entry.getKey();
            combination(results, result, target, (TreeMap<Integer, Integer>) map.clone());
        }
    }
}
