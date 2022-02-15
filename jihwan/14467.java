package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, answer = 0;
    static int[] cows = new int[11];

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void logic() throws IOException {
        int cow, location;
        Arrays.fill(cows, -1);

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cow = Integer.parseInt(st.nextToken());
            location = Integer.parseInt(st.nextToken());

            if(cows[cow] == -1) cows[cow] = location;
            else if(cows[cow] != location) {
                cows[cow] = location;
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }
}