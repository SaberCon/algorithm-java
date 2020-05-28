package cn.sabercon.algorithm.q400.q400;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 399. Evaluate Division
 *
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number).
 * Given some queries, return the answers. If the answer does not exist, return -1.0.
 *
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries ,
 * where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
 *
 * According to the example above:
 *
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 *  
 *
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 *
 * @author SaberCon
 * @date 2020-05-28
 */
public class Q399 {

    Map<String, Pair<String, Double>> map;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            Pair<String, Double> dividend = findSource(new Pair<>(equations.get(i).get(0), 1.0));
            Pair<String, Double> divisor = findSource(new Pair<>(equations.get(i).get(1), 1.0));
            if (dividend.getKey().equals(divisor.getKey())) {
                continue;
            }
            map.put(dividend.getKey(), new Pair<>(divisor.getKey(), values[i] * divisor.getValue() / dividend.getValue()));
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < ans.length; i++) {
            if (!map.containsKey(queries.get(i).get(0)) || !map.containsKey(queries.get(i).get(1))) {
                ans[i] = -1.0;
                continue;
            }
            Pair<String, Double> dividend = findSource(new Pair<>(queries.get(i).get(0), 1.0));
            Pair<String, Double> divisor = findSource(new Pair<>(queries.get(i).get(1), 1.0));
            if (dividend.getKey().equals(divisor.getKey())) {
                ans[i] = dividend.getValue() / divisor.getValue();
            } else {
                ans[i] = -1.0;
            }
        }
        return ans;
    }

    private Pair<String, Double> findSource(Pair<String, Double> pair) {
        if (!map.containsKey(pair.getKey())) {
            map.put(pair.getKey(), pair);
            return pair;
        }
        Pair<String, Double> relation = map.get(pair.getKey());
        if (pair.getKey().equals(relation.getKey())) {
            return pair;
        }
        return findSource(new Pair<>(relation.getKey(), relation.getValue() * pair.getValue()));
    }
}
