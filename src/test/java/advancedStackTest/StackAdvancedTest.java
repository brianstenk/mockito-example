package advancedStackTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stackWithLinkedListRachael.StackAdvanced;

import static org.junit.jupiter.api.Assertions.*;

public class StackAdvancedTest {
    StackAdvanced stack2;
    @Before
    public void setUp(){
        stack2 = new StackAdvanced();
    }
    @Test
    public void checkIfStackIsEmpty(){
        assertTrue(stack2.isEmpty());
    }

    @Test public void addElement(){
        Integer element = 3;
        stack2.push(element);
        assertFalse(stack2.isEmpty());
    }
    @Test//(expected = PopEmptyStackException.class)
    public void popFromEmptyStack(){
        Integer elem = 6;
        stack2.push(elem);
        stack2.pop();
        assertTrue(stack2.isEmpty());
    }

    @Test public void popAfterPush(){
        stack2.push(1);
        stack2.push(2);
        stack2.push(4);
        Object element  = stack2.pop();
        assertEquals(4, element);
    }
    @Test public void peekAdvanced(){
        stack2.push(10);
        assertEquals(10, stack2.peek());
    }
    @Test public void testSize(){
        stack2.push(1);
        stack2.push(2);
        stack2.pop();
        assertEquals(1, stack2.size());
    }
}
