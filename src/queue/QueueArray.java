package queue;

/**
 *
 * @author yoyo
 */
//if not <T> reve za tqh 
public class QueueArray<T> implements Queue<T> {

    private T[] arr;
    private int total, first, next;

    public QueueArray() {
        arr = (T[]) new Object[2];
    }

    private void resize(int capacity) {
        T[] tmp = (T[]) new Object[capacity];
//        for(int i = 0; i < total; i++)
//        {
//            tmp[i] = arr[]
//        }
        //int preserveLength = Math.min(total,capacity); 
        System.arraycopy(arr, 0,
                tmp, 0, capacity);
        arr = tmp;
        first = 0;
        next = total;
    }

    @Override
    public Queue<T> enqueue(T element) 
    {
        if(arr.length == total) resize(arr.length * 2);
        arr[next++] = element;
        if(next == arr.length) next = 0;
        total++;
        return this;
    }

    @Override
    public T dequeue() 
    {
        if(total == 0) throw new java.util.NoSuchElementException();
        T element = arr[first];
        arr[first] = null;
        if(++first == arr.length) first = 0;
        if(--total > 0 && total == arr.length / 4) resize(arr.length / 2);
        
   
        return element;        
    }
    
    @Override
    public String toString()
    {
        return java.util.Arrays.toString(arr);
    }
    
    public static void main(String[] args) 
    {
        QueueArray<Integer> que = new QueueArray<>();
        que.enqueue(5);
    }
}