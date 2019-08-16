package Lesson4;

import lesson4.linkedlist.TwoSideLinkedListImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestTwoSideLinkedList {

    TwoSideLinkedListImpl<Integer> linkedList;

    @Before
    public void init(){
        linkedList = new TwoSideLinkedListImpl<>();
    }

    @Test
    public void testInsertLast(){
        linkedList.insertLast(1);
        linkedList.insertLast(2);
        linkedList.insertLast(3);
        linkedList.insertLast(4);
        Integer[] mass = new Integer[4];
        int size = linkedList.size();
        while (!linkedList.isEmpty()) {
            for (int i = 0; i <size; i++) {
                mass[i] = linkedList.removeFirst();
            }
            Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4}, mass);
        }
    }

    @Test
    public void testInsertFirst(){
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        Integer[] mass = new Integer[4];
        int size = linkedList.size();
        while (!linkedList.isEmpty()) {
            for (int i = 0; i <size; i++) {
                mass[i] = linkedList.removeFirst();
            }
            Assert.assertArrayEquals(new Integer[]{4, 3, 2, 1}, mass);
        }
    }


    @Test
    public void testRemoveFirst(){
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        Assert.assertEquals((Integer)4,linkedList.removeFirst());
        Assert.assertEquals((Integer)3,linkedList.removeFirst());
    }

    @Test
    public void testRemove(){
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        Assert.assertTrue(linkedList.remove(3));
        Assert.assertFalse(linkedList.remove(3));
    }

}
