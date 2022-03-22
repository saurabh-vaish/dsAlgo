package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 *  Problem == Print all sub arrays in array whose sum is equal to given sum . 
 *              1. We can choose an element any number of time 
 *              2. we can take one element at a time
 * 
 *  Sol == we will take element and repeat and mathch with target if sum is equal to target then take that combination of reject
 * 
 * Time complexity == (2^t) * k
 * 
 */
public class CombinationSum {

    private static  int count=0;

    public static void main(String[] args) {

        // int[] ar = { 2, 3, 4, 8, 7 };
        int[] ar = { 10,1,2,7,6,1,5};
        int target = 8;

        List<List<Integer>> result = new ArrayList<>();

        combinationSumRepeatedElement(ar, target, 0, new ArrayList<>(), result);

        System.out.println("combination sum by taking repeated elements == ");
        result.forEach(System.out::println);
        System.out.println("count = " + count);
        
        count = 0;
        List<List<Integer>> result2 = new ArrayList<>();
        combinationSumSingleElement(ar, target, 0, new ArrayList<>(), result2);
        
        System.out.println("combination sum by taking non repeated elements == ");
        result2.forEach(System.out::println);
        System.out.println("count = " + count);
        
        count = 0;
        Set<List<Integer>> result3 = new HashSet<>();
        combinationSumWithoutDeuplicates(ar, target, 0, new ArrayList<>(), result3);
        
        System.out.println("combination sum by taking non repeated elements without duplicate combinations == ");
        result3.forEach(System.out::println);
        System.out.println("count = " + count);
        
        count = 0;
        List<List<Integer>> result4 = new ArrayList<>();
        Arrays.sort(ar); // sorting array first to avoid duplicate combination
        combinationSumWithoutDeuplicatesOptimized(ar, target, 0, new ArrayList<>(), result4);
        
        System.out.println("combination sum by taking non repeated elements without duplicate combinations Optimized == ");
        result4.forEach(System.out::println);
        System.out.println("count = " + count);
    }

    

    /**
     * Problem 1 == program for getting the sub arrays having sum is equal to target but can take one element multiple times
     * 
     * complexity = (2^t) * k
     * 
     * @link https://leetcode.com/problems/combination-sum/
     * @param ar
     * @param target
     * @param index
     * @param temp
     * @param result
     */
    private static void combinationSumRepeatedElement(int[] ar, int target, int index, List<Integer> temp,
            List<List<Integer>> result) {
        count++;
        // base condition
        if (index == ar.length) {
            // if (target == 0) { // combination found
            //     result.add(new ArrayList<>(temp));
            // }
            return;
        }
        if (target == 0) { // combination found
            result.add(new ArrayList<>(temp));
            return;
        }

        if (ar[index] <= target) { // if taken element is greater than target then choose and process or reject
            int el = ar[index];
            temp.add(el); // choose
            combinationSumRepeatedElement(ar, target - el, index, temp, result); // if taken then reduce target 
            temp.remove(temp.size() - 1); // reject
        }

        // reject element
        combinationSumRepeatedElement(ar, target, index + 1, temp, result);

    }
    
    
    /**
     * Problem2 == program for getting the sub arrays having sum is equal to target but can take one element at a time but can have same combination multiple times
     * 
     * complexity = (2^t) * k
     * 
     * @param ar
     * @param target
     * @param index
     * @param temp
     * @param result
     */
    private static void combinationSumSingleElement(int[] ar, int target, int index, List<Integer> temp,
            List<List<Integer>> result) {
        count++;
        // base condition
        if (index == ar.length) {
            if (target == 0) { // combination found
                result.add(new ArrayList<>(temp));
            }
            return;
        }

        if (ar[index] <= target) { // if taken element is greater than target then choose and process or reject
            int el = ar[index];
            temp.add(el); // choose
            // reject element and choose next
            combinationSumSingleElement(ar, target - el, index + 1, temp, result);
            temp.remove(temp.size() - 1); // reject
        }
        combinationSumSingleElement(ar, target, index + 1, temp, result);

    }
    


    
    /**
     *Problem 3 == program for getting the sub arrays having sum is equal to target but can take one element at a time but without duplicate and duplicate combination
     * 
     * not good , check approach 2 
     * 
     * complexity = (2^t) * k(logn)
     * 
     * @link https://leetcode.com/problems/combination-sum-ii/
     * 
     * @param ar
     * @param target
     * @param index
     * @param temp
     * @param result
     */
    private static void combinationSumWithoutDeuplicates(int[] ar, int target, int index, List<Integer> temp,
            Set<List<Integer>> result) {
        count++;
        // base condition
        if (index == ar.length) {
            if (target == 0) { // combination found
                List<Integer> re = new ArrayList<>(temp);
                Collections.sort(re);
                result.add(re);
            }
            return;
        }

        if (ar[index] <= target) { // if taken element is greater than target then choose and process or reject
            int el = ar[index];
            temp.add(el); // choose
            // reject element and choose next
            combinationSumWithoutDeuplicates(ar, target - el, index + 1, temp, result);
            temp.remove(temp.size() - 1); // reject
        }
        combinationSumWithoutDeuplicates(ar, target, index + 1, temp, result);

    }
    


    /**
     *Problem 3 == program for getting the sub arrays having sum is equal to target but can take one element at a time but without duplicate and duplicate combination
     * 
     * complexity = (2^t) * k
     * 
     * @link https://leetcode.com/problems/combination-sum-ii/
     * 
     * @param ar
     * @param target
     * @param index
     * @param temp
     * @param result
     */
    private static void combinationSumWithoutDeuplicatesOptimized(int[] ar, int target, int index, List<Integer> temp,
            List<List<Integer>> result) {
        count++;
        // base condition
        if (target == 0) { // combination found
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < ar.length; i++) {
            int el = ar[i];
            if (el > target) {
                break;
            }
            if (i > index && el == ar[i - 1]) { // if current element is equal to previous element then skip 
                continue;
            }

            temp.add(el); // choose
            combinationSumWithoutDeuplicatesOptimized(ar, target - el, i + 1, temp, result); // here index is used to choose element and i is being used to select next element
            temp.remove(temp.size() - 1); // reject
        }

    }


}
