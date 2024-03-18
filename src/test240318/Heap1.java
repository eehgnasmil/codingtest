package test240318;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Heap1 {
    // 더 맵게
    public static void main(String[] args) {
        int[] scoville = {1, 1, 2, 3, 4, 5, 1, 9, 10, 12};
        int K = 7;
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.offer(s); // 스코빌 지수를 우선순위 큐에 추가
        }

        // 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복
        while (pq.peek() < K) {
            if (pq.size() < 2) {
                // 섞을 음식이 없으면 K 이상으로 만들 수 없음
                answer = -1;
                break;
            }
            int mix1 = pq.poll(); // 가장 맵지 않은 음식
            int mix2 = pq.poll(); // 두 번째로 맵지 않은 음식
            int newScoville = mix1 + (mix2 * 2); // 새로운 음식의 스코빌 지수 계산
            pq.offer(newScoville); // 새로운 음식의 스코빌 지수를 우선순위 큐에 추가
            answer++; // 섞은 횟수 증가
        }
        System.out.println(answer);
    }
}
