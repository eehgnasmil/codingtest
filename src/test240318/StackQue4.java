package test240318;

import java.util.LinkedList;
import java.util.Queue;

public class StackQue4 {
    // 다리를 지나는 트럭
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        int totalWeight = 0;
        int time = 0;
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        for(int i=0; i< bridge_length; i++){
            bridge.offer(0);
        }

        for(int truck : truck_weights){
            while(true){
                time++;
                totalWeight -= bridge.poll();
                if(totalWeight + truck <= weight){
                    bridge.offer(truck);
                    totalWeight += truck;
                    break;
                } else {
                    bridge.offer(0);
                }
            }
        }
        answer = time + bridge_length;
    }
}
