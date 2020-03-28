package cn.sabercon.algorithm.q200.q180;

/**
 * Largest Number
 * <p>
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * <p>
 * Example 1:
 * <p>
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 * <p>
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * @author ywk
 * @date 2020-03-28
 */
public class Q179 {

    public String largestNumber(int[] nums) {
        sort(nums, 0, nums.length - 1);
        StringBuilder builder = new StringBuilder();
        for (int num : nums) {
            builder.append(num);
        }
        int index = 0;
        for (int i = 0; i < builder.length() - 1; i++) {
            if (builder.charAt(i) == '0') {
                index++;
            } else {
                break;
            }
        }
        return builder.substring(index);
    }

    private void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = start + (end - start) / 2;
        nums[end] = nums[end]^nums[middle];
        nums[middle] = nums[end]^nums[middle];
        nums[end] = nums[end]^nums[middle];
        int val = nums[end];
        int index = start;
        for (int i = start; i < end; i++) {
            if (greaterThan(nums[i], val)) {
                if (i != index) {
                    nums[i] = nums[i]^nums[index];
                    nums[index] = nums[i]^nums[index];
                    nums[i] = nums[i]^nums[index];
                }
                index++;
            }
        }
        if (index != end) {
            nums[index] = nums[index]^nums[end];
            nums[end] = nums[index]^nums[end];
            nums[index] = nums[index]^nums[end];
        }
        sort(nums, start, index - 1);
        sort(nums, index + 1, end);
    }

    public boolean greaterThan(int num1, int num2) {
        String s1 = "" + num1 + num2;
        String s2 = "" + num2 + num1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) > s2.charAt(i)) {
                return true;
            }
            if (s1.charAt(i) < s2.charAt(i)) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Q179 q179 = new Q179();
        System.out.println(q179.largestNumber(new int[]{10, 2}));
    }
}
