import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] snows = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
            snows[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(snows);

        int ai, aj;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n-1; i++) {
            for (int j = n-1; j > i; j--) {
                ai = 0;
                aj = n-1;
                while (ai < aj) {
                    if (ai == i || ai == j) {
                        ai++;
                        continue;
                    }
                    if (aj == i || aj == j) {
                        aj--;
                        continue;
                    }

                    min = Math.min(min, Math.abs(snows[i] + snows[j] - snows[ai] - snows[aj]));
                    if (snows[i] + snows[j] > snows[ai] + snows[aj])
                        ai++;
                    else
                        aj--;
                }
            }
        }

        System.out.println(min);
    }

}
