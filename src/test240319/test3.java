package test240319;

import java.util.Arrays;

public class test3 {
    public static void main(String[] args) {

        int[] dots = {};
        int[] lines = {};

        int answer = 0;
        // 사용할 수 있는 최소 선분 수
        // 모두 못 덮으면 -1

        int dot = dots.length;
        int line = lines.length;
        // 각 점까지 최소 선분 수 저장
        int[] dp = new int[dot];

        Arrays.fill(dp, Integer.MAX_VALUE / 2);

        // 첫번째 점을 덮기 위해서 선분 1개가 필요
        dp[0] = 1;
        System.out.println(dp[0]);

        // 각 점에 대해 해당 점을 끝으로 하는 선분의 최소 개수
        for(int i=0; i<dot; i++){
            // 주어진 선분들을 순회하여, 해당 선분을 사용하여 각 점을 덮을 수 있는지 확인
            for(int j=0; j<line; j++){
                for(int k=i; k<dot; k++){
                    if(dots[k]-dots[i]<=lines[j]){
                        if(i>0){
                            dp[k] = Math.min(dp[k], dp[i-1]+1);
                        } else{
                            // 첫번째 점이면 선분 하나
                            dp[k] = 1;
                        }
                    }
                }
            }
        }

        answer = dp[dot-1];
        // 못덮으면 -1
        answer = answer >= Integer.MAX_VALUE / 2 ? -1 : answer;
    }
}
