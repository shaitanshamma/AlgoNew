import lesson2.array.ArrayImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestArraysSort {

    ArrayImpl<Integer> array;
    Integer [] expected;

    @Before
    public void init(){
        array = new ArrayImpl<>(5);
    }

    @Test
    public void testAdd(){
        //array = new ArrayImpl<>(5);
        expected = new Integer[]{1,2,3,4,5};
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        Assert.assertArrayEquals("Данные не совпадают",expected, array.data);
    }

    @Test
    public void testRemove(){
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        expected = new Integer[]{1,3,4,5};
        array.remove(1);
        Assert.assertArrayEquals("Данные не совпадают",expected, array.data);
    }

    @Test
    public void testGet(){
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        Assert.assertEquals((Integer) 3,array.get(4));
    }

    @Test
    public void testContains(){
        array.add(1);
        array.add(2);
        Assert.assertTrue("Не верно!",array.contains(1));
    }

    @Test
    public void testIndexOf(){
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        Assert.assertEquals(3,array.indexOf(4));
    }

}
