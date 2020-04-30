package cn.sabercon.algorithm.q400.q390;

import java.util.ArrayList;
import java.util.List;

/**
 * Lexicographical Numbers
 * <p>
 * Given an integer n, return 1 - n in lexicographical order.
 * <p>
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * <p>
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 *
 * @author ywk
 * @date 2020-04-29
 */
public class Q386 {

    private List<Integer> ans;

    public List<Integer> lexicalOrder(int n) {
        ans = new ArrayList<>(n);
        for (int i = 1; i < 10; i++) {
            dfs(n, i);
        }
        return ans;
    }

    private void dfs(int maxValue, int num) {
        if (num > maxValue) {
            return;
        }
        ans.add(num);
        num *= 10;
        for (int i = 0; i < 10; i++) {
            dfs(maxValue, num++);
        }
    }
}
