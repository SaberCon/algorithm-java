package cn.sabercon.algorithm.q100.q70;

/**
 * Valid Number
 * <p>
 * Validate if a given string can be interpreted as a decimal number.
 * <p>
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * <p>
 * Note: It is intended for the problem statement to be ambiguous.
 * You should gather all requirements up front before implementing one.
 * However, here is a list of characters that can be in a valid decimal number:
 * Numbers 0-9
 * Exponent - "e"
 * Positive/negative sign - "+"/"-"
 * Decimal point - "."
 * Of course, the context of these characters also matters in the input.
 * <p>
 * Update (2015-02-10):
 * The signature of the C++ function had been updated.
 * If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition.
 *
 * @author ywk
 * @date 2020-03-16
 */
public class Q65 {

    public boolean isNumber(String s) {
        s = s.trim();
        char[] chars = s.toCharArray();
        int index = s.indexOf('e');
        if (index == -1) {
            return isValid(chars, 0, chars.length - 1);
        } else {
            return isValid(chars, 0, index - 1) && isValidNoDot(chars, index + 1, chars.length - 1);
        }
    }

    private boolean isValidNoDot(char[] chars, int begin, int end) {
        if (begin > end) {
            return false;
        }
        if (chars[begin] == '-' || chars[begin] == '+') {
            begin++;
            if (begin > end) {
                return false;
            }
        }
        for (int i = begin; i <= end; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[] chars, int begin, int end) {
        if (begin > end) {
            return false;
        }
        if (chars[begin] == '-' || chars[begin] == '+') {
            begin++;
            if (begin > end) {
                return false;
            }
        }
        if (begin == end && chars[begin] == '.') {
            return false;
        }
        boolean hasDot = false;
        for (int i = begin; i <= end; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                if (hasDot || chars[i] != '.') {
                    return false;
                }
                hasDot = true;
            }
        }
        return true;
    }
}
