package cn.sabercon.algorithm.q400.q320;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Count of Smaller Numbers After Self
 * <p>
 * You are given an integer array nums and you have to return a new counts array.
 * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * <p>
 * Example:
 * <p>
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 *
 * @author ywk
 * @date 2020-04-22
 */
public class Q315 {

    public List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> ans = new LinkedList<>();
        List<Integer> sortedList = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int pos = findPos(nums[i], sortedList, 0, sortedList.size() - 1);
            sortedList.add(pos, nums[i]);
            ans.addFirst(pos);
        }
        return ans;
    }

    private int findPos(int num, List<Integer> sortedList, int start, int end) {
        if (start > end) {
            return start;
        }
        int middle = start + (end - start) / 2;
        Integer n = sortedList.get(middle);
        if (n < num) {
            return findPos(num, sortedList, middle + 1, end);
        } else {
            return findPos(num, sortedList, start, middle - 1);
        }
    }

    public static void main(String[] args) {
        Q315 q315 = new Q315();
        System.out.println(q315.countSmaller(new int[]{5, 2, 6, 1}));
    }
}
