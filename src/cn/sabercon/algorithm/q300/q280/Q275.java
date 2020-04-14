package cn.sabercon.algorithm.q300.q280;

/**
 * H-Index II
 * <p>
 * Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each,
 * and the other N − h papers have no more than h citations each."
 * <p>
 * Example:
 * <p>
 * Input: citations = [0,1,3,5,6]
 * Output: 3
 * Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
 * received 0, 1, 3, 5, 6 citations respectively.
 *              Since the researcher has 3 papers with at least 3 citations each and the remaining
 *              two with no more than 3 citations each, her h-index is 3.
 * Note:
 * <p>
 * If there are several possible values for h, the maximum one is taken as the h-index.
 * <p>
 * Follow up:
 * <p>
 * This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
 * Could you solve it in logarithmic time complexity?
 *
 * @author ywk
 * @date 2020-04-14
 */
public class Q275 {

    public int hIndex(int[] citations) {
        return binarySearch(citations, 0, citations.length - 1);
    }

    private int binarySearch(int[] citations, int start, int end) {
        if (end < 0) {
            return citations.length;
        }
        int middle = start + (end - start) / 2;
        if (citations[middle] <= citations.length - middle) {
            if (middle == citations.length - 1 || citations[middle + 1] > citations.length - middle - 1) {
                return Math.max(citations[middle], citations.length - middle - 1);
            }
            else {
                return binarySearch(citations, middle + 1, end);
            }
        } else {
            return binarySearch(citations, start, middle - 1);
        }
    }
}
