
package queue;

/**
 *
 * @author yoyo
 */
public interface Queue<T> 
{
    Queue<T> enqueue(T element);
    T dequeue();
        
}
