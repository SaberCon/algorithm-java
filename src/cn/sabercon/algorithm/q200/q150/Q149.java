package cn.sabercon.algorithm.q200.q150;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.HashMap;

/**
 * Max Points on a Line
 * <p>
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 * Example 2:
 * <p>
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 *
 * @author ywk
 * @date 2020-03-25
 */
public class Q149 {

    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int repeat = 1;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    repeat++;
                } else {
                    String slope = points[i][0] == points[j][0] ? "x" :
                            points[i][1] == points[j][1] ? "y" :
                                    ((points[i][1] - points[j][1]) * 1.0 / (points[i][0] - points[j][0])) + " " + ((points[i][0] - points[j][0]) * 1.0 / (points[i][1] - points[j][1]));
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                }
            }
            if (map.isEmpty()) {
                max = Math.max(max, repeat);
            }
            for (Integer value : map.values()) {
                max = Math.max(max, value + repeat);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        BigDecimal bigA = BigDecimal.valueOf(94911150).divide(BigDecimal.valueOf(94911151), 20,  RoundingMode.HALF_UP);
        BigDecimal bigB = BigDecimal.valueOf(94911151).divide(BigDecimal.valueOf(94911152), 20, RoundingMode.HALF_UP);
        // [[0,0],[94911151,94911150],[94911152,94911151]]
        double a = 94911151 * 1.0 / 94911150;
        double b = 94911152 * 1.0 / 94911151;
        System.out.println(a);
        System.out.println(b);
        System.out.println(bigA);
        System.out.println(bigB);
    }
}
