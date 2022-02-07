package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] numbers, dp;

    public static void main(String[] args) throws IOException {
        input();
        logic();
        System.out.println(dp[n]);
    }

    private static void logic() {
        dp[0] = 0;
        dp[1] = numbers[1];
        dp[2] = numbers[1]+numbers[2];
        for(int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-3]+numbers[i-1]+numbers[i]);
            dp[i] = Math.max(dp[i], dp[i-2]+numbers[i]);
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n+1]; // 최대치인 10001은 OutOfBound 에러가 안뜨는데 n+1로 하면 뜬다. 이유를 모르겠어!
        dp = new int[n+1];

        for(int i = 1; i <= n; i++)
            numbers[i] = Integer.parseInt(br.readLine());
    }
}