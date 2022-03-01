import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        Arrays.sort(d);

        int ans = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum = a[i] + b[j];

                int cInd = 0;
                int dInd = 0;

                if (c[cInd] + d[dInd] + sum > 0) {
                    
                }
                else if (c[cInd] + d[dInd] + sum < 0) {

                }
                else {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

}
