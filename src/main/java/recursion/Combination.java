package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *  get all combination in char array
 *
 *  no of combinations = paw(2,n)
 *
 *  @Complexity  - Time = ar.length time recursive call * comp sol length
 *
 * @Solution  =
 *
 *  input = [b,c]
 *  1. call comb
 *      first = b
 *      sol = call comb
 *                    ----> first = c
 *                          sol = call comb
 *                                      ----> list empty return empty list , sol = [[]]
 *                          for each sol ->
 *                                  s = []
 *                                  temp add [] , temp add first c
 *                                  partial add temp  , partial = [c]
 *                                  complete add partial , com = [c]
 *
 *                          return complete sol = [[],[c]]
 *
 *       ---->  sol = [[],[c]]
 *              for each sol ->
 *                       s = []
 *                       temp add [] , temp add first b
 *                       partial add temp  , partial = [b]
 *                       s = [c]
 *                       temp add [c] , temp add first b
 *                       partial add temp  , partial = [c,b]
 *
 *                       complete add partial , com = [[],[c],[b],[c,b]]
 *
 *      -----> return final ans as complete sol
 *
 *
 * @author Saurabh Vaish
 * @Date 18-07-2021
 */
public class Combination {
    public static void main(String[] args) {
        char ar[] = {'a','b','c'};
//        char ar[] = {'b','c'};
        List<List<Character>> sol = new ArrayList<>();
        sol = comb(ar,sol,0);
        System.out.println("recursive solution == ");
        System.out.println(sol);

//        System.out.println("backtrack solution == ");
//        List<List<Character>> completeSol = new ArrayList<>();
//        combBackTrack(ar, completeSol, new ArrayList<>(), 0);
//        System.out.println(completeSol);
    }

    private static List<List<Character>> comb(char[] ar, List<List<Character>> completeSol, int index) {
        if(ar.length==0 || ar.length==index) {
            completeSol.add(new ArrayList<>()); // adding empty list
            return completeSol;
        }
        char first = ar[index]; // getting first elem

        List<List<Character>> sol = comb(ar, completeSol, index+1);

        List<List<Character>> partialSol = new ArrayList<>();

        sol.forEach(s->{
            List<Character> temp = new ArrayList<>(); // creating temp list
            temp.addAll(s);     // adding all elem from result
            temp.add(first);    // adding fist element of each stack call
            partialSol.add(temp);   // adding temp list to sol
        });

        completeSol.addAll(partialSol);  // adding in complete sol
        return completeSol;
    }


//    // using backtracking
//
//    private static void combBackTrack(char[] ar, List<List<Character>> completeSol,List<Character> partialSol, int index) {
//        if(isCompleteSolution(ar, index)) {
//            processSolution(completeSol, partialSol);
//            return;
//        }
//
//        processSolution(completeSol,partialSol);
//
//        for (int i = index; i < ar.length; i++) {
//            makeMove(ar[i],partialSol);
//            combBackTrack(ar,completeSol,partialSol, index+1);
//            undoMakeMove(ar[i],partialSol);
//        }
//    }
//
//    private static boolean isCompleteSolution(char[] ar, int index) {
//        return ar.length == 0 || index > ar.length-1;
//    }
//
//    private static void processSolution(List<List<Character>> completeSol, List<Character> partialSol) {
//        if(!completeSol.contains(partialSol))
//        completeSol.add(new ArrayList<>(partialSol));
//    }
//
//    private static void makeMove(char c, List<Character> partialSol) {
//        if(!partialSol.contains(c))
//            partialSol.add(c);
//    }
//
//    private static void undoMakeMove(char c, List<Character> partialSol) {
//        partialSol.remove(Character.valueOf(c));
//    }

}

