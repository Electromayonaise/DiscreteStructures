package DiscreteStructures.Excercises.FollowUp10;
/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
 */
import java.util.Queue;
import java.util.LinkedList;
public class SearchInsertPosition {
    
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        // solve it using a queue 
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            q.offer(nums[i]);
        }
        int i = 0;
        while(!q.isEmpty()){
            if(q.peek() == target){
                return i;
            } else if(q.peek() > target){
                return i;
            } else {
                q.poll();
                i++;
            }
        }
        return i;
    }
}
