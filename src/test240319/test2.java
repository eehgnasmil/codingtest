package test240319;

import java.util.Arrays;

public class test2 {
    public static void main(String[] args) {

        int[] grade = {};
        int n = grade.length;
        int[] answer = new int[n];

        int[][] scores = new int[n][2];
        // 점수 인덱스
        for(int i=0; i<n; i++){
            scores[i][0] = grade[i];
            scores[i][1] = i;
        }

        // 성적으로 내림 차순
        Arrays.sort(scores, (a, b) -> b[0] - a[0]);

        for(int i=0; i<n; i++){
            // 순위는 1부터 // i=0 1등
            int rank = i+1;
            int idx = scores[i][1];
            // 인덱스에 순위 넣기
            answer[idx] = rank;
            // 점수가 동일하면
            while(i<n-1 && scores[i][0]==scores[i+1][0]){
                // 동일한 순위 저장
                answer[scores[i+1][1]] = rank ;
                // 다음 학생으로 이동
                i++;
            }
        }

    }
}
