package cn.sabercon.algorithm.q200.q120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Pascal's Triangle
 * <p>
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 5
 * Output:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 *
 * @author ywk
 * @date 2020-03-22
 */
public class Q118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        result.add(Arrays.asList(1));
        while (result.size() < numRows) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            List<Integer> preList = result.get(result.size() - 1);
            for (int i = 1; i < preList.size(); i++) {
                list.add(preList.get(i - 1) + preList.get(i));
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }
}
