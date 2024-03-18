package test240315;

import java.util.*;

public class Hash3 {
    // 전화번호 목록
    public static void main(String[] args) {
        String[] phone_book = {"456","789","123","123589"};
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i=0; i< phone_book.length-1;i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
                break;
            }
        }



    }
}

/*
*  String s = phone.split("")[0];
            if (hm.containsKey(s)){
                System.out.println(hm.keySet().iterator().next());
                answer = false;
                break;
            }
            hm.put(s,hm.getOrDefault(s,0));*/