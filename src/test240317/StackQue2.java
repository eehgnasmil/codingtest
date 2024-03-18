package test240317;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StackQue2 {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
         int[] speeds = {1,1,1,1,1,1};

        //int[] progresses = {93, 30, 55};
        //int[] speeds = {1, 30, 5};

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<progresses.length; i++){
            int day = (int)Math.ceil((double) (100 - progresses[i])/speeds[i]);
            list.add(day);
        }

        ArrayList<Integer> cnts = new ArrayList<>();
        // list 5 10 1 1 20 1
        // cnts 1 3 2
        int cnt = 1;
        int tmp = list.get(0);
       for(int i=1; i<list.size(); i++){
            if(tmp >= list.get(i)){
                cnt++;
            } else {
                cnts.add(cnt);
                cnt = 1;
                tmp = list.get(i);
            }
       }
       cnts.add(cnt);

        int [] answer = new int[cnts.size()];
        for(int i=0; i<cnts.size(); i++){
            answer[i] = cnts.get(i);
        }
    }

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();

        // 각 작업이 완료되는데 필요한 날짜를 계산하여 큐에 저장
        for (int i = 0; i < progresses.length; i++) {
            int daysNeeded = (int) Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            queue.offer(daysNeeded);
        }

        List<Integer> answerList = new ArrayList<>();

        // 첫 번째 작업의 완료 날짜를 기준으로 함께 배포되어야 하는 작업의 수 계산
        int prevDay = queue.poll();
        int count = 1;
        while (!queue.isEmpty()) {
            int curDay = queue.poll();
            // 이전 작업보다 빨리 완료되면 함께 배포될 수 있음
            if (curDay <= prevDay) {
                count++;
            } else {
                // 이전 작업보다 늦게 완료되면 이전 작업까지 배포하고 count 초기화
                answerList.add(count);
                count = 1;
                prevDay = curDay;
            }
        }
        answerList.add(count); // 마지막에 남은 작업 배포

        // List를 배열로 변환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
