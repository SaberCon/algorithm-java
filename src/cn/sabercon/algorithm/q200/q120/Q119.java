package cn.sabercon.algorithm.q200.q120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Pascal's Triangle II
 * <p>
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 3
 * Output: [1,3,3,1]
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 * @author ywk
 * @date 2020-03-22
 */
public class Q119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex + 1);
        list.add(1);
        if (rowIndex == 0) {
            return list;
        }
        for (int i = 0; i < rowIndex; i++) {
            int current;
            int pre = list.get(0);
            for (int j = 1; j < list.size(); j++) {
                current = list.get(j);
                list.set(j, current + pre);
                pre = current;
            }
            list.add(1);
        }
        return list;
    }

    public static void main(String[] args) {
        Q119 q119 = new Q119();
        System.out.println(q119.getRow(4));
    }
}
