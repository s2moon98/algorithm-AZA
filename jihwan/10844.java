package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static long DIVIDE = 1000000000;
    static int N;
    static long answer = 0L;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void logic() {
        dp = new long[N+1][10];
        for(int i = 0; i < 10; i++) // 1의 자리 숫자를 입력하기 위한 행위
            dp[1][i] = 1;

        // i 는 자릿수, j는 해당 자릿수의 숫자
        for(int i = 2; i <= N; i++) {
            dp[i][0] = dp[i-1][1]; // 만약 현재 자릿수가 0이면, 이전 자릿수의 1만 올 수 있다는 뜻.
            dp[i][9] = dp[i-1][8];
            for(int j = 1; j < 9; j++) {
                dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1]) % DIVIDE;
            }
        }

        for(int i = 1; i <= 9; i++)
            answer += dp[N][i];

        System.out.println(answer%DIVIDE);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }
}