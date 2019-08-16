package Lesson4;

import lesson4.linkedlist.LinkedQueue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestLinkedQueue {

    LinkedQueue<Integer> linkedQueue;

    @Before
    public void init(){
        linkedQueue = new LinkedQueue<>();
    }

    @Test
    public void testInsert(){
        Assert.assertTrue(linkedQueue.insert(1));
    }
    @Test
    public void testRemove(){
        linkedQueue.insert(1);
        linkedQueue.insert(2);
        linkedQueue.insert(3);
        Assert.assertEquals((Integer) 1,linkedQueue.remove());
    }
    @Test
    public void testPeek(){
        linkedQueue.insert(1);
        linkedQueue.insert(2);
        linkedQueue.insert(3);
        Assert.assertEquals((Integer) 1,linkedQueue.peek());
    }
}
