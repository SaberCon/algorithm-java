package cn.sabercon.algorithm.q300.q230;

/**
 * Rectangle Area
 *
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 *
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 *
 * Example:
 *
 * Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
 * Output: 45
 * Note:
 *
 * Assume that the total area is never beyond the maximum possible value of int.
 *
 * @author ywk
 * @date 2020-04-07
 */
public class Q223 {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long a = A;
        long b = B;
        long c = C;
        long d = D;
        long e = E;
        long f = F;
        long g = G;
        long h = H;
        long coverLength = 0;
        long coverWidth = 0;
        if (a < e) {
            coverLength = Math.max(0, Math.min(g - e, c - e));
        } else {
            coverLength = Math.max(0, Math.min(c - a, g - a));
        }
        if (b < f) {
            coverWidth = Math.max(0, Math.min(h - f, d - f));
        } else {
            coverWidth = Math.max(0, Math.min(d - b, h - b));
        }
        return (int) ((c - a) * (d - b) + (g - e) * (h - f) - coverLength * coverWidth);
    }
}
