package cn.sabercon.algorithm.q100.q60;

import java.util.*;

/**
 * N-Queens
 * <p>
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p>
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p>
 * Example:
 * Input: 4
 * Output: [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 *
 * @author ywk
 * @date 2020-03-15
 */
public class Q51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        char[] chars = new char[n];
        Arrays.fill(chars, '.');
        StringBuilder builder = new StringBuilder();
        builder.append(chars);
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                builder.setCharAt(i - 1, '.');
            }
            builder.setCharAt(i, 'Q');
            map.put(i, builder.toString());
        }
        solve(results, new ArrayList<>(), new HashSet<>(), map, n);
        return results;
    }

    private void solve(List<List<String>> results, List<Integer> numList, Set<Integer> numSet, Map<Integer, String> map, int n) {
        if (numList.size() == n) {
            results.add(toResult(numList, map));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!numSet.contains(i) && noAttack(numList, i)) {
                numList.add(i);
                numSet.add(i);
                solve(results, numList, numSet, map, n);
                numList.remove(numList.size() - 1);
                numSet.remove(i);
            }
        }
    }

    private boolean noAttack(List<Integer> nums, int num) {
        for (int i = 0; i < nums.size(); i++) {
            if (nums.size() - i == Math.abs(nums.get(i) - num)) {
                return false;
            }
        }
        return true;
    }

    private List<String> toResult(List<Integer> nums, Map<Integer, String> map) {
        ArrayList<String> result = new ArrayList<>();
        for (Integer num : nums) {
            result.add(map.get(num));
        }
        return result;
    }

}
