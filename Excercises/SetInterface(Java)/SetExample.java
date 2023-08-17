import java.util.*;

public class SetExample {
    public static void main(String args[]) {

        Set<Integer> a = new HashSet<Integer>(); // Declares a Set of Integers 

        a.addAll(Arrays.asList(new Integer[] { 1, 3, 2, 4, 8, 9, 0 })); // Adds elements to the Set as an Array
        
        Set<Integer> b = new HashSet<Integer>(); // Declares a Set of Integers

        b.addAll(Arrays.asList(new Integer[] { 1, 3, 7, 5, 4, 0, 7, 5 })); // Adds elements to the Set as an Array

        Set<Integer> union = new HashSet<Integer>(a); // Declares a Set of Integers and adds the elements of Set a to it

        union.addAll(b); // Adds the elements of Set b to the Set union

        System.out.print("Union of the two Sets"); 

        System.out.println(union); 
    }
}
