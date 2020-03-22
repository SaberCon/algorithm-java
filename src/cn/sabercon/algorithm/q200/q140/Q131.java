package cn.sabercon.algorithm.q200.q140;

import java.util.ArrayList;
import java.util.List;

/**
 * Palindrome Partitioning
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * @author ywk
 * @date 2020-03-22
 */
public class Q131 {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        int[][] cache = new int[s.length()][s.length()];
        generatePartition(result, cache, s, 0, new ArrayList<>());
        return result;
    }

    private void generatePartition(List<List<String>> result, int[][] cache, String s, int index, ArrayList<String> list) {
        if (index == s.length()) {
            ArrayList<String> clone = (ArrayList<String>) list.clone();
            result.add(clone);
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i, cache)) {
                list.add(s.substring(index, i + 1));
                generatePartition(result, cache, s, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int begin, int end, int[][] cache) {
        if (cache[begin][end] != 0) {
            return cache[begin][end] == 1;
        }
        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end)) {
                cache[begin][end] = -1;
                return false;
            }
            begin++;
            end--;
        }
        cache[begin][end] = 1;
        return true;
    }
}
