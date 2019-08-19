package Lesson4;

import lesson4.linkedlist.LinkedStackImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestLinkedStack {

    LinkedStackImpl<Integer> linkedStack;

    @Before
    public void init(){
        linkedStack = new LinkedStackImpl<>();
    }

    @Test
    public void testPush() {
        Integer[] mass = new Integer[3];
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
         int size = linkedStack.size();
        while (!linkedStack.isEmpty()) {
            for (int i = 0; i <size; i++) {
                mass[i] = linkedStack.pop();
            }
            Assert.assertArrayEquals(new Integer[]{3, 2, 1}, mass);
        }
    }
    @Test
    public void testPop(){
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        Assert.assertEquals((Integer) 3,linkedStack.pop());
        Assert.assertEquals((Integer) 2,linkedStack.pop());
        Assert.assertEquals((Integer) 1,linkedStack.pop());
    }

    @Test
    public void testPeek(){
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        Assert.assertEquals((Integer) 3,linkedStack.peek());
    }
}
