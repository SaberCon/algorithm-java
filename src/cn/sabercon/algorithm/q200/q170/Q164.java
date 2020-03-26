package cn.sabercon.algorithm.q200.q170;

/**
 * Maximum Gap
 *
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 *
 * Return 0 if the array contains less than 2 elements.
 *
 * Example 1:
 *
 * Input: [3,6,9,1]
 * Output: 3
 * Explanation: The sorted form of the array is [1,3,6,9], either
 *              (3,6) or (6,9) has the maximum difference 3.
 * Example 2:
 *
 * Input: [10]
 * Output: 0
 * Explanation: The array contains less than 2 elements, therefore return 0.
 * Note:
 *
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 * Try to solve it in linear time/space.
 *
 * @author ywk
 * @date 2020-03-26
 */
public class Q164 {

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        Bucket[] buckets = new Bucket[nums.length];
        int bucketSize = (max - min + 1) % (nums.length - 1) == 0 ?  (max - min + 1) / (nums.length - 1) : (max - min + 1) / (nums.length - 1) + 1;
        for (int num : nums) {
            int index = (num - min) / bucketSize;
            if (buckets[index] == null) {
                buckets[index] = new Bucket(num, num);
            } else {
                buckets[index].max = Math.max(buckets[index].max, num);
                buckets[index].min = Math.min(buckets[index].min, num);
            }
        }
        int result = bucketSize - 1;
        int pre = buckets[0].max;
        for (Bucket bucket : buckets) {
            if (bucket != null) {
                result = Math.max(result, bucket.min - pre);
                pre = bucket.max;
            }
        }
        return result;
    }

    public class Bucket {
        int min;
        int max;

        Bucket(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}
