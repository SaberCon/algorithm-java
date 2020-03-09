package cn.sabercon.algorithm.q100.q20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4Sum
 * <p>
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * The solution set must not contain duplicate quadruplets.
 * <p>
 * Example:
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 *
 * @author ywk
 * @date 2020-03-09
 */
public class Q18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 4) {
            return resultList;
        }
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if ((j > i + 1 && nums[j] == nums[j - 1]) || 2 * (nums[i] + nums[j]) > target) {
                    continue;
                }
                int begin = j + 1;
                int end = nums.length - 1;
                while (begin < end) {
                    if (nums[begin] + nums[end] + nums[i] + nums[j] > target) {
                        end--;
                    } else if (nums[begin] + nums[end] + nums[i] + nums[j] < target) {
                        begin++;
                    } else {
                        if (!(begin > j + 1 && nums[begin] == nums[begin - 1] && end < nums.length - 1 && nums[end] == nums[end + 1])) {
                            resultList.add(Arrays.asList(nums[i], nums[j], nums[begin], nums[end]));
                        }
                        begin++;
                        end--;
                    }
                }
            }
        }
        return resultList;
    }
}
