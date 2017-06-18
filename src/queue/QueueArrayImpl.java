package queue;

import java.util.Arrays;

/**
 *
 * @author yoyo
 */
// ******************PUBLIC OPERATIONS*********************
// void enqueue( x )      --> Insert x
// Object getFront( )     --> Return least recently inserted item
// Object dequeue( )      --> Return and remove least recent item
// boolean isEmpty( )     --> Return true if empty; else false
// boolean isFull( )      --> Return true if capacity reached
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// Overflow thrown for enqueue on full queue
public class QueueArrayImpl {

    private Object[] theArray;
    private int currentSize;
    private int front;
    private int back;
    static final int DEFAULT_CAPACITY = 10;

    public QueueArrayImpl(int capacity) {
        theArray = new Object[capacity];
        makeEmpty();
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void makeEmpty() {
        currentSize = 0;
        front = 0;
        back = -1;
    }

    public boolean isFull() {
        return currentSize == theArray.length;
    }

    public Object getFront() {
        if (isEmpty()) {
            return null;
        }
        return theArray[front];
    }

    public Object dequeue() {
        if (isEmpty()) {
            return null;
        }
       // currentSize--;

        Object frontItem = theArray[front];
        theArray[front] = null;
        front = increment(front);
      //  System.out.println("The array legth is "+);
       if (--currentSize > 0 && currentSize == theArray.length / 4) resize(theArray.length / 2);
        
        return frontItem;
    }

    private int increment(int x) {
        if (++x == theArray.length) {
            x = 0;
        }
       // System.out.println("x is " + x);
        return x;
    }
    
   private void resize(int capacity)
    {
//        Object[] tmp =  new Object[capacity];
//         System.arraycopy(theArray, 0,
//                tmp, 0, capacity);
//         theArray = tmp;
         //back = currentSize;
        theArray = Arrays.copyOf(theArray, capacity);
         
    }
   
    public void enqueue(Object x) throws Exception {
        if (isFull()) {
           // throw new Exception();
           resize(theArray.length*2);
        }

        back = increment(back);
        theArray[back] = x;
        if (back == theArray.length) back = 0;
        currentSize++;
    }

    @Override
    public String toString() {
        return java.util.Arrays.toString(theArray);
    }

    public static void main(String[] args) {
        QueueArrayImpl q = new QueueArrayImpl(2);
        try {
            for (int i = 0; i < 10; i++) {
                q.enqueue(new Integer(i));
            }
        } catch (Exception e) {
            System.out.println("Unexpected overflow");
        }
        
        System.out.println("The array elements are "+q.toString());
        
        if(!q.isEmpty())
        {
           q.dequeue();
            System.out.println("The array elements are "+q.toString());
        }
        if(!q.isEmpty())
        {
           q.dequeue();
            System.out.println("The array elements are "+q.toString());
        }
         if(!q.isEmpty())
        {
           q.dequeue();
            System.out.println("The array elements are "+q.toString());
        }
           if(!q.isEmpty())
        {
           q.dequeue();
            System.out.println("The array elements are "+q.toString());
        }
             if(!q.isEmpty())
        {
           q.dequeue();
            System.out.println("The array elements are "+q.toString());
        }
               if(!q.isEmpty())
        {
           q.dequeue();
            System.out.println("The array elements are "+q.toString());
        }
                 if(!q.isEmpty())
        {
           q.dequeue();
            System.out.println("The array elements are "+q.toString());
        }
    }

}
