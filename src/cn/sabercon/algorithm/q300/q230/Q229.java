package cn.sabercon.algorithm.q300.q230;

import java.util.ArrayList;
import java.util.List;

/**
 * Majority Element II
 * <p>
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * <p>
 * Note: The algorithm should run in linear time and in O(1) space.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: [3]
 * Example 2:
 * <p>
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 *
 * @author ywk
 * @date 2020-04-09
 */
public class Q229 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>(2);
        if (nums.length == 0) {
            return ans;
        }
        int candidate1 = nums[0];
        int candidate2 = nums[0];
        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
            // 投票
            if (candidate1 == num) {
                count1++;
                continue;
            }
            if (candidate2 == num) {
                count2++;
                continue;
            }

            // 第1个候选人配对
            if (count1 == 0) {
                candidate1 = num;
                count1++;
                continue;
            }
            // 第2个候选人配对
            if (count2 == 0) {
                candidate2 = num;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            }
            if (num == candidate2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            ans.add(candidate1);
        }
        if (candidate1 != candidate2 && count2 > nums.length / 3) {
            ans.add(candidate2);
        }
        return ans;
    }
}
