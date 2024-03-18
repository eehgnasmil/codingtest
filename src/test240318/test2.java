package test240318;
import java.util.*;

public class test2 {
    public static void main(String[] args) {
            int[] grade1 = {2, 2, 1};
            int[] grade2 = {4, 2, 3, 1};
            //-------------매개변수 grade//
            int n = grade1.length;
            int[] answer = new int[n];

            // 점수와 인덱스를 함께 저장하는 배열 생성
            int[][] scores = new int[n][2];
            for (int i = 0; i < n; i++) {
                scores[i][0] = grade1[i];
                scores[i][1] = i;
            }

            // 점수를 기준으로 내림차순 정렬
            Arrays.sort(scores, (a, b) -> b[0] - a[0]);

            // 등수 계산
            for (int i = 0; i < n; i++) {
                int rank = i + 1;
                int idx = scores[i][1];
                answer[idx] = rank;

                // 동점자 처리
                while (i < n - 1 && scores[i][0] == scores[i + 1][0]) {
                    answer[scores[i + 1][1]] = rank;
                    i++;
                }
            }

            System.out.print(answer);
        }

}
