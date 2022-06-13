package dpp;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Link = https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003?leftPanelTab=0
 *
 * @Problem = Ninja is planing this ‘N’ days-long training schedule. Each day, he can perform any one of these three activities. (Running, Fighting Practice or Learning New Moves).
 *            Each activity has some merit points on each day. As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days.
 *            Can you help Ninja find out the maximum merit points Ninja can earn?
 *            You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity.
 *            Your task is to calculate the maximum number of merit points that Ninja can earn.
 *
 * @Author saurabh vaish
 * @Date 15-05-2022
 */
public class NinjaTraining {
    public static void main(String[] args) {
        int n=3; // days
        int points[][] = new int[][]{{1,2,5},{3,1,1},{3,3,3}};
//        int points[][] = new int[][]{{10,40,70},{20,50,80},{30,60,90}};

        // n-1 as index starts from 0
        System.out.println(ninjaTrainingMemoization(n,n-1,points,3,new HashMap<>())); // here last 3 means we dont know the previous day choosen task
        System.out.println(ninjaTrainingTabulation(n,points)); // here last 3 means we dont know the previous day choosen task
    }

    // logic - we will calculate max choosing each taks point in a given day except last choosen task
    // time - O(n * n) // stack * loop
    // space - O(n) + O(n * 3)
    public static int ninjaTrainingMemoization(int n, int day, int points[][], int last, Map<String,Integer> map) {

        // if day is 0 then we can choose task point except previous day task
        if(day==0){
            int max=0;
            for (int task = 0; task < n; task++) {
                if(task!=last){
                    max = Math.max(max,points[0][task]); // max taks in 0th day except prev day
                }
            }
            return max;
        }

        if(map.containsKey(day+last+""))return map.get(day+last+"");

        // except 0th day
        int max=0;
        for (int task = 0; task < n; task++) {
            if (task!=last){
                // previous day point + next day point
                int point = points[day][task] + ninjaTrainingMemoization(n,day-1,points,task,map);
                max = Math.max(max,point);
            }
        }

        map.put(day+last+"",max);

        return max;

    }


//     time - O(n * 4 * 3) // stack * loop
//     space - O(4)
    public static int ninjaTrainingTabulation(int n, int points[][]) {

        // previous day taks
        int [] prev = new int[4];
        prev[0]=Math.max(points[0][1],points[0][2]);
        prev[1]=Math.max(points[0][0],points[0][2]);
        prev[2]=Math.max(points[0][0],points[0][1]);
        prev[3]=Math.max(points[0][0],Math.max(points[0][1],points[0][2])); // as for 3 we dont know the previous task before first day so max in all tasks

        // except 0th day
        int max=0;
        for (int day = 1; day < n; day++) { // day loop , from 1 as 0 already calculated
            int [] temp = new int[4];
            for (int last = 0; last <4; last++) { // how many last could be in a day, 3 fixed either 0 or 1 or 2 4th is one we dont know before the starting day
                temp[last]=0;
                for (int task = 0; task < 3; task++) {
                    if (task!=last){
                        // previous day point + next day point
                        int point = points[day][task] + prev[task];
                        temp[last] = Math.max(temp[last],point);
                    }
                }
            }
            prev = temp;
        }

        return prev[3];

    }




}
