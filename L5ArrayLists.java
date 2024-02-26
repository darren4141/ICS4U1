import java.util.ArrayList;

/*
 * Helpful ArrayList class methods:
 * .clear() --> removes all elements
 * .set(int index, Object element) --> replaces element at given index
 * .contains(Object element) --> returns boolean if array contains element
 * .indexOf(Object element) --> returns index of first occurance of element, returns -1 if it doesn't show up
 * .isEmpty() --> returns a boolean if ArrayList is empty
 * .size() --> returns the number of elements in the list
 * .remove(int index) --> removes element at given index
 * .remove(Object element) --> removes first occurance of element found in the list
 */

public class L5ArrayLists {
        public static void main(String[] args){
        ArrayList<String> listTest = new ArrayList<String>();
    
        listTest.add("Item 1");
        listTest.add("Item 2");
        listTest.add("Item 3");

        for(String v : listTest){
            System.out.println(v);
        }

        for(int i = 0; i < listTest.size(); i++){
            System.out.println(listTest.get(i));
        }

        ArrayList<Integer> listNums = new ArrayList<Integer>(25);

        System.out.println("Size of listNums = " + listNums.size());

        for(int i = 0; i < 5; i++){
            listNums.add(i, (int)Math.pow(Math.random() * 10, 3));
        }

        System.out.println("Size of listNums = " + listNums.size());
        System.out.println(listNums);

    }
}
