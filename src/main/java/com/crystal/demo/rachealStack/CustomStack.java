package com.crystal.demo.rachealStack;

/*//empty
* push
* pop
* peek
* contains
* */

public class CustomStack {
    Object element;
    public boolean isEmpty() {
        return (element == null) ? true: false;
    }

    public void push(Object element) {
      this.element = element;
    }

    public Object pop() {
        Object temp = null;
        if (isEmpty()) throw new PopEmptyStack();
        else{
            temp = element;
            element = null;
        }
            return temp;
    }

    public Object peek() {
        if (isEmpty()) return null;
        return element;
    }
}
