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
 * @Solution == The solution called Lexicographical Order .
 *              Lexicographic Order means sorted order and is often the most natural way to generate combinatorial objects.
 *              The power set for [1, 2, 3] in lexicographic order are [ [], [1], [1,2], [1,2,3], [1,3], [2], [2,3], [3] ].
 *
 *              Let's rearrange the output a bit to be able to see any pattern present there.
 *              [1]      [2]   [3]  []
 *              [1,2]    [2,3]
 *              [1,2,3]
 *              [1,3]
 *
 *              so the larger subset is the set itself and smaller is [].
 *
 *              For a given array nums[] of length n, we have subsets starting with nums[i] for all i = 0 to (n - 1).
 *              We get subsets starting with nums[i] by computing all subsets for nums[(i + 1)...(n - 1)] and then prepending nums[i] to each of them.
 *              We get the Power Set by computing all subsets for all nums[i], i = 0 to (n - 1).
 *
 *              For example, if input = [1, 2, 3] we can do below:
 *              When we are at index = 0:
 *              Power Set of [2, 3] is [[2], [3], [2, 3], []].
 *              Now we prepend i to each of it => [[1, 2], [1, 3], [1, 2, 3], [1]]
 *
 *              When we are at index = 1: Powerset of [3] is [[], [3]]
 *              Prepending 2 we get => [[2], [2, 3]]
 *
 *              When we are at index = 2:
 *              Powerset = [3] since index = 2 is the right most index.
 *
 *              Overall Powerset = [[1, 2], [1, 3], [1, 2, 3], [1], [2], [2, 3], [3], []]
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
public class PowerSet {
    public static void main(String[] args) {
        int[] ar={1,2,3};
//        int[] ar={1,2,3,4,5};
//        int[] ar={0};
        if(ar.length==0)return;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> partialSolution = new ArrayList<>();
        backtrack(0,ar,partialSolution,res);
        for (List<Integer> re:res){
            System.out.print("[");
            re.forEach(System.out::print);
            System.out.print("]");
        }
    }

    private static void backtrack(int index, int[] ar, List<Integer> partialSolution, List<List<Integer>> res) {
        if(index>ar.length-1){
            processSolution(res,partialSolution);
            return;
        }
        if (isASolution(index)) {  // checking if getting any solution then process
            processSolution(res,partialSolution);
        }
//        int[] candidates = generateCandidates(index,ar); not require as we are already managing with index and we dont require any modification
        for(int i=index;i< ar.length;i++){
            makeMove(ar[i],partialSolution);
            backtrack(i+1, ar, partialSolution, res);
            undoMakeMove(ar[i],partialSolution);
        }
    }

    private static boolean isASolution(int index) {
        return true;
        // always return true since we are printing powerset we print all the partial solutions.
        // In short, every partial solution is a solution for power set.
        // For this particular problem we do not need to do this check
        // but I am keeping this method to conform to our template.
    }

    private static void undoMakeMove(int cand, List<Integer> partialSolution) {
        partialSolution.remove(Integer.valueOf(cand)); // removing the last added num
    }

    private static void makeMove(int cand, List<Integer> partialSolution) {
        partialSolution.add(cand); // adding that num to partial solution
    }

//    private static int[] generateCandidates(int charIndex, int[] ch) {
//    }

    private static void processSolution(List<List<Integer>> res, List<Integer> partialSolution) {
        res.add(new ArrayList<>(partialSolution)); // adding partial solution to final result
    }
}
