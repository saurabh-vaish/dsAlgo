package binarysearch;

/**
 * @Problem == Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * @Solution == The square root of an integer x cannot be greater than x, and at the minimum it can be 0.
 *              SO the search space is [0, x]. So, this problem translates to "find the minimum value in the search space
 *              which is greater than square root of the given integer (x)"
 *
 *              for exact sqrt with decimal -
 *              If we are computing square root of a number x such that x < 1 then the square root can be anywhere in the range [x, 1].
 *              Example. Square root of 1/4 or 0.25 is 1/2 or 0.5.
 *              If we are computing square root of x such that x >= 1 then the square root can lie anywhere in the range [1, x].
 *
 * @Complexity == O(log2x) for Integer one ,
 *
 * @author Saurabh Vaish
 * @Date 02-06-2021
 */
public class SquarerootOfPositiveInteger {
    public static void main(String[] args) {
        getSqrtInteger(0);
        getSqrtInteger(1);
        getSqrtInteger(2);
        getSqrtInteger(8);
        getSqrtInteger(5);
        getSqrtInteger(16);
        getSqrtInteger(64);

        getSqrtReal(0);
        getSqrtReal(1);
        getSqrtReal(2);
        getSqrtReal(8);
        getSqrtReal(5);
        getSqrtReal(16);
        getSqrtReal(64);
        getSqrtReal(0.24);
        getSqrtReal(0.04);
    }

    private static void getSqrtInteger(int n) {
        if(n==0 || n==1){       // sqrt of 0 & 1 is always n
            System.out.println("sqrt of number = "+n);
            return;
        }
        long left=0;
        long right=n;
        while(left<right){
           long mid=(left+right)/2;
            long sqrt=mid*mid;
            if(sqrt>n)right=mid;    // if sqrt is greater than we will search in left
            else left=mid+1;
        }
        System.out.println("sqrt of number "+n+" = "+(left-1));
    }


    private static final double TOLERANCE = 0.000001;
    private enum Ordering { SMALLER, EQUAL, GREATER}

    private static void getSqrtReal(double n) {
        double left,right;
        if(n==0 || n==1){       // sqrt of 0 & 1 is always n
            System.out.println("exact sqrt of number "+n+" = "+n);
            return;
        }
        if(n<1.0){
            left=n;
            right=1.0;
        }else{
            left=1.0;
            right=n+1;
        }

        while (compare(left,right)==Ordering.SMALLER){
            double mid = (left+right)/2;
//            double mid = left + (right - left) * 5;
            double sqrt=mid*mid;
            if(compare(sqrt, n)==Ordering.GREATER)right=mid;
            else left=mid; // not left = mid + 1 because the answer may in between mid and mid + 1
        }

        System.out.println("exact sqrt of number "+n+" = "+(left));
    }

    private static Ordering compare(double left, double right) {
        double diff=(left-right);
        return diff<-TOLERANCE?Ordering.SMALLER
                :diff>TOLERANCE?Ordering.GREATER:Ordering.EQUAL;
    }

}
