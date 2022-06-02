import ssheld.MyListStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MyListStackTest {


    private MyListStack<Integer> arr;

    @BeforeEach
    void setup() {
        arr = new MyListStack<>();
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
}
