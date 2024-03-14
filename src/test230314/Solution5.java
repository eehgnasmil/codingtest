package test230314;

import java.util.Arrays;

public class Solution5 {
    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        int min = 0;
        // A의 최소*B의 최대
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<A.length;i++){
            min += A[i]*B[A.length-1-i];
        }
        System.out.println(min);
    }
}
