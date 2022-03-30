package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/***
 * This problem also called power set.
 *  Problem == In a given array print all subsequence sub arrays in sorted order without duplicates.
 *
 *   sol = we will work on take and not take the element , when we will take the element then will go untill array ends and will add sum in each step or step       
 *          when we are not taking the element then will ship index without adding sum
 * 
 *   Time complexity ==
 */
public class Subset {

    public static void main(String[] args) {

        int[] ar = { 1,2,2 }; // all subsequences - [[],[1],[1,2],[1,2,2],[2],[2,2]]
        Arrays.sort(ar); //  sorting the array to have duplicates in the same order
        List<List<Integer>> finalList= new ArrayList<>();
        subSetWithoutDuplicate(ar, 0, new ArrayList<>(), finalList);
        System.out.println(finalList);
    }

    /**
     * Similar to the power set problem using backtracking
     * Problem - In a given array having duplicates print all non-duplicate subsequence sub arrays in sorted order
     * Time Complexity ==
     * @param ar
     * @param index
     * @param list
     * @param finalList
     */
    private static void subSetWithoutDuplicate(int[] ar,int index,List<Integer> list,List<List<Integer>> finalList) {
        finalList.add(new ArrayList<>(list)); // adding choosen element list to final list

        for (int i = index; i < ar.length ; i++) {
            if(i!=index && ar[i]==ar[i-1])continue; // skip duplicate

            list.add(ar[i]); // choosing the element
            subSetWithoutDuplicate(ar, i+1, list, finalList); // collection all combinations
            list.remove(list.size()-1); // removing the element
        }
    }
    
}
