package cn.sabercon.algorithm.q100.q10;

/**
 * Median of Two Sorted Arrays
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * <p>
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 *
 * @author ywk
 * @date 2020-03-08
 */
public class Q4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result;
        int length = nums1.length + nums2.length;
        int min1 = 0;
        int max1 = nums1.length - 1;
        int min2 = 0;
        int max2 = nums2.length - 1;
        if ((length) % 2 == 0) {
            result = findIndexTwoAverageFromSortedArrays(nums1, nums2, min1, max1, min2, max2, length / 2 - 1);
        } else {
            result = findIndexValueFromSortedArrays(nums1, nums2, min1, max1, min2, max2, length / 2);
        }
        return result;
    }

    private double findIndexTwoAverageFromSortedArrays(int[] nums1, int[] nums2, int min1, int max1, int min2, int max2, int index) {
        if (min1 > max1 || max1 < 0) {
            return (nums2[min2 + index] + nums2[min2 + index + 1]) / 2.0;
        }
        if (min2 > max2 || max2 < 0) {
            return (nums1[min1 + index] + nums1[min1 + index + 1]) / 2.0;
        }
        if (index == 0) {
            if (nums1[min1] >= nums2[min2]) {
                if (min2 < max2) {
                    return (Math.min(nums1[min1], nums2[min2 + 1]) + nums2[min2]) / 2.0;
                } else {
                    return (nums1[min1] + nums2[min2]) / 2.0;
                }
            } else {
                if (min1 < max1) {
                    return (Math.min(nums2[min2], nums1[min1 + 1]) + nums1[min1]) / 2.0;
                } else {
                    return (nums2[min2] + nums1[min1]) / 2.0;
                }
            }
        }
        int compare1 = Math.min(max1, min1 + (index - 1) / 2);
        int compare2 = Math.min(max2, min2 + (index - 1) / 2);
        if (nums1[compare1] >= nums2[compare2]) {
            index -= (compare2 - min2 + 1);
            min2 = compare2 + 1;
        } else {
            index -= (compare1 - min1 + 1);
            min1 = compare1 + 1;
        }
        return findIndexTwoAverageFromSortedArrays(nums1, nums2, min1, max1, min2, max2, index);
    }

    private double findIndexValueFromSortedArrays(int[] nums1, int[] nums2, int min1, int max1, int min2, int max2, int index) {
        if (min1 > max1 || max1 < 0) {
            return nums2[min2 + index];
        }
        if (min2 > max2 || max2 < 0) {
            return nums1[min1 + index];
        }
        if (index == 0) {
            return Math.min(nums1[min1], nums2[min2]);
        }
        int compare1 = Math.min(max1, min1 + (index - 1) / 2);
        int compare2 = Math.min(max2, min2 + (index - 1) / 2);
        if (nums1[compare1] >= nums2[compare2]) {
            index -= (compare2 - min2 + 1);
            min2 = compare2 + 1;
        } else {
            index -= (compare1 - min1 + 1);
            min1 = compare1 + 1;
        }
        return findIndexValueFromSortedArrays(nums1, nums2, min1, max1, min2, max2, index);
    }

    public static void main(String[] args) {
        int[] num1 = {2};
        int[] num2 = {1, 3, 4, 5};
        Q4 q4 = new Q4();
        System.out.println(q4.findMedianSortedArrays(num1, num2));
    }
}
