package cn.sabercon.algorithm.q100.q80;

import java.util.ArrayList;
import java.util.List;

/**
 * Combinations
 * <p>
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * Example:
 * <p>
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 * @author ywk
 * @date 2020-03-18
 */
public class Q77 {

    public List<List<Integer>> combine(int n, int k) {
        return backtracking(n, k, new ArrayList<>());
    }

    private List<List<Integer>> backtracking(int n, int k, ArrayList<Integer> list) {
        List<List<Integer>> result = new ArrayList<>();
        if (k == 0) {
            result.add(list);
        } else {
            if (n > k) {
                ArrayList<Integer> clone1 = (ArrayList<Integer>) list.clone();
                result.addAll(backtracking(n - 1, k, clone1));
            }
            ArrayList<Integer> clone2 = (ArrayList<Integer>) list.clone();
            clone2.add(n);
            result.addAll(backtracking(n - 1, k - 1, clone2));
        }
        return result;
    }
}
