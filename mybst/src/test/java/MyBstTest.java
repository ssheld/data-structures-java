import com.ssheld.BST;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyBstTest {

    BST<Integer, String> myBst = new BST<>();
    @BeforeEach
    void setup() {
        myBst.put(7, "Stephen");
        myBst.put(3, "Jordan");
        myBst.put(5, "Tammy");
        myBst.put(10, "John");
        myBst.put(15, "Patricia");
        myBst.put(8, "Tom");
        myBst.put(2, "Jamie");
        myBst.put( 13, "Tiff");
    }

    @Test
    void preOrder() {
        System.out.println("PreOrder");
        myBst.preOrder();
    }

    @Test
    void inOrder() {
        System.out.println("InOrder");
        myBst.inOrder();
    }

    @Test
    void postOrder() {
        System.out.println("PostOrder");
        myBst.postOrder();
    }

    @Test
    void checkSize() {
        assertEquals(8, myBst.size());
    }

    @Test
    void checkIsEmpty() {
        assertEquals(false, myBst.isEmpty());
    }

    @Test
    void getMin() {
        assertEquals(2,  myBst.min());
    }

    @Test
    void deleteMin() {
        myBst.deleteMin();
        assertEquals(3, myBst.min());
    }

    @Test
    void getFloor() {
        assertEquals(8, myBst.floor(9));
    }

    @Test
    void getMax() {
        assertEquals(15, myBst.max());
    }

    @Test
    void getValue() {
        assertEquals("John", myBst.get(10));
    }

    @Test
    void select() {
        assertEquals(5, myBst.select(2));
    }

    @Test
    void rank() {
        assertEquals(5, myBst.rank(10));
    }

    @Test
    void delete() {
        myBst.delete(2);
        assertEquals(3, myBst.min());

        myBst.delete(7);
        assertEquals(3, myBst.min());

        System.out.println("PreOrder post-delete");
        myBst.preOrder();
    }
}
