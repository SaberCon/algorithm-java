package cn.sabercon.algorithm.q400.q350;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Flatten Nested List Iterator
 * <p>
 * Given a nested list of integers, implement an iterator to flatten it.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns false,
 *              the order of elements returned by next should be: [1,1,2,1,1].
 * Example 2:
 * <p>
 * Input: [1,[4,[6]]]
 * Output: [1,4,6]
 * Explanation: By calling next repeatedly until hasNext returns false,
 *              the order of elements returned by next should be: [1,4,6].
 *
 * @author ywk
 * @date 2020-04-26
 */
public class Q341 implements Iterator<Integer> {

    private Queue<Integer> queue;

    public Q341(List<NestedInteger> nestedList) {
        queue = new LinkedList<>();
        toQueue(nestedList);
    }

    private void toQueue(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                queue.add(nestedInteger.getInteger());
            } else {
                toQueue(nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }
}
