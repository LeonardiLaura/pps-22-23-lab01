import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList list;
    //TODO: test implementation

    @BeforeEach
    void beforeEach(){
        this.list = new CircularListImpl(Collections.emptyList());
    }


    @Test
    void testEmpty(){
        assertEquals(this.list.isEmpty(),true);
    }


    @Disabled
    @Test public void testTodo(){
        Assertions.fail();
    }

}
