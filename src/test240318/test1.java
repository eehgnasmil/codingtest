package test240318;
import java.util.*;
public class test1 {
    public static void main(String[] args) {
        String s = "aAb";
        String s2 = "BA";
        String s3 = "BbA";
//---------------------매개변수 S---------------------------
        s = s.toLowerCase();

        // 알파벳 별 빈도수를 저장할 맵 생성
        Map<Character, Integer> freqMap = new HashMap<>();

        // 각 알파벳의 빈도수 계산
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {  // 알파벳인 경우에만 계산
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }
        }

        // 빈도수를 기준으로 내림차순 정렬
        List<Character> keys = new ArrayList<>(freqMap.keySet());
        Collections.sort(keys, (a, b) -> freqMap.get(b) - freqMap.get(a));

        // 가장 많이 사용된 알파벳 추출
        int maxFreq = freqMap.get(keys.get(0));
        List<Character> mostFrequentChars = new ArrayList<>();
        for (char key : keys) {
            if (freqMap.get(key) == maxFreq) {
                mostFrequentChars.add(key);
            } else {
                break;
            }
        }

        // 알파벳 순서로 정렬
        Collections.sort(mostFrequentChars);

        // 결과 문자열 생성
        StringBuilder result = new StringBuilder();
        for (char c : mostFrequentChars) {
            result.append(c);
        }

        System.out.println(result.toString());
    }
}
