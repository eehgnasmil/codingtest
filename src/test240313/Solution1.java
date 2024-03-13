package test240313;


public class Solution1 {
    public static void main(String[] args) {
       int[][] triangle = {{7}, {3,8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
       int answer = 0;
       int height = triangle.length;
       int[][] dp = new int[height][height];

       dp[0][0] = triangle[0][0];

       for(int i=1; i<height;i++){
           for(int j=0; j<=i;j++){
               if(j==0) {
                   dp[i][j] = dp[i-1][j] + triangle[i][j];
               } else if(j==i){
                   dp[i][j] = dp[i-1][j-1] + triangle[i][j];
               } else {
                   dp[i][j] = dp[i-1][j] > dp[i-1][j-1] ? dp[i-1][j] + triangle[i][j] : dp[i-1][j-1] + triangle[i][j];
               }
           }
       }

       for(int max:dp[height - 1]){
           answer = Math.max(answer,max);
       }
        System.out.println(answer);
    }
}
