package cn.sabercon.algorithm.q100.q80;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * Subsets
 * <p>
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * @author ywk
 * @date 2020-03-18
 */
public class Q78 {

    public List<List<Integer>> subsets(int[] nums) {
        BitSet set = new BitSet(nums.length);
        return backtracking(set, nums, 0);
    }

    private List<List<Integer>> backtracking(BitSet set, int[] nums, int index) {
        List<List<Integer>> result = new ArrayList<>();
        if (index == nums.length) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.get(i)) {
                    list.add(nums[i]);
                }
            }
            result.add(list);
            return result;
        }
        set.set(index);
        result.addAll(backtracking(set, nums, index + 1));
        set.set(index, false);
        result.addAll(backtracking(set, nums, index + 1));
        return result;
    }
}
