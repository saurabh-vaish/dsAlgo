package binarysearch;

import java.util.ArrayList;

/**
 *
 * @Link = https://www.codingninjas.com/studio/problems/find-peak-element_1081482
 *
 * findig peak element , an element which is greater than its prev and next elements,
 *  there can be multiple peak elements  , and all boundry elements are peak elements as we can consider outside boundary there is -infinity , if they satisfies peak condition
 *
 *  we can use binary search to find peak element
 *
 * @Author saurabh vaish
 * @Date 29-06-2023
 */
public class PeakElement {

    // complexity - O(log n)
    public static int findPeakElement(ArrayList<Integer> arr) {
        // Write your code here.
        if(arr.size()==1)return 0; // if only one element hten that will be the peak

        if(arr.get(0)>arr.get(1)) return 0; // check left boundry , if its greater than next elem then its peak , assuming before boundry if -infinity

        // check right boundry , if its greater than prev elem then its peak , assuming after boundry if -infinity
        if(arr.get(arr.size()-1)>arr.get(arr.size()-2))return arr.size()-1;

        int low=1, high=arr.size()-2 ; // as already checked for boundry

        while(low<=high){
            int mid = low+(high-low)/2;

            if(arr.get(mid-1)<arr.get(mid) && arr.get(mid)>arr.get(mid+1))return mid;
            else if(arr.get(mid)>arr.get(mid-1)){ // peak elemn is after mid ,mid is in raising graph
                low=mid+1;
            }
            else if(arr.get(mid)>arr.get(mid+1)){ // peak elemn is before mid ,mid is in traling graph
                high=mid-1;
            }else{
                low=mid+1; // to prevent infine loop
            }
        }

        return -1;
    }
}
