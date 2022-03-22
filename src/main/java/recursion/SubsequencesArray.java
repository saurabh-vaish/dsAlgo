package recursion;

import java.util.ArrayList;
import java.util.List;

/***
 *  Problem == In a given array print all subsequences sub arrays .
 * 
 *  Subquences -- It means all possible combinations of elements in the array but with order .
 * 
 *  Time complexity == 2^n
 *  Space complexity == 
 * 
 */
public class SubsequencesArray {
    public static void main(String[] args) {

        int[] ar = { 3, 1, 2 }; // all subsequences - {},{3},{1},{2},{3,1},{1,2},{3,2},{3,1,2}

        printSubsequences(ar, 0, new ArrayList<>());

        System.out.println("all subsequnces whose sum equal to 3 == ");

        printAllSubsequencesEqualSum(ar, 0, new ArrayList<>(), 3);

        System.out.println("any subsequnce whose sum equal to 3 == ");
        
        printAnyOneSubsequencesEqualSum(ar, 0, new ArrayList<>(), 3, 0);
        
        System.out.print("count all subsequnces whose sum equal to 3 == ");
        
        int count1 = countAllSubsequencesEqualSum(ar, 0, new ArrayList<>(), 3, 0);
        System.out.println(count1);
        
        System.out.print("count all subsequnces whose sum equal to 3 approach 2== ");

        int count2 = countAllSubsequencesEqualSumApproach2(ar, 0, 3, 0);
        System.out.println(count2);

    }

    /***
    *  Problem == In a given array print all subsequence sub arrays 
   *    
   *    sol = we will take one element and get all element by not taking that element then get all elements by not taking that element
   * 
   *   Time complexity == O(n)
     * @param ar
     * @param index
     * @param list
     */
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


   /***
    *  Problem == In a given array print all subsequence sub arrays whose sum is equal to given sum
   *    
   *    sol = we will take one element and check if the sum of the elements is equal to given sum then get all element by not taking that element
   *        if sum is equal to given sum then print the elements
   * 
   *   Time complexity == O(n)
    * @param ar
    * @param index
    * @param list
    * @param sum
    */
   private static void printAllSubsequencesEqualSum(int[] ar, int index, List<Integer> list, int sum) {

       //base condition
       if (index == ar.length) {
           int total = list.stream().reduce(0, (i, j) -> i + j); // getting sum of the elements 
           if (total == sum) { // checking total with given sum if yes then print
               System.out.println(list);
           }
           return;
       }

       list.add(ar[index]); // taking the elements of the array

       printAllSubsequencesEqualSum(ar, index + 1, list, sum); // getting all subsequences of the array

       list.remove(list.size() - 1); // removing the last added element , not taking the element

       printAllSubsequencesEqualSum(ar, index + 1, list, sum); // getting all subsequences of the array

   }
   
   /**
   *  Problem == In a given array print any one subsequence sub arrays whose sum is equal to given sum
   *    
   *    sol = we will take one element and check if the sum of the elements is equal to given sum then get all element by not taking that element
   *        if sum is equal to given sum then return true and will skip further checking
   * 
   *   Time complexity == O(n)
   * @param ar
   * @param index
   * @param list
   * @param sum
   * @param total
   * @return
   */
   private static boolean printAnyOneSubsequencesEqualSum(int[] ar, int index, List<Integer> list, int sum, int total) {

       //base condition
       if (index == ar.length) {
           //    int total = list.stream().reduce(0, (i, j) -> i + j); // getting sum of the elements   // here we are using total from every step
           if (total == sum) { // checking total with given sum if yes then print
               System.out.println(list);
               return true;
           }
           return false;
       }

       list.add(ar[index]); // taking the elements of the array
       total += ar[index]; // getting total 

       if (printAnyOneSubsequencesEqualSum(ar, index + 1, list, sum, total) == true) { // getting all subsequences of the array
           return true;
       }

       list.remove(list.size() - 1); // removing the last added element , not taking the element
       total -= ar[index]; // removing total

       if (printAnyOneSubsequencesEqualSum(ar, index + 1, list, sum, total) == true) { // getting all subsequences of the array
           return true;
       }

       return false;

   }

/**
    *  Problem == In a given array print any one subsequence sub arrays whose sum is equal to given sum
   *    
   *    sol = we will take one element and check if the sum of the elements is equal to given sum then increase count and return that count
   * 
   *   Time complexity == O(n)
    * @param ar
    * @param index
    * @param list
    * @param sum
    * @param count
    * @return
    */
   
private static int countAllSubsequencesEqualSum(int[] ar, int index, List<Integer> list, int sum, int count) {

    //base condition
    if (index == ar.length) {
        int total = list.stream().reduce(0, (i, j) -> i + j); // getting sum of the elements 
        if (total == sum) { // checking total with given sum if yes then increase count
            count++;
        }
        return count;
    }

    list.add(ar[index]); // taking the elements of the array

    count = countAllSubsequencesEqualSum(ar, index + 1, list, sum, count); // getting all subsequences of the array

    list.remove(list.size() - 1); // removing the last added element , not taking the element

    count = countAllSubsequencesEqualSum(ar, index + 1, list, sum, count); // getting all subsequences of the array

    return count;
}
    

/**
    *  Problem == In a given array print any one subsequence sub arrays whose sum is equal to given sum
   *    
   *    sol = we will take one element and check if the sum of the elements is equal to given sum then return 1 or 0 then add all sum in last and return
   * 
   *   Time complexity == O(n)
    * @param ar
    * @param index
    * @param list
    * @param sum
    * @param count
    * @return
    */
   
    private static int countAllSubsequencesEqualSumApproach2(int[] ar, int index, int sum,int total) {

        //base condition
        if (index == ar.length) {
            if (total == sum) { // checking total with given sum if yes then return 1
                return 1;
            }
            return 0;
        }
        if(total>sum)return 0;
        
        total +=ar[index]; // getting total by taking the element
 
        int l = countAllSubsequencesEqualSumApproach2(ar, index + 1, sum,total); // getting all subsequences of the array
 
        total -=ar[index]; // removing total by not taking the element
        
        int r = countAllSubsequencesEqualSumApproach2(ar, index + 1, sum,total); // getting all subsequences of the array
 
        return l + r;
    }



}