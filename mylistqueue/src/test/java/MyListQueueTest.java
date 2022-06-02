import com.ssheld.MyListQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MyListQueueTest {

    MyListQueue<Integer> queue;

    @BeforeEach
    void setup() {
        queue = new MyListQueue<>();
    }


    @Test
    void getEndOfQueue() {
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);


        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(1, queue.getSize());
        assertEquals(4, queue.dequeue());
    }

    @Test
    void getSizeAccuratelyKeepsCurrentSizeOfArrayAsItemsAreAdded() {
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        assertEquals(3, queue.getSize());
    }

    @Test
    void isEmptySuccessfullyChecksIfArrayIsEmptyAfterAddingItems() {
        queue.enqueue(2);
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }
}
