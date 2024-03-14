package test230314;

public class Solution6 {
    public static void main(String[] args) {
        String s =  "())((()))(()";
        boolean answer = true;
        String[] sarr = s.split("");
        if(sarr[0].equals(")")|| sarr[sarr.length-1].equals("(")){
            answer = false;
        } else{
            int open = 0;
            int close = 0;
            boolean b = true;
            for(int i=0; i<sarr.length;i++){
                open += sarr[i].equals("(") ? 1 : 0;
                close += sarr[i].equals(")") ? 1 : 0;
               if(open<close){
                   b = false;
                   break;
               }
            }
            answer = open==close && b ? true : false;
        }
        System.out.println(answer);
    }
}
