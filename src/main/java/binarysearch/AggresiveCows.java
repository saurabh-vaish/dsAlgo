package binarysearch;

import java.util.Arrays;

/**
 * @Link = https://www.codingninjas.com/studio/problems/aggressive-cows_1082559?leftPanelTab=3
 *
 * You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible.
 *
 * @Author saurabh vaish
 * @Date 08-07-2023
 */
public class AggresiveCows {

    public static int aggressiveCowsBrute(int [] st,int k){
        Arrays.sort(st);

        int d=0;
        int maxPossible = st[st.length-1]-st[0];  // max distance for any cow is distance btw max and min

        for(int i=1;i<=maxPossible;i++){

            if(canPlace(st,k,i))d=i;
            else return i-1;
        }
        return d;
    }

    private static boolean canPlace(int[] st, int k, int triedDistance) {

        int cntcows = 1;
        int lastPlace = st[0]; // on first place

        for(int i=1;i<st.length;i++){
            if(st[i]-lastPlace>=triedDistance){
                cntcows++;
                lastPlace = st[i];
            }
            if( cntcows>=k)return true;
        }

        return false;
    }


    public static int aggressiveCows(int [] arr, int k) {
        //    Write your code here.

        Arrays.sort(arr);

        int low=1; int high = arr[arr.length-1]-arr[0];

        int ans=0;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(canPlace(arr,k,mid)){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int [] ar = {0,3, 4, 7, 10, 9};

        System.out.println(aggressiveCowsBrute(ar,4));
        System.out.println(aggressiveCows(ar,4));
    }
}
