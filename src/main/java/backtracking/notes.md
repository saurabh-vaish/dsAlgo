Backtracking ===> Backtracking is based on exhaustive search technique. It is a DFS (Depth First Search) approach.
                   We do DFS on Backtracking Tree.
                  We basically systematically create all the possible configurations of a search space and
                   return the one(s) that is/are the required result.

   We will have to keep in mind that both the below scenarios must be avoided:
          1. Repetitions: Generating a configuration that has already been produced.
          2. Missing a configuration
         
 Strategic Implementation:
          Now lets talk about a very simple implementation strategy that would help design and code a backtrack solution for most of the combinatorial algorithm problems very easily.
          
          So first off, we need to know that we always work on top of a partial solution in backtrack and trying to extend the partial solution to a full solution, 
            except at the very beginning when we are just starting our search and consequently there is no partial solution.
          
          STEP 1: Check if the partial solution that we have till now is actually a full solution. then process the solution which may consist of printing the values or 
                    returning a count value in most cases. If we haven’t gotten a full solution yet then go to STEP 2.
          
          STEP 2: Construct a set of candidates which are suitable and qualify to be the next element in the solution set for extending the partial solution.
          
          STEP 3: In order to have an exhaustive search we need to iterate over all the possible candidates and in each iteration we would place the candidate being fetched by the iterator 
                    as the next element in the solution set (extending the partial solution) and after each place placement we should go to STEP 1 to check if we have gotten a full solution (basically, recurse).
          
          Let’s now see a pseudocode for better understanding of these 3 steps.


public void backtrack(int[] partialSolution, int index) {

    // first check if we have already gotten a complete solution

    if (isACompleteSolution(partialSolution, index - 1)) {

        processSolution(partialSolution, index - 1);

        return;

    }

    int[] suitableCandidates = constructCandidates(partialSolution, index);

    for (int candidate : suitableCandidates) {
        makeMove(partialSolution, index);
        backtrack(partialSolution, index + 1);
        undoMakeMove(partialSolution, index);
        if (finished) return;  // early termination
    }
}


1. isACompleteSolution() :- method checks if the elements from index 0 to (index – 1) of partialSolution array forms a complete solution,
                            if so then process partialSolution[0…(index – 1)] and return.
2. processSolution() :-    processes the solution if we have gotten one.

3. constructCandidates(partialSolution, index):-   constructs a list of all possible candidates for partialSolution[index], i.e, the element at the index ‘index’ of partialSolution array.

4. makeMove(partialSolution, index):-  puts a candidate element at partialSolution[index].

5. backtrack(…) :-    method recursively calls itself. It helps to explore all valid childNodes in backtracking tree to see if the current partialSolution could be extended to a completeSolution.

6. undoMakeMove(partialSolution, index):-  resets the value of partialSolution[index].

7. Early Termination: See how we terminate early when needed. This does not apply to all problems.
                    if (finished) return; // early termination

We won’t need the ‘finished’ flag if we want to produce all the possible solutions (like in combinations and permutations problems where we need to output all the combinations 
and permutations respectively). But if all we care about is to display only one solution (the one that we get first) just like in Sudoku, then we will need a ‘finished’ flag 
for early termination to signal that we have got a result to display so no need to proceed any further.