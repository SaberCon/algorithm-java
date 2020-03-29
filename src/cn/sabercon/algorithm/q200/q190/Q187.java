package cn.sabercon.algorithm.q200.q190;

import java.util.*;

/**
 * Repeated DNA Sequences
 *
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * Example:
 *
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 *
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 *
 * @author ywk
 * @date 2020-03-28
 */
public class Q187 {

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 11) {
            return Collections.emptyList();
        }
        HashSet<String> set = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String key = s.substring(i, i + 10);
            if (set.contains(key)) {
                result.add(key);
            } else {
                set.add(key);
            }
        }
        return new ArrayList<>(result);
    }
}
