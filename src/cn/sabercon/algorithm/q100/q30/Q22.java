package cn.sabercon.algorithm.q100.q30;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate Parentheses
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author ywk
 * @date 2020-03-09
 */
public class Q22 {

    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        generate(result, "", n, n);
        return result;
    }

    private void generate(ArrayList<String> result, String s, int left, int right) {
        if (right == 0) {
            result.add(s);
        }
        if (left > 0) {
            generate(result, s + '(', left - 1, right);
        }
        if (right > left) {
            generate(result, s + ')', left, right - 1);
        }
    }
}
