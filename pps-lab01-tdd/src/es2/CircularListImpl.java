package es2;


import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class CircularListImpl implements CircularList {

    private final List<Integer> list;


    public CircularListImpl(List l) {
        this.list = l;
    }

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Iterator<Optional<Integer>> forwardIterator() {
        return new Iterator<Optional<Integer>>() {

            private int curr=-1;

            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public Optional<Integer> next() {
                curr = curr + 1 <list.size()? curr + 1 :0;
                Optional<Integer> opt = hasNext()? Optional.of(list.get(curr)) :Optional.empty();
                return opt;
            }
        };
    }

    @Override
    public Iterator<Optional<Integer>> backwardIterator() {
        return new Iterator<Optional<Integer>>() {
            private int curr=-1;

            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public Optional<Integer> next() {
                curr = curr - 1 >= 0? curr - 1 :list.size()-1;
                return hasNext()? Optional.of(list.get(curr)):Optional.empty();
            }
        };
    }

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> condition) {
        return Optional.empty();
    }


}
