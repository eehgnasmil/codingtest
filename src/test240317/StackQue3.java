package test240317;

import java.util.*;


public class StackQue3 {
    // 제출내역
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int prioity : priorities){
            pq.offer(prioity);
        }
        while(!pq.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priorities[i] == pq.peek()){
                    pq.poll();
                    answer++;
                    if(i == location) {
                        if(!pq.isEmpty()) {
                            pq.clear();
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
