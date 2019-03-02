import com.ssheld.MyLinkedList.MyLinkedList;

import java.util.Iterator;

/**
 * Author: Stephen Sheldon 3/2/2019
 */

public class LinkedListExample {
    public static void main(String[] args) {

        System.out.printf("%n%n Now testing linked list %n%n");
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>( );

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
