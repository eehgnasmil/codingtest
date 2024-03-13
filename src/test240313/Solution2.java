package test240313;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution2 {
    public static void main(String[] args) {
        // I 삽입 D 1 큐에서 최댓값 삭제 D -1 큐에서 최댓값 삭제
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" };
        int[] my = my(operations);
        int[] gpt = gpt(operations);
    }

    private static int[] gpt(String[] operations) {
        int[] answer = {0, 0};

        // 최대 힙과 최소 힙을 각각 사용하여 이중 우선순위 큐 구현
        // 최소가 우선순위라 최대는 조건 필요
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (String operation : operations) {
            // split은 동일
            String[] split = operation.split(" ");
            String command = split[0];
            int value = Integer.parseInt(split[1]);

            if (command.equals("I")) {
                // 값 삽입
                maxHeap.offer(value);
                minHeap.offer(value);
            } else if (command.equals("D")) {
                // 최댓값 삭제
                if (value == 1 && !maxHeap.isEmpty()) {
                    int max = maxHeap.poll();
                    minHeap.remove(max);
                }
                // 최솟값 삭제
                else if (value == -1 && !minHeap.isEmpty()) {
                    int min = minHeap.poll();
                    maxHeap.remove(min);
                }
            }
        }

        // 큐가 비어있지 않으면 최댓값과 최솟값을 반환
        if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }

        return answer;
    }

    public static int[] my(String[] operations) {
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[2];
        for (String str : operations) {

            String str0 = str.split(" ")[0];
            String str1 = str.split(" ")[1];
            // 최대 최소 인덱스

            if ("I".equals(str0)) {
                // 삽입
                list.add(Integer.parseInt(str1));

            } else if(list.size() != 0) {
                int maxIndex = 0;
                int minIndex = 0;

                if(list.size()!=1){
                    for(int i=0; i<list.size();i++){
                        maxIndex = list.get(maxIndex) > list.get(i) ? maxIndex : i;
                        minIndex = list.get(minIndex) < list.get(i) ? minIndex : i;

                    }
                }

                if ("1".equals(str1)) {
                    list.remove(maxIndex);
                    // 최대값 삭제
                } else if ("-1".equals(str1)) {
                    // 최소값 삭제
                    list.remove(minIndex);
                }

            }
        }
        if(list.size() == 0){
            answer[0] = 0;
            answer[1] = 0;
        } else{
            int maxNum = list.get(0);
            int minNum =  list.get(0);
            for(Integer i: list){
                maxNum = maxNum > i ? maxNum : i;
                minNum = minNum < i ? minNum : i;
            }
            answer[0] = maxNum;
            answer[1] = minNum;
        }


        return answer;
    }
}
