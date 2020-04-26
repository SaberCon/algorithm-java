package cn.sabercon.algorithm.q400.q340;

import java.util.*;

/**
 * Palindrome Pairs
 * <p>
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * Example 2:
 * <p>
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 *
 * @author ywk
 * @date 2020-04-26
 */
public class Q336 {

    public static List<List<Integer>> palindromePairs(String[] words) {
        Map<String, List<Integer>> suffixMap = new HashMap<>();
        Map<String, List<Integer>> prefixMap = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            map.put(word, i);
            for (int j = 0; j <= word.length(); j++) {
                String suffix = getSuffixPalindrome(word, j);
                if (suffix != null) {
                    suffixMap.computeIfAbsent(suffix, k -> new ArrayList<>()).add(i);
                }
                String prefix = getPrefixPalindrome(word, j);
                if (prefix != null) {
                    prefixMap.computeIfAbsent(prefix, k -> new ArrayList<>()).add(i);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        suffixMap.forEach((k, v) -> {
            if (map.containsKey(k)) {
                Integer index = map.get(k);
                v.forEach(i -> {
                    if (!i.equals(index)) {
                        ans.add(Arrays.asList(i, index));
                    }
                });
            }
        });
        prefixMap.forEach((k, v) -> {
            if (map.containsKey(k)) {
                Integer index = map.get(k);
                v.forEach(i -> {
                    if (!i.equals(index)) {
                        ans.add(Arrays.asList(index, i));
                    }
                });
            }
        });
        return ans;
    }

    private static String getPrefixPalindrome(String word, int length) {
        if (length == word.length()) {
            return null;
        }
        if (isPalindrome(word, 0, word.length() - length - 1)) {
            StringBuilder builder = new StringBuilder(length);
            for (int i = word.length() - 1; i > word.length() - length - 1; i--) {
                builder.append(word.charAt(i));
            }
            return builder.toString();
        }
        return null;
    }

    private static String getSuffixPalindrome(String word, int length) {
        if (isPalindrome(word, length, word.length() - 1)) {
            StringBuilder builder = new StringBuilder(length);
            for (int i = length - 1; i >= 0; i--) {
                builder.append(word.charAt(i));
            }
            return builder.toString();
        }
        return null;
    }

    private static boolean isPalindrome(String word, int start, int end) {
        for (int i = start, j = 0; i < end; i++, j++) {
            if (word.charAt(i) != word.charAt(end - j))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(getSuffixPalindrome("abcddd", 6));
    }
}
