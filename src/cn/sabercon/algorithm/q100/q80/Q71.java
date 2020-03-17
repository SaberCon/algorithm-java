package cn.sabercon.algorithm.q100.q80;

import java.util.Stack;

/**
 * Simplify Path
 * <p>
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 * In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level.
 * For more information, see: Absolute path vs relative path in Linux/Unix
 * Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. 
 * The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.
 * <p>
 * Example 1:
 * Input: "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 * <p>
 * Example 2:
 * Input: "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 * Example 3:
 * <p>
 * Input: "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 * Example 4:
 * <p>
 * Input: "/a/./b/../../c/"
 * Output: "/c"
 * Example 5:
 * <p>
 * Input: "/a/../../b/../c//.//"
 * Output: "/c"
 * Example 6:
 * <p>
 * Input: "/a//b////c/d//././/.."
 * Output: "/a/b/c"
 *
 * @author ywk
 * @date 2020-03-17
 */
public class Q71 {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        path = path.substring(1);
        int index = path.indexOf("/");
        while (index != -1) {
            String dir = path.substring(0, index);
            if (!"".equals(dir) && !".".equals(dir)) {
                if ("..".equals(dir)) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(dir);
                }
            }
            path = path.substring(index + 1);
            index = path.indexOf("/");
        }
        if (!"".equals(path) && !".".equals(path)) {
            if ("..".equals(path)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(path);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        String result = "";
        while (!stack.isEmpty()) {
            result = "/" + stack.pop() + result;
        }
        return result;
    }
}
