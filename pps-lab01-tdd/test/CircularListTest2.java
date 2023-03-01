
import es2.CircularList;
import es2.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;


/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest2 {

    private CircularList list;
    //TODO: test implementation

    @BeforeEach
    void beforeEach(){
        this.list = new CircularListImpl(new ArrayList<>());
    }


    @Test
    void testEmpty(){
        Assertions.assertTrue(this.list.isEmpty());
    }

    @Test
    void testAdd(){
        this.list.add(6);
        Assertions.assertFalse(this.list.isEmpty());
    }


    @Test
    void testSize(){
        Assertions.assertEquals(this.list.size(),0);
        this.list.add(2);
        Assertions.assertEquals(this.list.size(),1);
    }

    @Test
    public void testForwardIterator(){
        this.list.add(1);
        this.list.add(2);
        Iterator<Optional<Integer>> it = this.list.forwardIterator();
        Assertions.assertEquals(it.next(), Optional.of(1));
        Assertions.assertEquals(it.next(), Optional.of(2));
        Assertions.assertEquals(it.next(), Optional.of(1));
    }

    @Test
    public void testBackwardIterator(){
        this.list.add(1);
        this.list.add(2);
        Iterator<Optional<Integer>> it = this.list.backwardIterator();
        Assertions.assertEquals(it.next(), Optional.of(2));
        Assertions.assertEquals(it.next(), Optional.of(1));
        Assertions.assertEquals(it.next(), Optional.of(2));
    }



}
