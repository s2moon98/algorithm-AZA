package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, answer;
    static int[] cows = new int[11];
    static int[] beforeCows = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Arrays.fill(beforeCows, -1);

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            if(beforeCows[c] == -1) {
                beforeCows[c] = p;
            }
            else if(beforeCows[c] != p) {
                cows[c]++;
                beforeCows[c] = p;
            }
        }

        for(int i = 1; i <= 10; i++) answer += cows[i];

        System.out.println(answer);
    }
}