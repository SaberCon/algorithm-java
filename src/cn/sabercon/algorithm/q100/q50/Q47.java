package cn.sabercon.algorithm.q100.q50;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Permutation II
 * <p>
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * Example:
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 *
 * @author ywk
 * @date 2020-03-14
 */
public class Q47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        Collections.sort(numList);
        return backtracking(numList, 0);
    }

    private List<List<Integer>> backtracking(ArrayList<Integer> nums, int index) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.size() == index) {
            results.add(new ArrayList<>());
            return results;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = index; i < nums.size(); i++) {
            if (set.contains(nums.get(i))) {
                continue;
            } else {
                set.add(nums.get(i));
            }
            ArrayList<Integer> clone = (ArrayList<Integer>) nums.clone();
            int num = nums.get(i);
            Collections.swap(clone, index, i);
            List<List<Integer>> result = backtracking(clone, index + 1);
            results.addAll(result.stream().peek(e -> e.add(num)).collect(Collectors.toList()));
        }
        return results;
    }

    public static void main(String[] args) {
        Q47 q47 = new Q47();
        System.out.println(q47.permuteUnique(new int[]{1, 2, 3}));
    }
}
