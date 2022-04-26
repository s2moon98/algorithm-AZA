package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, answer = Integer.MAX_VALUE;
    static int[] smallEnergy;
    static int[] bigEnergy;

    public static void main(String[] args) throws IOException {
        input();
        logic(1, 0, 0);
        System.out.println(answer);
    }

    private static void logic(int n, int superJump, int energy) {
        if(n == N) answer = Math.min(energy, answer);
        if(n > N) return;

        logic(n+1, superJump, energy + smallEnergy[n]);
        logic(n+2, superJump, energy + bigEnergy[n]);

        if(superJump == 0) logic(n+3, 1, energy + K);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        smallEnergy = new int[N + 1];
        bigEnergy = new int[N + 1];

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            smallEnergy[i] = Integer.parseInt(st.nextToken());
            bigEnergy[i] = Integer.parseInt(st.nextToken());
        }

        K = Integer.parseInt(br.readLine());
    }
}