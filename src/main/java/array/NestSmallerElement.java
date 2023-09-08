package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * https://www.codingninjas.com/studio/problems/next-smaller-element_1112581
 *
 * in a given array , find next smaller element of each element in that array , if found return that element otherwise -1
 *
 * @Author saurabh vaish
 * @Date 08-09-2023
 */
public class NestSmallerElement {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(2,1,4,3));
        System.out.println(nextSmallerElement(list,list.size()));
        System.out.println(nextSmallerElementOptimize(list,list.size()));
    }


    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        // Write your code here.
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            int start=i+1;
            boolean found=false;
            while(start<=n-1){
                if(arr.get(start)<arr.get(i)){
                    list.add(arr.get(start));
                    found=true;
                    break;
                }
                start++;
            }
            if(!found)list.add(-1);

        }

        return list;
    }

    static ArrayList<Integer> nextSmallerElementOptimize(ArrayList<Integer> arr, int n) {
        // Write your code here.
        ArrayList<Integer> list = new ArrayList<>();

        // stack to track elements
        Stack<Integer> st = new Stack<>();
        st.push(-1); // as for last element its always -1
        // temp array to get array out of reverse
        int temp[] = new int[n];

        // since we know next element would be always after current element so starting from end
        // will store every element which is lesser than current element
        for(int i=n-1;i>=0;i--) {       //o(n)
            while(!st.empty() && st.peek() >= arr.get(i) ) {    //O(1)
                st.pop();
            }
            temp[i]=st.peek();
            st.push(arr.get(i));
        }

//        reverse(ans.begin(),ans.end());     //O(n)
        for(int i=0;i<n;i++)list.add(temp[i]);

        return list;
    }
}
