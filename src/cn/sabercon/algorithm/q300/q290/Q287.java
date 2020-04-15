package cn.sabercon.algorithm.q300.q290;

/**
 * Find the Duplicate Number
 *
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example 1:
 *
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 *
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n^2).
 * There is only one duplicate number in the array, but it could be repeated more than once
 *
 * @author ywk
 * @date 2020-04-15
 */
public class Q287 {

    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            hare = nums[nums[hare]];
            tortoise = nums[tortoise];
        } while (hare != tortoise);
        int pointer1 = nums[0];
        int pointer2 = hare;
        while (pointer1 !=pointer2) {
            pointer1 = nums[pointer1];
            pointer2 = nums[pointer2];
        }
        return pointer1;
    }
}
