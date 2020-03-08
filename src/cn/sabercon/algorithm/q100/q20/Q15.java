package cn.sabercon.algorithm.q100.q20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3Sum
 * <p>
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author ywk
 * @date 2020-03-08
 */
public class Q15 {

    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> resultList = new ArrayList<>();
        if (nums.length < 3) {
            return resultList;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int begin = i + 1;
            int end = nums.length - 1;
            while (begin < end) {
                if (nums[begin] + nums[end] > -nums[i]) {
                    end--;
                } else if (nums[begin] + nums[end] < -nums[i]) {
                    begin++;
                } else {
                    if (!(begin > i + 1 && nums[begin] == nums[begin - 1] && end < nums.length - 1 && nums[end] == nums[end + 1])) {
                        resultList.add(Arrays.asList(nums[i], nums[begin], nums[end]));
                    }
                    begin++;
                    end--;
                }
            }
        }
        return resultList;
    }
}
