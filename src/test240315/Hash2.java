package test240315;

import java.util.HashMap;

public class Hash2 {
    // 완주하지 못한 선수
    public static void main(String[] args) {
        String answer = "";
        // 마라톤에 참여한 선수들 배열
        String[] participant = {"leo", "kiki", "eden"};
        // 완주한 선수
        String[] completion = {"eden", "kiki"};

        HashMap<String, Integer> hashMap = new HashMap<>();

        for(String s : participant){
            if(hashMap.containsKey(s)){
                hashMap.put(s, hashMap.get(s)+1);
            } else {
                hashMap.put(s, 1);
            }
        }

        for(String s : completion){
            hashMap.put(s, hashMap.get(s)-1);
            if(hashMap.get(s)==0) hashMap.remove(s);
        }
       answer = hashMap.keySet().iterator().next();
        System.out.println(answer);
    }
}
