package com.crystal.demo.racheal;

import com.crystal.demo.rachealStack.CustomStack;
import com.crystal.demo.rachealStack.PopEmptyStack;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/*sdsa
* Stack is an implementation of a Vector Class which is an implementation of the
* List interface
* */
@RunWith(MockitoJUnitRunner.class)
public class StackTest {
    CustomStack stack;
    @Before
    public void setUp(){
        stack = new CustomStack();
    }
    @Test
    public void checkIfStackIsEmpty(){
        assertTrue(stack.isEmpty());
      //  assertEquals(false, stack.isEmpty());
    }

    @Test
    public void addElementTest(){
        stack.push("something");
        assertFalse(stack.isEmpty());
    }

    @Test(expected = PopEmptyStack.class)
    public void popFromEmptyStack(){
        stack.pop();

    }
    @Test
    public void popAfterPush(){
        stack.push(1);
        assertEquals(1, stack.pop());

    }
    @Test
    public void stateOfStackAfterPush(){
      stack.push(1);
      stack.pop();
      assertTrue(stack.isEmpty());
    }
    @Test
    public void peekFromEmptyStack(){
        assertEquals(null, stack.peek());
    }

    @Test
    public  void peekAfterPush(){
        stack.push(2);
        assertEquals(2, stack.peek());

    }

    @Test
    public void pushMultipleElements(){
        stack.push(2);
        stack.push(3);
        stack.push(4);
        //stack.pop();
        assertEquals(4, stack.pop());
    }
}

