import java.util.Scanner;

public class Main {

    public static int max;
    public static int min;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        max = 0;
        min = Integer.MAX_VALUE;

        func(n, 0);
    }

    public static void func(int n, int cnt) {
        if (n / 10 == 0) {
            max = Math.max(max, cnt);
            min = Math.min(min, cnt);
            return;
        }

        else if (n / 10 < 10) {
            int nextN = n/10 + n%10;
            int nextCnt = cnt(nextN);
            func(nextN, nextCnt);
        }
        
        else {
            // 끊을 위치 2개로 이중 for문 돌리기
        }
    }

    public static int cnt(int n) {
        int temp = n;
        int cnt = 0;
        
        while (temp != 0) {
            if ((temp % 10) % 2 == 1)
                cnt++;
            temp /= 10;
        }
        return cnt;
    }
}
