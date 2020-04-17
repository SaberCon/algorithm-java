package cn.sabercon.algorithm.q300.q300;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Serialize and Deserialize Binary Tree
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Example: 
 *
 * You may serialize the following tree:
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * as "[1,2,3,null,null,4,5]"
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format,
 * so please be creative and come up with different approaches yourself.
 *
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 *
 * @author ywk
 * @date 2020-04-17
 */
public class Q297 {

    public String serialize(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        toList(list, root);
        return list.stream().map(num -> num == null ? "" : String.valueOf(num)).collect(Collectors.joining(","));
    }

    private void toList(List<Integer> list, TreeNode node) {
        if (node == null) {
            list.add(null);
            return;
        }
        list.add(node.val);
        toList(list, node.left);
        toList(list, node.right);
    }

    public TreeNode deserialize(String data) {
        return toTree(Arrays.stream(data.split(","))
                .map(s -> "".equals(s) ? null : Integer.parseInt(s))
                .collect(Collectors.toCollection(LinkedList::new)));
    }

    private TreeNode toTree(List<Integer> list) {
        if (list.size() == 0) {
            return null;
        }
        Integer num = list.remove(0);
        if (num == null) {
            return null;
        }
        TreeNode node = new TreeNode(num);
        node.left = toTree(list);
        node.right = toTree(list);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Q297 q297 = new Q297();
        System.out.println(q297.serialize(root));
        System.out.println(Arrays.toString(q297.serialize(root).split(",")));
        System.out.println(Arrays.toString(",,,a,b,c,,,,".split(",")));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
