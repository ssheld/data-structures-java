package com.ssheld;

import com.ssheld.MyArrayList.MyArrayList;
import com.ssheld.MyLinkedList.MyLinkedList;

import java.util.Iterator;

/**
 * Author: Stephen Sheldon 2/24/2019
 */

public class StructureExample {

    public static void main(String[] args) {
//        MyArrayList<Integer> arr = new MyArrayList<>();
//
//        /* add some values to the array */
//        arr.add(2);
//        arr.add(4);
//
//        /* Get size of array */
//        System.out.println(arr.getSize());
//
//        /* add value at specific index */
//        arr.add(0, 3);
//
//        System.out.println("added 3, new size is " + arr.getSize());

        System.out.printf("%n%n Now testing linked list %n%n");
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>( );

        for( int i = 0; i < 10; i++ )
            myLinkedList.add( i );
        for( int i = 30; i < 40; i++ )
            myLinkedList.add( 0, i );

        System.out.println("Current Linked List size is " + myLinkedList.size());
        myLinkedList.remove( myLinkedList.size( ) - 1 );

        System.out.println("removed: " + myLinkedList.remove(0));

        Iterator<Integer> itr = myLinkedList.iterator( );
        while( itr.hasNext( ) )
        {
            itr.next( );
            itr.remove( );
            System.out.println("Removed " + myLinkedList);
        }

        System.out.println("Current size of list is " + myLinkedList.size());



    }
}
