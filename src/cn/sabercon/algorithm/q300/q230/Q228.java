package cn.sabercon.algorithm.q300.q230;

import java.util.ArrayList;
import java.util.List;

/**
 * Summary Ranges
 * <p>
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * <p>
 * Example 1:
 * <p>
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * Example 2:
 * <p>
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 *
 * @author ywk
 * @date 2020-04-09
 */
public class Q228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        String range = "";
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                ans.add(range + nums[i]);
                range = "";
            } else {
                if (range.length() == 0) {
                    range = nums[i] + "->";
                }
            }
        }
        ans.add(range + nums[nums.length - 1]);
        return ans;
    }
}
