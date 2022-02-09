package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int LIMIT = 100001;
    static int N, K, answer = 0;
    static int[] coins, dp;

    public static void main(String[] args) throws IOException {
        input();
        answer = logic(K);
        System.out.println(answer == LIMIT ? -1 : answer);
    }

    private static int logic(int target) {
        if(dp[target] != LIMIT) return dp[target];
        for(int i = 0; i < N; i++) {
            if(target - coins[i] > 0)
                dp[target] = Math.min(dp[target], logic(target - coins[i]) + 1);
        }
        return dp[target];
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coins = new int[N];
        dp = new int[LIMIT];
        Arrays.fill(dp, LIMIT);

        for(int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            dp[coins[i]] = 1;
        }
    }
}