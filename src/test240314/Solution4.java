package test240314;

import static java.lang.Integer.parseInt;

public class Solution4 {
    public static void main(String[] args) {
        String s = 	"3people unFollowed me" ;
        String answer = "" ;

        char[] carr = s.toCharArray();
        if(carr[0]>='0'&&carr[0]<='9'){
            answer += carr[0];
        } else{
            answer += Character.toUpperCase(carr[0]);
        }
            for(int i=1; i<carr.length; i++){

                if(carr[i-1]==' '){
                    answer += Character.toUpperCase(carr[i]);
                } else {
                    answer += carr[i];
                }
            }
        System.out.println(answer);


    }
}
