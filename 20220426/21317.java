import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] energy = new int[2][n];

        for (int i = 1; i <= n-1; i++)
        {
            energy[0][i] = sc.nextInt();
            energy[1][i] = sc.nextInt();
        }
        int superJump = sc.nextInt();

        if (n == 1)
        {
            System.out.print(superJump);
            return;
        }


        // dp[0][i] = superJump 안함
        // dp[1][i] = superJump 함
        int[][] dp = new int[2][n+1];

        dp[1][1] = Integer.MAX_VALUE;

        dp[0][2] = energy[0][1];
        dp[1][2] = Integer.MAX_VALUE;

        for (int i = 3; i <= n; i++)
        {
            dp[0][i] = Math.min(dp[0][i-1] + energy[0][i-1], dp[0][i-2] + energy[1][i-2]);

            dp[1][i] = Math.min(dp[1][i-1] + energy[0][i-1], dp[1][i-2] + energy[1][i-2]);
            if (i > 3)
                dp[1][i] = Math.min(dp[1][i], dp[0][i-3] + superJump);
        }

        System.out.print(Math.min(dp[0][n], dp[1][n]));
    }
}
