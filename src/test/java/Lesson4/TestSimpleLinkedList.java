package Lesson4;

import lesson4.linkedlist.SimpleLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSimpleLinkedList {
    SimpleLinkedList<Integer> linkedList;

    @Before
    public void init(){
        linkedList = new SimpleLinkedList<>();
    }

    @Test
    public void testInsertFirst(){
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        Assert.assertEquals((Integer) 4, linkedList.getFirstValue());
    }

    @Test
    public void testRemoveFirst(){
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        Assert.assertEquals((Integer) 4, linkedList.removeFirst());
        Assert.assertEquals((Integer) 3, linkedList.removeFirst());
    }

    @Test
    public void testContains(){
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        Assert.assertTrue(linkedList.contains(3));
        Assert.assertFalse(linkedList.contains(5));

    }

}
