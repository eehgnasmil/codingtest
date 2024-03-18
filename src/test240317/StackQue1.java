package test240317;

import java.util.ArrayList;
import java.util.List;

public class StackQue1 {
    // 같은 숫자는 싫어
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length;i++){
            if(i!=0){
                if(arr[i] != arr[i-1]){
                    list.add(arr[i]);
                }
            } else{
                list.add(arr[i]);
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size();i++){
            answer[i] = list.get(i);
        }
        System.out.println(answer);
    }

    public int[] solution(int []arr) {
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        int preNum = 10;
        for(int num : arr) {
            if(preNum != num)
                tempList.add(num);
            preNum = num;
        }
        int[] answer = new int[tempList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = tempList.get(i).intValue();
        }
        return answer;
    }

}
