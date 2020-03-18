package cn.sabercon.algorithm.q100.q90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 * Subsets II
 * <p>
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * Input: [1,2,2]
 * Output:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 *
 * @author ywk
 * @date 2020-03-18
 */
public class Q90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        BitSet set = new BitSet(nums.length);
        return subsets(set, nums, 0);
    }

    private List<List<Integer>> subsets(BitSet set, int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.get(i)) {
                    list.add(nums[i]);
                }
            }
            return Arrays.asList(list);
        }
        int nextIndex = index + 1;
        while (nextIndex < nums.length && nums[nextIndex] == nums[index]) {
            nextIndex++;
        }
        List<List<Integer>> result = new ArrayList<>(subsets(set, nums, nextIndex));
        for (int i = index; i < nextIndex; i++) {
            set.set(i);
            result.addAll(subsets(set, nums, nextIndex));
        }
        for (int i = index; i < nextIndex; i++) {
            set.set(i, false);
        }
        return result;
    }
}
