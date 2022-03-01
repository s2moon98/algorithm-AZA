import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        int[] cnt = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int left = 0, right = 0;

        int max = 0;
        while (left <= right) {

            if (right >= n && right < 0)
                break;

            if (cnt[arr[right]] < k) {
                cnt[arr[right]]++;
                right++;
            }
            else if (cnt[arr[right]] == k) {
                cnt[arr[left]]--;
                left++;
            }

            max = Math.max(max, right - left);

        }

        System.out.println(max);

    }

}
