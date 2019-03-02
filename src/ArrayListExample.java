import com.ssheld.MyArrayList.MyArrayList;
/**
 * Author: Stephen Sheldon 3/2/2019
 */

public class ArrayListExample {

    public static void main(String[] args){
        MyArrayList<Integer> arr = new MyArrayList<>();

        /* add some values to the array */
        arr.add(2);
        arr.add(4);

        /* Get size of array */
        System.out.println(arr.getSize());

        /* add value at specific index */
        arr.add(0, 3);

        System.out.println("added 3, new size is " + arr.getSize());

    }
}
