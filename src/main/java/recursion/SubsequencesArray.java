package recursion;

import java.util.ArrayList;
import java.util.List;

/***
 *  Problem == In a given array print all subsequences sub arrays .
 * 
 *  Subquences -- It means all possible combinations of elements in the array but with order .
 * 
 *  Time complexity == 
 *  Space complexity == 
 * 
 */
public class SubsequencesArray {
    public static void main(String[] args) {

        int[] ar = { 3, 1, 2 }; // all subsequences - {},{3},{1},{2},{3,1},{1,2},{3,2},{3,1,2}

        printSubsequences(ar, 0,new ArrayList<>());

    }

    // logic - will work on choose or reject element
    private static void printSubsequences(int[] ar, int index,List<Integer> list) {
       
        if (index ==ar.length){
            System.out.println(list);
            return;
        }
        
        list.add(ar[index]); // choosing the element
        
        // take element
        printSubsequences(ar, index + 1, list); // getting all subsequences of the array with choosing the element
        
        list.remove(list.size() - 1); // removing the last element

        // not take element
        printSubsequences(ar, index + 1, list); // getting all subsequences of the array without not using the element
   }

}