package test240319;

import java.util.*;

public class test1 {
    public static void main(String[] args) {
        String s = "";

        String answer = "";
        // 가장 많이 쓰인 알파벳 소문자로 리턴

        // 알파벳을 소문자 변환
        s = s.toLowerCase();

        Map<Character, Integer> map = new HashMap<>();
        // 문자와 해당 문자의 빈도 저장
        for(char c:s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        // 키값을 가져와서  리스트로 변환
        List<Character> keys = new ArrayList<>(map.keySet());
        // 문자열 내 문자들의 빈도를 기준으로 내림차순으로 정렬
        Collections.sort(keys, (a,b)-> map.get(b)-map.get(a));

        // 최대값
        int max = map.get(keys.get(0));

        // 최대값과 같은거
        List<Character> order = new ArrayList<>();
        for(char key : keys){
            if(max == map.get(key)){
                // 같으면 담고 아니면 break
                order.add(key);
            } else{
                break;
            }
        }

        // 알파벳 순으로 정렬
        Collections.sort(order);

        for(char c : order){
            answer += c;
        }

        System.out.println(answer);
    }
}
