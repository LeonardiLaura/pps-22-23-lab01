package es2;

import java.util.Iterator;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Represents a list of integers, with a built-in iterator that is bidirectional and circular.
 * Example: with  a list like {1,2,3}, the first call ofnext() returns 1, the second call returns 2,
 * the third returns 3, the fourth returns 1, and so on. Call to previous() goes in the other way.
 */
public interface CircularList {

    /**
     * Adds an element to the list, namely, after the last inserted one.
     * @param element the element to be added to the list
     */
    void add(final int element);

    /**
     * Provides the current size of the list
     * @return the size of the list
     */
    int size();

    /**
     * Checks if the list is empty
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Provides a forward iterator.
     * @return a new java.util.Iterator, which yields next elements, circularly
     */
    Iterator<Optional<Integer>> forwardIterator();

    /**
     * Provides a backward Iterator.
     * @return a new java.util.Iterator, which yields previous elements, circularly
     */
    Iterator<Optional<Integer>> backwardIterator();






}
