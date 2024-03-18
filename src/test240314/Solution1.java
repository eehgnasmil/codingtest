package test240314;

//
public class Solution1 {
    /**
    1,1,1,1,1
    sum = 0
    index0 +1/-1
    index1 +1+1/ +1 -1 /-1+1 /-1-1
    index2 +1+1+1/+1+1-1/+1-1+1/+1-1-1/-1+1+1/-1+1-1/-1-1+1/-1-1-1
            ...
    index4 32가지
            index5
-1+1+1+1+1 = 3 1
        +1-1+1+1+1 = 3 1
        +1+1-1+1+1 = 3 1
        +1+1+1-1+1 = 3 1
        +1+1+1+1-1 = 3 1
        0
        0
        0
        0
        0
        => answer==target ? 1 : 0
**/
    public static void main(String[] args) {
        int answer = 0;
        int target = 3; // 컴퓨터 개수
        int[] numbers = {1, 1, 1, 1, 1};

        System.out.println(Solution1.solution(numbers, target));
    }

    private static int solution(int[] numbers, int target) {
        return dfs(numbers,target,0,0);
    }

    private static int dfs(int[] numbers, int target, int index, int sum){
       if(index == numbers.length){
           return sum == target ? 1: 0;
       } else {
            return dfs(numbers,target,index+1,sum +numbers[index])
                    + dfs(numbers,target,index+1,sum -numbers[index]);
       }
    }
}
