import com.ssheld.MaxPQ;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyPQTest {

    // Create maxPQ of size 10
    MaxPQ<Integer> myPQ = new MaxPQ<>(12);

    @BeforeEach
    void setup() {
        myPQ.insert(2);
        myPQ.insert(10);
        myPQ.insert(4);
        myPQ.insert(9);
        myPQ.insert(3);
        myPQ.insert(4);
        myPQ.insert(19);
        myPQ.insert(40);
        myPQ.insert(23);
        myPQ.insert(71);
    }

    @Test
    void getMax() {
        assertEquals(71, myPQ.deleteMax());
        assertEquals(40, myPQ.deleteMax());
        assertEquals(23, myPQ.deleteMax());
    }

    @Test
    void getSize() {
        assertEquals(10, myPQ.size());
    }

    @Test
    void isEmpty() {
        assertEquals(false, myPQ.isEmpty());
    }

    @Test
    void insert() {
        myPQ.insert(45);
        myPQ.insert(39);

        assertEquals(71, myPQ.deleteMax());
        assertEquals(45, myPQ.deleteMax());
        assertEquals(40, myPQ.deleteMax());
        assertEquals(39, myPQ.deleteMax());
    }

}
