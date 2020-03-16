package cn.sabercon.algorithm.q100.q70;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Text Justification
 * <p>
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
 * Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * <p>
 * Note:
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 * <p>
 * Example 1:
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * <p>
 * Example 2:
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 *              because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified becase it contains only one word.
 * <p>
 * Example 3:
 * Input:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 * @author ywk
 * @date 2020-03-16
 */
public class Q68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        char[] chars = new char[maxWidth];
        Arrays.fill(chars, ' ');
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> line = new ArrayList<>();
        int lineLength = 0;
        for (int i = 0; i < words.length - 1; i++) {
            if (lineLength + words[i].length() > maxWidth - line.size()) {
                result.add(toLineString(line, lineLength, maxWidth, chars));
                line.clear();
                line.add(words[i]);
                lineLength = words[i].length();
            } else {
                line.add(words[i]);
                lineLength += words[i].length();
            }
        }
        String lastWord = words[words.length - 1];
        if (lineLength + lastWord.length() > maxWidth - line.size()) {
            result.add(toLineString(line, lineLength, maxWidth, chars));
            result.add(lastWord + String.valueOf(chars, 0, maxWidth - lastWord.length()));
        } else {
            line.add(lastWord);
            String join = String.join(" ", line);
            result.add(join + String.valueOf(chars, 0, maxWidth - join.length()));
        }
        return result;
    }

    private String toLineString(List<String> line, int lineLength, int maxWidth, char[] chars) {
        if (line.size() == 1) {
            return line.get(0) + String.valueOf(chars, 0, maxWidth - line.get(0).length());
        }
        int spaceNum = (maxWidth - lineLength) / (line.size() - 1);
        int extra = (maxWidth - lineLength) % (line.size() - 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < line.size(); i++) {
            builder.append(line.get(i)).append(chars, 0, extra > i ? spaceNum + 1 : spaceNum);
        }
        return builder.delete(maxWidth, maxWidth + spaceNum).toString();
    }
}
