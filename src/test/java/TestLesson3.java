import lesson3.Dec.DecImpl;
import lesson3.queue.QueueImpl;
import lesson3.stack.StackImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestLesson3 {

    StackImpl<Integer> stack;
    QueueImpl<Integer> queue;
    DecImpl<Integer> dec;

    @Before
    public void init(){
        stack = new StackImpl<>(5);
        queue = new QueueImpl<>(5);
        dec = new DecImpl<>(5);
    }

    @Test
    public void testPushStack(){
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        Assert.assertArrayEquals(new Integer[]{1,2,3,4,5},stack.data);
    }

    @Test
    public void testInsertQueue(){
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        Assert.assertArrayEquals(new Integer[]{1,2,3,4,5},queue.data);
    }

    @Test
    public void testPopStack(){
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        Assert.assertEquals((Integer) 5,stack.pop());
    }

    @Test
    public void testRemoveQueue(){
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        Assert.assertEquals((Integer) 1,queue.remove());
    }
    @Test
    public void testPeekStack(){
        stack.push(1);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(456);
        Assert.assertEquals((Integer) 456,stack.peek());
    }

    @Test
    public void testPeekQueue(){
        queue.insert(55418);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        Assert.assertEquals((Integer) 55418,queue.peek());
    }
    @Test
    public void testInsertRightDec(){
        dec.insertRight(1);
        dec.insertRight(2);
        dec.insertRight(3);
        dec.insertRight(4);
        dec.insertRight(5);
        Assert.assertArrayEquals(new Integer[]{1,2,3,4,5},dec.data);
    }
    @Test
    public void testInsertLeftDec(){
        dec.insertLeft(1);
        dec.insertLeft(2);
        dec.insertLeft(3);
        dec.insertLeft(4);
        dec.insertLeft(5);
        Assert.assertArrayEquals(new Integer[]{5,4,3,2,1},dec.data);
    }
    @Test
    public void testPeekLeftDec(){
        dec.insertLeft(1);
        dec.insertLeft(2);
        dec.insertLeft(3);
        dec.insertLeft(4);
        dec.insertLeft(5);
        Assert.assertEquals((Integer) 5,dec.peekLeft());
    }
    @Test
    public void testPeekRightDec(){
        dec.insertLeft(1);
        dec.insertLeft(2);
        dec.insertLeft(3);
        dec.insertLeft(4);
        dec.insertLeft(5);
        Assert.assertEquals((Integer) 1,dec.peekRight());
    }
}

