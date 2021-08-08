package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Problem == Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string. Return a list of all possible strings we could create.
 *              You can return the output in any order.
 *
 *              Example 1:
 *                  Input: S = "a1b2"
 *                  Output: ["a1b2","a1B2","A1b2","A1B2"]
 *
 * @Solution == For the solution we can take the help of backtracking phsuedo code tempate .
 *              1. First we will convert the string to char array as we need to check for each char .
 *              2. Since we can't transform to numbers so we will just return the digit . [ early check condition ]
 *              3. if char index greater than array length then its a termination condition and then process solution and would return from backtrack
 *              4. will form a candidates for next step as every char can be either lowercase or upppercase [ in case of alphabate ] or digit [ in case of numbers]
 *              5. loop of these possible candidates and-
 *                      makeMove as to add in parital solution
 *                      backtrack to check for solution possible
 *                      undoMakeMove remove from partial solution
 *
 *
 * @author Saurabh Vaish
 * @Date 05-06-2021
 */
public class LetterCasePermutation {

    public static void main(String[] args) {
        String str="a1b2";
        if(str==null || str.isEmpty())return;
        char[] ch = str.toCharArray();
        List<String> res = new ArrayList<>();
        StringBuilder partialSolution = new StringBuilder();

        backtrack(0,ch,partialSolution,res);
        res.forEach(System.out::println);
    }

    private static void backtrack(int charIndex, char[] ch, StringBuilder partialSolution, List<String> res) {
        if(charIndex==ch.length){
            processSolution(res,partialSolution);
            return;
        }
        char[] candidates = generateCandidates(charIndex,ch);
        for(char cand:candidates){
            makeMove(cand,partialSolution);
            backtrack(charIndex+1, ch, partialSolution, res);
            undoMakeMove(cand,partialSolution);
        }
    }

    private static void undoMakeMove(char cand, StringBuilder partialSolution) {
        partialSolution.setLength(partialSolution.length()-1); // terminating the last added char
    }

    private static void makeMove(char cand, StringBuilder partialSolution) {
        partialSolution.append(cand); // adding that char to partial solution
    }

    private static char[] generateCandidates(int charIndex, char[] ch) {
        // as we can't trasform digit , only char can be lower or upper case ,
        // so every char have 2 posibilities - lower or uppercase
        return Character.isDigit(ch[charIndex])?new char[]{ch[charIndex]}:new char[]{Character.toLowerCase(ch[charIndex]),Character.toUpperCase(ch[charIndex])};
    }

    private static void processSolution(List<String> res, StringBuilder partialSolution) {
        res.add(partialSolution.toString()); // adding partial solution to final result
    }
}
