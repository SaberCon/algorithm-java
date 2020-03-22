package cn.sabercon.algorithm.q200.q120;

import java.util.ArrayList;
import java.util.List;

/**
 * Triangle
 * <p>
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * <p>
 * Note:
 * <p>
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 * @author ywk
 * @date 2020-03-22
 */
public class Q120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        ArrayList<Integer> sumList = new ArrayList<>(triangle.get(triangle.size() - 1));
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> currentList = triangle.get(i);
            for (int j = 0; j < currentList.size(); j++) {
                sumList.set(j, currentList.get(j) + Math.min(sumList.get(j), sumList.get(j + 1)));
            }
        }
        return sumList.get(0);
    }
}
