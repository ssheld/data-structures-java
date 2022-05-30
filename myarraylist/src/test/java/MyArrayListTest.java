import com.ssheld.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MyArrayListTest {
    private MyArrayList<Integer> arr;

    @BeforeEach
    void setup() {
        arr = new MyArrayList<>();
    }

    @Test
    void settingSpecificIndexToAValue() {
        arr.add(3);
        arr.add(5);
        arr.add(2);

        arr.set(0, 4);

        assertEquals(4, arr.get(0));
    }

    @Test
    void addingValueToEndOfArray() {
        arr.add(2);
        assertEquals(2, arr.get(0));
    }

    @Test
    void addingValueToSpecificIndexInArray() {
        arr.add(2);
        arr.add(4);
        arr.add(7);
        arr.add(1, 11);

        assertEquals(11, arr.get(1));
    }

    @Test
    void clearingAllValuesFromTheArray() {
        arr.add(1);
        arr.add(5);

        arr.clear();

        assertEquals(0, arr.getSize());
    }

    @Test
    void getSizeAccuratelyKeepsCurrentSizeOfArrayAsItemsAreAdded() {
        arr.add(2);
        arr.add(4);

        assertEquals(2, arr.getSize());
    }

    @Test
    void isEmptySuccessfullyChecksIfArrayIsEmptyAfterAddingItems() {
        arr.add(4);
        arr.add(5);

        assertFalse(arr.isEmpty());
    }

    @Test
    void removeItemFromArrayAtSpecificIndex() {
        arr.add(4);
        arr.add(6);
        arr.add(11);

        arr.remove(0);

        assertEquals(6, arr.get(0));
    }
}
