package stackWithLinkedListRachael;

import advancedStackTest.PopEmptyStackException;
import com.crystal.demo.rachealStack.PopEmptyStack;

public class StackAdvanced {
    Node head;
    private int count = 0;

    public boolean isEmpty() {
        if (head != null ) return false;
        return true;
    }

    public void push(Integer i) {
        Node node = new Node(i);
        head = node;
        head.next = null;
        count++;
    }

    public Object pop() {
        Object poppedElement = null;
        if(isEmpty()) throw new PopEmptyStackException();
        else {
            poppedElement = head.element;
            head = null;
            count--;
        }

        return  poppedElement;
    }

    public Integer peek() {
        return  (Integer)head.element;
    }

    public int size() {
        return  count;
    }


    class Node{
        Node next;
        Object element;

        Node(Object elem){
            this.element = elem;
        }
    }
}
