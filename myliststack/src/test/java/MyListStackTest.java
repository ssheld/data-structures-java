import ssheld.MyListStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MyListStackTest {


    private MyListStack<Integer> stack;

    @BeforeEach
    void setup() {
        stack = new MyListStack<>();
    }

    @Test
    void getTopOfStack() {
        stack.push(3);
        stack.push(5);
        stack.push(2);


        assertEquals(2, stack.pop());
        assertEquals(5, stack.pop());
        assertEquals(1, stack.getSize());
    }

    @Test
    void getSizeAccuratelyKeepsCurrentSizeOfArrayAsItemsAreAdded() {
        stack.push(2);
        stack.push(4);

        assertEquals(2, stack.getSize());
    }

    @Test
    void isEmptySuccessfullyChecksIfArrayIsEmptyAfterAddingItems() {
        stack.push(4);
        stack.push(5);

        assertFalse(stack.isEmpty());
    }
}
