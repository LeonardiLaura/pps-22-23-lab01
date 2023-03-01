package es3;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class CircularListImpl implements CircularList {

    private final List<Integer> list;
    private int curr=-1;

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
    public Optional<Integer> next() {
        curr = curr + 1 <this.list.size()? curr + 1 :0;
        Optional<Integer> opt = this.list.isEmpty()? Optional.empty(): Optional.of(list.get(curr));
        return opt;
    }

    @Override
    public Optional<Integer> previous() {
        curr = curr - 1 >= 0? curr - 1 :this.list.size()-1;
        return this.list.isEmpty()? Optional.empty(): Optional.of(list.get(curr));
    }

    @Override
    public void reset() {
        curr=-1;
    }

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> condition) {
        Collection<Integer> l = new ArrayList(this.list.subList(curr+1,this.list.size()));
        l.addAll(this.list.subList(0,curr+1));
        Optional<Integer> o =l.stream().filter(condition).findFirst();
        curr=this.list.indexOf(o.get());
        return o;
    }
}
