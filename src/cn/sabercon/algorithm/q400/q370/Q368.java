package cn.sabercon.algorithm.q400.q370;

import java.util.*;

/**
 * Largest Divisible Subset
 *
 *
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
 *
 * Si % Sj = 0 or Sj % Si = 0.
 *
 * If there are multiple solutions, return any subset is fine.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2] (of course, [1,3] will also be ok)
 * Example 2:
 *
 * Input: [1,2,4,8]
 * Output: [1,2,4,8]
 *
 * @author ywk
 * @date 2020-04-28
 */
public class Q368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        TreeMap<Integer, List<Integer>> map = new TreeMap<>(Comparator.reverseOrder());
        for (int num : nums) {
            int count = 1;
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                for (Integer n : entry.getValue()) {
                    if (num % n == 0) {
                        count = entry.getKey() + 1;
                        break;
                    }
                }
                if (count > 1) {
                    break;
                }
            }
            map.computeIfAbsent(count, k -> new ArrayList<>()).add(num);
        }
        List<Integer> ans = new ArrayList<>(map.size());
        int num = 0;
        for (List<Integer> numList : map.values()) {
            for (Integer n : numList) {
                if (num % n == 0) {
                    ans.add(n);
                    num = n;
                    break;
                }
            }
        }
        return ans;
    }
}
