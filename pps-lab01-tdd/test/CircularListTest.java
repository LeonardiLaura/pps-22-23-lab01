import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;


/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

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
    public void testNext(){
        this.list.add(1);
        Assertions.assertEquals(this.list.next(), Optional.of(1));
    }

    @Test
    public void testNextEmpty(){
        Assertions.assertEquals(this.list.next(), Optional.empty());
    }

    @Test
    public void testNextCircular(){
        this.list.add(1);
        this.list.add(2);
        Assertions.assertEquals(this.list.next(),Optional.of(1));
        Assertions.assertEquals(this.list.next(),Optional.of(2));
        Assertions.assertEquals(this.list.next(),Optional.of(1));
    }


   

}
