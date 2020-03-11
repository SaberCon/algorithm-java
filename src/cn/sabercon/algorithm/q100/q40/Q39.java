package cn.sabercon.algorithm.q100.q40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * Example 2:
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * @author ywk
 * @date 2020-03-12
 */
public class Q39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> results = new ArrayList<>();
        combination(results, new Integer[0], target, candidates, 0);
        return results;
    }

    private void combination(List<List<Integer>> results, Integer[] result, int target, int[] candidates, int index) {
        if (candidates.length <= index) {
            return;
        }
        combination(results, result, target, candidates, index + 1);
        while(target > candidates[index]) {
            target -= candidates[index];
            result = Arrays.copyOf(result, result.length + 1);
            result[result.length - 1] = candidates[index];
            combination(results, result, target, candidates, index + 1);
        }
        if (target == candidates[index]) {
            result = Arrays.copyOf(result, result.length + 1);
            result[result.length - 1] = candidates[index];
            results.add(Arrays.asList(result));
        }
    }
}
