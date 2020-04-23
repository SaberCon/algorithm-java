package cn.sabercon.algorithm.q400.q330;

import java.util.Arrays;

/**
 * Create Maximum Number
 * <p>
 * Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two.
 * The relative order of the digits from the same array must be preserved. Return an array of the k digits.
 * <p>
 * Note: You should try to optimize your time and space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * Output:
 * [9, 8, 6, 5, 3]
 * Example 2:
 * <p>
 * Input:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * Output:
 * [6, 7, 6, 0, 4]
 * Example 3:
 * <p>
 * Input:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * Output:
 * [9, 8, 9]
 *
 * @author ywk
 * @date 2020-04-23
 */
public class Q321 {

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = Math.max(0, k - nums2.length); i <= nums1.length && i <= k && k - i <= nums2.length; i++) {
            int[] max = findMax(nums1, i, nums2, k - i);
            if (compare(max, ans)) {
                ans = max;
            }
        }
        return ans;
    }

    private static boolean compare(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] > nums2[i]) {
                return true;
            }
            if (nums1[i] < nums2[i]) {
                return false;
            }
        }
        return false;
    }

    private static int[] findMax(int[] nums1, int count1, int[] nums2, int count2) {
        int[] ans = new int[count1 + count2];
        int[] max1 = findMax(nums1, count1);
        int[] max2 = findMax(nums2, count2);
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < ans.length; i++) {
            if (isBetter(max1, index1, max2, index2)) {
                ans[i] = max1[index1++];
            } else {
                ans[i] = max2[index2++];
            }

        }
        return ans;
    }

    private static boolean isBetter(int[] max1, int index1, int[] max2, int index2) {
        for (int i = index1, j = index2; i < max1.length; i++, j++) {
            if (j == max2.length) {
                return true;
            }
            if (max1[i] > max2[j]) {
                return true;
            }
            if (max1[i] < max2[j]) {
                return false;
            }
        }
        return false;
    }

    private static int[] findMax(int[] nums, int count) {
        int[] ans = new int[count];
        int current = 0;
        while (count != 0) {
            int max = nums[current++];
            for (int i = current; i <= nums.length - count; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    current = i + 1;
                }
            }
            ans[ans.length - count] = max;
            count--;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMax(new int[]{6, 7}, 2, new int[]{6, 0, 4}, 3)));
        System.out.println(compare(new int[]{6, 7, 6, 0, 4}, new int[]{6, 6, 7, 0, 4}));
        System.out.println(Arrays.toString(maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5)));
    }
}
