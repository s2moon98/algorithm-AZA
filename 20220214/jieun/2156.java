import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        /*
        * 처음에 연속으로 마신 와인 개수를 저장하는 배열을 따로 만들어서 조건문으로 분기 칠라함
        * 3개 연속 못 마시게 하려고
        *
        * a. i번째 와인 마셨을 때
        *   a-1. 연속 마셨을 때
        *       연속 카운트 +1
        *       와인 안 마셨을 때랑 비교,,,
        *   a-2. 연속으로 안 마셨을 때
        *
        * b. i번째 와인 안 마셨을 때
        *   연속 카운트 = 0
        *
        * 분기를 너무 많이 쳐야되고 복잡해짐
        *
        * 연속 4잔이 금지였다면 똑같이 적용 가능?
        * */

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n+1];
        int[] wine = new int[n+1];

        for (int i = 1; i <= n; i++)
        {
            wine[i] = sc.nextInt();
        }

        dp[1] = wine[1];

        for (int i = 2; i <= n; i++)
        {
            if (i == 2)
            {
                dp[2] = dp[1] + wine[2];
                continue;
            }

            // 마시기
            dp[i] = Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i]);

            // 안 마시기
            dp[i] = Math.max(dp[i], dp[i-1]);
        }

        System.out.println(dp[n]);
    }
}

