package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String N;
    static int maxResult, minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        logic(N, 0);
        System.out.print(minResult + " " + maxResult);
    }

    private static void logic(String p, int res) {
        res += howManyOdd(p);
        int sum;

        if(p.length() == 1) {
            maxResult = Math.max(maxResult, res);
            minResult = Math.min(minResult, res);
            return ;
        }
        if(p.length() == 2) {
            logic(lengthTwo(p), res);
            return ;
        }

        for(int i = 1; i < p.length() - 1; i++) {
            for(int j = i+1; j < p.length(); j++) {
                sum = sumStr(p.substring(0, i), p.substring(i, j), p.substring(j));
                logic(Integer.toString(sum), res);
            }
        }
    }

    private static int sumStr(String s1, String s2, String s3) {
        return Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);
    }

    private static String lengthTwo(String p) {
        int first = p.charAt(0) - '0';
        int second = p.charAt(1) - '0';

        return Integer.toString(first + second);
    }

    private static int howManyOdd(String p) {
        int result = 0;
        for(int i = 0; i < p.length(); i++) {
            int now = p.charAt(i) - '0';
            if(now % 2 == 1) result++;
        }
        return result;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
    }
}