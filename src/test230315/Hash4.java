package test230315;

import java.util.HashMap;

public class Hash4 {
    // 의상
    public static void main(String[] args) {
        // 의상이름 / 의상종류
        String[][] clothes = {{"yellow_hat", "df"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "eyewear"}};
        int answer = 1;
        // 의상 종류가 존재하면 +1
        HashMap<String, Integer> hm = new HashMap<>();
        for (String[] s : clothes) {
            hm.put(s[1], hm.getOrDefault(s[1], 1) + 1);
        }
        for (Integer value : hm.values()) {
            System.out.println("v" + value);
            answer *= value;
        }

        answer = answer - 1;
        System.out.println(answer);

    }

}
