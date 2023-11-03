package DiscreteStructures.Excercises.FollowUp10;
/**
 * Given an integer x, return true if x is a 
palindrome
, and false otherwise.

 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:

-231 <= x <= 231 - 1
 

Follow up: Could you solve it without converting the integer to a string?
 */

import java.util.Hashtable;
public class PalindromeNumber {
    // solve it using other data structures
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        // do it using a HASH TABLE
        if(x < 0){
            return false;
        }
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        int i = 0;
        while(x > 0){
            ht.put(i, x % 10);
            x /= 10;
            i++;
        }
        int j = 0;
        while(j < i){
            if(ht.get(j) != ht.get(i - 1 - j)){
                return false;
            }
            j++;
        }
        return true;
    }
}
