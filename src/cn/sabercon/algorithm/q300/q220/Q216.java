package cn.sabercon.algorithm.q300.q220;

import java.util.ArrayList;
import java.util.List;

/**
 * Combination Sum III
 * <p>
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * <p>
 * Note:
 * <p>
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 * <p>
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * @author ywk
 * @date 2020-04-05
 */
public class Q216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(ans, k, n, 1, new ArrayList<>(k));
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, int k, int n, int min, List<Integer> nums) {
        if (k > n || 9 * k < n) {
            return;
        }
        if (k == 0) {
            ans.add(new ArrayList<>(nums));
        }
        for (int i = min; i < 10; i++) {
            nums.add(i);
            backtracking(ans, k - 1, n - i, i + 1, nums);
            nums.remove(nums.size() - 1);
        }
    }
}
