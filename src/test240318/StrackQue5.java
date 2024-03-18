package test240318;

public class StrackQue5 {
    // 주식 가격
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = new int[prices.length];

        // 큐 선입선출
        // 스택 후입선출

        for(int i=0; i< prices.length; i++){
            int cnt = 0;
            for(int j=i+1 ; j< prices.length; j++){
                if(prices[i]<=prices[j]){
                    cnt++;
                }
            }
            answer[i] = cnt;
            System.out.println(answer[i]);
        }


    }
}
