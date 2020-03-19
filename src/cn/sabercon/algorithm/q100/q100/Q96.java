package cn.sabercon.algorithm.q100.q100;

/**
 * Unique Binary Search Trees
 * <p>
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * <p>
 * Example:
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *
 * @author ywk
 * @date 2020-03-19
 */
public class Q96 {

    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        return num(1, n);
    }

    private int num(int begin, int end) {
        if (begin >= end) {
            return 1;
        }
        int num = 0;
        for (int i = begin; i <= end; i++) {
            num += num(begin, i - 1) * num(i + 1, end);
        }
        return num;
    }
}
