package cn.sabercon.algorithm.q100.q20;

import java.util.ArrayList;
import java.util.List;

/**
 * Letter Combinations of a Phone Number
 * <p>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * @author ywk
 * @date 2020-03-09
 */
public class Q17 {

    public List<String> letterCombinations(String digits) {
        ArrayList<String> resultList = new ArrayList<>();
        getLetterCombinations(resultList, "", digits);
        return resultList;
    }

    private void getLetterCombinations(ArrayList<String> resultList, String prefix, String digits) {
        if (digits.length() == 1) {
            for (char letter : getLetters(digits.charAt(0))) {
                resultList.add(prefix + letter);
            }
        } else if (digits.length() > 1) {
            for (char letter : getLetters(digits.charAt(0))) {
                getLetterCombinations(resultList, prefix + letter, digits.substring(1));
            }
        }
    }

    private char[] getLetters(char digit) {
        switch (digit) {
            case '2':
                return new char[]{'a', 'b', 'c'};
            case '3':
                return new char[]{'d', 'e', 'f'};
            case '4':
                return new char[]{'g', 'h', 'i'};
            case '5':
                return new char[]{'j', 'k', 'l'};
            case '6':
                return new char[]{'m', 'n', 'o'};
            case '7':
                return new char[]{'p', 'q', 'r', 's'};
            case '8':
                return new char[]{'t', 'u', 'v'};
            case '9':
                return new char[]{'w', 'x', 'y', 'z'};
            default:
                return null;
        }
    }
}
