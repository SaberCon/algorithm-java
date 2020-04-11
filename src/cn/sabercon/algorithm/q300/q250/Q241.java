package cn.sabercon.algorithm.q300.q250;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Different Ways to Add Parentheses
 *
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators.
 * The valid operators are +, - and *.
 *
 * Example 1:
 *
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Example 2:
 *
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 * @author ywk
 * @date 2020-04-11
 */
public class Q241 {

    public List<Integer> diffWaysToCompute(String input) {
        List<Pair<Integer, Character>> calculations = new ArrayList<>();
        if (input.length() == 0) {
            return Collections.emptyList();
        }
        int num = 0;
        for (char c : input.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                calculations.add(new Pair<>(num, c));
                num = 0;
            } else {
                num = num * 10 + c - '0';
            }
        }
        calculations.add(new Pair<>(num, null));
        return divideAndConquer(calculations, 0, calculations.size() - 1, new List[calculations.size()][calculations.size()]);
    }

    private List<Integer> divideAndConquer(List<Pair<Integer, Character>> calculations, int start, int end, List[][] cache) {
        if (cache[start][end] != null) {
            return cache[start][end];
        }
        if (start == end) {
            cache[start][end] = Collections.singletonList(calculations.get(start).getKey());
        } else {
            List<Integer> ans = new ArrayList<>();
            for (int i = start; i < end; i++) {
                List<Integer> lefts = divideAndConquer(calculations, start, i, cache);
                List<Integer> rights = divideAndConquer(calculations, i + 1, end, cache);
                Character operator = calculations.get(i).getValue();
                if (operator.equals('+')) {
                    lefts.forEach(left -> {
                        rights.forEach(right -> {
                            ans.add(left + right);
                        });
                    });
                } else if (operator.equals('-')) {
                    lefts.forEach(left -> {
                        rights.forEach(right -> {
                            ans.add(left - right);
                        });
                    });
                } else if (operator.equals('*')) {
                    lefts.forEach(left -> {
                        rights.forEach(right -> {
                            ans.add(left * right);
                        });
                    });
                }
            }
            cache[start][end] = ans;
        }
        return cache[start][end];
    }

    public static void main(String[] args) {
        Q241 q241 = new Q241();
        System.out.println(q241.diffWaysToCompute("0"));
    }
}
