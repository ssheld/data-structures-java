package com.ssheld.MyStack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayStackTest {

    private DynamicArrayStack<Integer> myStack;

    @BeforeEach
    void setUp() { myStack = new DynamicArrayStack<>(); }

    @Test
    void pushValueOntoStackPutsItemOnTopOfStack() {

        // action
        myStack.push(2);
        myStack.push(3);
        myStack.push(5);

        // Assert
        assertEquals(5, myStack.pop());
    }

    @Test
    void popValueFromStackGivesCorrectValue() {
        // Arrange
        myStack.push(3);

        // Action
        int value = myStack.pop();

        // Assert
        assertEquals(3, value);
    }

    @Test
    void popValueFromStackDecrementsSizeOfItemsInStack() {
        // Arrange
        myStack.push(4);
        myStack.push(2);
        myStack.push(8);

        // Action
        int value = myStack.pop();

        // Assert
        assertEquals(2, myStack.size());
    }

    @Test
    void iteratorReturnsCorrectValuesInReverseOrder() {
        // Arrange
        int i = 3;
        myStack.push(3);
        myStack.push(4);
        myStack.push(10);
        myStack.push(5);
        int[] arr = {3, 4, 10, 5};

        // Action
        for(Integer value : myStack) {
            // Assert
            assertEquals(arr[i], value);
            i--;
        }
    }

    @Test
    void sizeMethodReturnsCorrectCurrentSizeOfStack() {
        // Arrange
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        // Action
        int size = myStack.size();

        // Assert
        assertEquals(3, size);
    }
}