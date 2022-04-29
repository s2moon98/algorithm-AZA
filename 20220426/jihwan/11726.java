package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void logic() {
        if(N < 3) {
            System.out.println(N);
            return ;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= N; i++) dp[i] = (dp[i-1] + dp[i-2]) % 10007;

        System.out.println(dp[N]);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
    }
}