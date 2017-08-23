package test;

import model.Stack;

import static org.junit.Assert.*;

/**
 * Created by Home on 8/13/2017.
 */
public class StackTest {
    Stack list = new Stack();

    @org.junit.Test
    public void push() throws Exception {
        list.push(5);
        list.push(2);
        list.push(1);
        list.push(7);
        list.push(9);

        assertSame(list.peek().getElement(), 9);
        list.pop();
        list.pop();
        assertSame(list.peek().getElement(), 1);

    }

    @org.junit.Test
    public void peek() throws Exception {
        list.push(5);
        list.push(2);
        assertSame(list.peek().getElement(), 2);

    }

    @org.junit.Test
    public void empty() throws Exception {

        assertSame(list.empty(),true);
        list.push(2);
        assertSame(list.empty(),false);

    }

    @org.junit.Test
    public void pop() throws Exception {
        list.push(2);
        list.push(5);

        assertSame(list.pop().getElement(),5);
    }

    @org.junit.Test
    public void search() throws Exception {
        list.push(2);
        list.push(5);
        list.push(3);
        list.push(1);

        assertSame(list.search(5),5);
    }

}