package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Problem == Given an integer array nums, return all possible subsets (the power set). The solution set must not contain duplicate subsets.
 *             subsets can be in any order
 *             Example 1:
 *                  Input: nums = [1,2,3]
 *                  Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * @Solution == For every element in the given array or list, we have choice to either include or not include it in a subset.
 *              Powerset is the exhaustive set of subsets which contain all the possible subsets, which means,
 *              we get powerset by making all possible choices for all given elements.
 *
 *      Backtrack approach
 *              For each element nums[i] we have option to either include or exclude it from current subset and
 *              for each of these two choices for nums[i] we consider all combinations of the choice of inclusion and exclusion
 *              for the rest of the elements in given array nums[].
 *
 *              For the solution we can take the help of backtracking pseudo code template .
 *              1. if index greater than array length -1 means last index then its a termination condition and then process solution and would return from backtrack
 *              2. since we need every possible solution so we are adding every partial solution to result
 *              3. not calling generate candidate() as we are handling with index .
 *              4. loop from current index to arr.length
 *                      makeMove as to add in parital solution
 *                      backtrack to check for solution possible
 *                      undoMakeMove remove from partial solution
 *
 *
 * @author Saurabh Vaish
 * @Date 05-06-2021
 */
public class PowerSetWithBooleanArray {
    public static void main(String[] args) {
        int[] ar={1,2,3};
        if(ar.length==0)return;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] partialSolution = new boolean[ar.length];
        backtrack(0,ar,partialSolution,res);
        for (List<Integer> re:res){
            System.out.print("[");
            re.forEach(System.out::print);
            System.out.print("]");
        }
    }

    private static void backtrack(int index, int[] ar, boolean[] partialSolution, List<List<Integer>> res) {
        if(isASolution(index,ar.length-1)){
            processSolution(res,partialSolution,ar);
            return;
        }
        boolean[] candidates = generateCandidates(); // not require as we are already managing with index and we dont require any modification
        for(boolean can:candidates){
            makeMove(can,partialSolution,index);
            backtrack(index+1, ar, partialSolution, res);
            undoMakeMove(can,partialSolution,index);
        }
    }

    private static boolean isASolution(int index,int n) {
        return index>n;
    }

    private static void undoMakeMove(boolean cand, boolean[] partialSolution,int index) {
        partialSolution[index]=!partialSolution[index]; // removing the last added num
    }

    private static void makeMove(boolean cand, boolean[] partialSolution,int index) {
        partialSolution[index]=cand; // adding that num to partial solution
    }

    private static boolean[] generateCandidates() {
        return new boolean[]{true,false}; // as each one can have two possibilities either it would be subset or not
    }

    private static void processSolution(List<List<Integer>> res, boolean[] partialSolution, int[] ar) {
        List<Integer> subSet = new ArrayList<>();
        for (int i = 0; i < partialSolution.length; i++) {
            if(partialSolution[i]){
                subSet.add(ar[i]); // add those which are having true in partialSolution based on index
            }
        }
        res.add(subSet); // adding partial solution to final result
    }
}
