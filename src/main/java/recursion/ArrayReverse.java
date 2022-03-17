package recursion;

/***
 *  Example of array reverse using one param and two param approach
 *  Time complexity == O(n/2)
 *  Space complexity == O(n/2)
 * 
 */
public class ArrayReverse {
    public static void main(String[] args) {

        int ar[] = { 1, 2, 3, 4, 5 };
        int ar2[] = { 1, 2, 3, 4, 5 };
        
        System.out.println("Reverse using two params ");
        reverseUsingTwoParams(0, ar.length-1, ar);
        
        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + " ");
        }
        
        System.out.println("\nReverse using one param ");

        reverseUsingOneParam(0,  ar2);
        
        for (int i = 0; i < ar2.length; i++) {
            System.out.print(ar2[i] + " ");
        }
        
        
    }

    // using two params
    private static void reverseUsingTwoParams(int left, int right, int[] ar) {
        if (left > right) {
            return;
        }
        swap(left, right, ar);
        reverseUsingTwoParams(left + 1, right - 1, ar); // in each steps we are increasing left by 1 and decreasing right by 1
    }

    
    // using one param
    private static void reverseUsingOneParam(int left, int[] arr) {
        if (left > (arr.length - left - 1) / 2) {   // if left is greater than length/2 then we are done
            return;
        }
        swap(left, arr.length - left - 1, arr);
        reverseUsingOneParam(left + 1, arr); // in each step its calling itself until base condition executed then adding result to all previous calls then returns
    }
    
    
    static void swap(int i, int j, int[] ar) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

}