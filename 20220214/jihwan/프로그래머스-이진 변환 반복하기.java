import java.util.*;

class Solution {
    static int zeroCount, changeCount;

    public int[] solution(String s) {
        int[] answer = new int[2];
        logic(s);

        answer[0] = changeCount;
        answer[1] = zeroCount;
        return answer;
    }

    private void logic(String s) {
        while(!s.equals("1")) {
            s = deleteZero(s);
            s = lengthToBinary(s);
            changeCount++;
        }
    }

    private String deleteZero(String s) {
        String temp = "";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') zeroCount++;
            else temp += s.charAt(i);
        }
        return temp;
    }

    private String lengthToBinary(String s) {
        int length = s.length();
        return Integer.toBinaryString(length);
    }
}