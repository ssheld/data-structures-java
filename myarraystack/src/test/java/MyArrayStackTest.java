import com.ssheld.MyArrayStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MyArrayStackTest {

    private MyArrayStack<Integer> arr;

    @BeforeEach
    void setup() {
        arr = new MyArrayStack<>();
    }

    @Test
    void getTopOfStack() {
        arr.push(3);
        arr.push(5);
        arr.push(2);


        assertEquals(2, arr.pop());
        assertEquals(5, arr.pop());
        assertEquals(1, arr.getSize());
    }

    @Test
    void clearingAllValuesFromTheArray() {
        arr.push(1);
        arr.push(5);

        arr.clear();

        assertEquals(0, arr.getSize());
    }

    @Test
    void getSizeAccuratelyKeepsCurrentSizeOfArrayAsItemsAreAdded() {
        arr.push(2);
        arr.push(4);

        assertEquals(2, arr.getSize());
    }

    @Test
    void isEmptySuccessfullyChecksIfArrayIsEmptyAfterAddingItems() {
        arr.push(4);
        arr.push(5);

        assertFalse(arr.isEmpty());
    }

    @Test
    void testResizing() {
        arr.push(2);
        arr.push(2);
        arr.push(2);
        arr.push(2);
        arr.push(2);
        arr.push(2);
        arr.push(2);
        arr.push(2);
        arr.push(2);
        arr.push(2);
        arr.push(2);


        assertEquals(11, arr.getSize());
    }

    @Test
    void testStackIterator() {
        arr.push(0);
        arr.push(1);
        arr.push(2);
        arr.push(3);
        arr.push(4);
        arr.push(5);

        int i = 5;

        for (int val: arr) {
            assertEquals(i--, val);
        }
    }
}
