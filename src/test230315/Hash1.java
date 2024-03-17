package test230315;

import java.util.HashMap;
import java.util.Map;

public class Hash1 {
    // 포켓몬
    public static void main(String[] args) {
        int[] nums = {3,1,2,3};
        int answer = 0;

        Map map = new HashMap();
        int cnt = nums.length/2;
        for (int n:nums){
            if(map.containsKey(n)){
                map.put(n,(int)map.get(n)+1);
            }else {
                map.put(n,1);
            }
        }
        answer = map.size()>cnt ? cnt : map.size();
        System.out.println(answer);
    }
}
