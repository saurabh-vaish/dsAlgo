package array;

import java.util.*;

/**
 * @Link  = https://leetcode.com/problems/high-five/
 *
 * @Problem == Given a list of the scores of different students, items, where items{i} = {IDi, scorei} represents one score from a student with IDi, calculate each student’s top five average.
 *
 * @Author saurabh vaish
 * @Date 15-08-2022
 */
public class AverageSumHighFive {

    public static void main(String[] args) {
        int [][] marks = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        Arrays.stream(usingMapAverageOfAll(marks)).forEach(s->System.out.println(Arrays.toString(s)));

        Arrays.stream(usingMapAverageTopFive(marks)).forEach(s->System.out.println(Arrays.toString(s)));
    }

    // Time - O(NlogN)
//    private static int [][] usingMapAverageTopFiveUsingQueue(int [][] marks){
//        Map<Integer, Queue<Integer>> map = new HashMap<>(); // taking map of int and priority queue
//
//        for (int i = 0; i < marks.length; i++) {
//            int [] m = marks[i];
//            Queue<Integer> queue = map.get(m[0]);
//            if(queue==null){
//                queue = new PriorityQueue<>((a,b)->b-a);
//                map.put(m[0], queue);
//            }
//            queue.offer(m[1]);
//            if(queue.size()>5){
//                queue.poll(); // removing the element
//            }
//        }
//        int [][] ans = new int[map.size()][2];
//        int i=0;
//        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
//            Integer k = entry.getKey();
//            PriorityQueue<Integer> value = entry.getValue();
//            int sum=0;
//            int j=0;
//            while (!value.isEmpty()){
//                sum+=value.poll();
//            }
//            ans[i][0] = k;
//            ans[i][1] = sum/5;
//            i++;
//        }
//        return ans;
//    }


    // Time - O(NlogN)
    // Priority queue inserts the element in sorted order [ ascending ]
    // but when try to print then it will not show in sorted order as toString() is from collections that dont know about sorting
    // poll() it removes the least element from list
    private static int [][] usingMapAverageTopFive(int [][] marks){
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>(); // taking map of int and priority queue

        for (int i = 0; i < marks.length; i++) {
            int [] m = marks[i];
            PriorityQueue<Integer> queue = map.get(m[0]);
            if(queue==null){
                queue = new PriorityQueue<>((a,b)->b-a); // define comparator to store in descending order
                map.put(m[0], queue);
            }
            queue.offer(m[1]);
        }
        int [][] ans = new int[map.size()][2];
        int i=0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            Integer k = entry.getKey();
            PriorityQueue<Integer> value = entry.getValue();
            int sum=0;
            int j=0;
            while (j++<5 &&!value.isEmpty()){ // get only top 5
                sum+=value.poll();
            }
            ans[i][0] = k;
            ans[i][1] = sum/5;
            i++;
        }
        return ans;
    }


    // complexity == O(nlogn) , space = O(n)
    private static int [][] usingMapAverageOfAll(int [][] marks){
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < marks.length; i++) {
            int [] m = marks[i];
            if(map.containsKey(m[0])){
                map.get(m[0]).add(m[1]);
            }else{
                map.put(m[0], new ArrayList<>(m[1]));
            }
        }
        int [][] ans = new int[map.size()][];
        int i=0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            ans[i]=new int[2];
            Integer k = entry.getKey();
            List<Integer> v = entry.getValue();
            ans[i][0] = k;
//            int val = v.stream().mapToInt(Integer::valueOf).sum();
            int sum=0;
            for (int s:v){
                sum+=s;
            }
            ans[i][1] = sum/v.size();
            i++;
        }
        return ans;
    }



}
