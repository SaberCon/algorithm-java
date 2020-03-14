package cn.sabercon.algorithm.q100.q50;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Permutations
 * <p>
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 *
 * @author ywk
 * @date 2020-03-14
 */
public class Q46 {

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numList = new LinkedList<>();
        for (int num : nums) {
            numList.add(num);
        }
        return permuteList(numList);
    }

    private List<List<Integer>> permuteList(List<Integer> numList) {
        List<List<Integer>> results = new ArrayList<>();
        if (numList.size() == 0) {
            return results;
        }
        if (numList.size() == 1) {
            results.add(numList);
            return results;
        }
        for (int i = 0; i < numList.size(); i++) {
            int num = numList.get(i);
            List<List<Integer>> result = permuteList(numList.stream().filter(e -> e != num).collect(Collectors.toList()));
            results.addAll(result.stream().peek(e -> e.add(num)).collect(Collectors.toList()));
        }
        return results;
    }
}
