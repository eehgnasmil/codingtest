package test230314;

import java.util.Arrays;
import java.util.Collections;

public class Solution3 {
    public static void main(String[] args) {
        String s = "1 2 3 4";
        String answer = "";

        String[] sarr = s.split(" ");

        int max , min, n ;
        max = min =  Integer.parseInt(sarr[0]);
        for(int i=0; i<sarr.length; i++){
            n = Integer.parseInt(sarr[i]);
           max = n>max ? n : max;
           min = n>min? min : n;
        }

        answer = max + " " + min;

    }
}
