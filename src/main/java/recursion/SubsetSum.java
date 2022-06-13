package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/***
 *  Problem == In a given array print the sum of  all subsequence sub arrays in sorted order
 *    
 *   sol = we will work on take and not take the element , when we will take the element then will go untill array ends and will add sum in each step or step       
 *          when we are not taking the element then will ship index without adding sum
 * 
 *   Time complexity == O(n)
 */
public class SubsetSum {

    public static void main(String[] args) {

        int[] ar = { 3, 1, 2 }; // all subsequences - {},{3},{1},{2},{3,1},{1,2},{3,2},{3,1,2}
        List<Integer> sum = new ArrayList<>();
        subsetSum(ar, 0, 0, sum);
        Collections.sort(sum);
        System.out.println(sum);
    }

    /**
     * Problem 1- In a given array print the sum of  all subsequence sub arrays in sorted order
     * Time Complexity == O(n)
     * @param ar
     * @param index
     * @param sum
     * @param total
     */
    private static void subsetSum(int[] ar, int index, int sum, List<Integer> total) {
        if (index == ar.length) {
            total.add(sum);
            return;
        }

        // taking the element
        subsetSum(ar, index + 1, sum + ar[index], total);

        // reject the element
        subsetSum(ar, index + 1, sum, total);
    }


}
