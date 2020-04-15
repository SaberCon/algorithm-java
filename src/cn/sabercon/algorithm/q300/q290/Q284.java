package cn.sabercon.algorithm.q300.q290;

import java.util.Iterator;

/**
 * Peeking Iterator
 *
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation
 * -- it essentially peek() at the element that will be returned by the next call to next().
 *
 * Example:
 *
 * Assume that the iterator is initialized to the beginning of the list: [1,2,3].
 *
 * Call next() gets you 1, the first element in the list.
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * You call next() the final time and it returns 3, the last element.
 * Calling hasNext() after that should return false.
 * Follow up: How would you extend your design to be generic and work with all types, not just integer?
 *
 * @author ywk
 * @date 2020-04-15
 */
public class Q284 implements Iterator<Integer> {

    private Iterator<Integer> iterator;

    private Integer current;

    public Q284(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (current == null) {
            current = iterator.next();
        }
        return current;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (current == null) {
            return iterator.next();
        } else {
            Integer num = current;
            current = null;
            return num;
        }
    }

    @Override
    public boolean hasNext() {
        return current != null || iterator.hasNext();
    }
}
