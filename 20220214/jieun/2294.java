import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coins = new int[n];
        int[] dp = new int[k+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i < n; i++)
            coins[i] = sc.nextInt();

        for (int i = 1; i <= k; i++)
        {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++)
            {
                int newInd = i - coins[j];

                if (newInd >= 0)
                {
                    if (dp[newInd] != -1)
                        min = Math.min(min, dp[newInd]+1);
                }
            }

            if (min != Integer.MAX_VALUE)
                dp[i] = min;
        }

        System.out.println(dp[k]);

    }
}

