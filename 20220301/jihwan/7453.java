package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] A, B, C, D, AB, CD;

    public static void main(String[] args) throws IOException {
        input();
        init();
        logic();
    }

    private static void logic() {
        int left, right;
        long answer = 0;

//        while (left <= right && right >= 0 && left < CD.length) {
        for (left = 0, right = CD.length - 1; left < CD.length && right >= 0; ) {
            long now = AB[left] + CD[right];
            int duplicationAB = 0;
            int duplicationCD = 0;

            if (now == 0) {
                long temp = AB[left];
                while (left < CD.length && temp == AB[left]) {
                    left++;
                    duplicationAB++;
                }

                temp = CD[right];
                while (right >= 0 && temp == CD[right]) {
                    right--;
                    duplicationCD++;
                }
                answer += (long) duplicationAB * duplicationCD;
            } else if (now < 0) left++;
            else right--;
        }

        System.out.println(answer);
    }

    private static void init() {
        int num = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[num] = A[i] + B[j];
                CD[num] = C[i] + D[j];
                num++;
            }
        }
        Arrays.sort(AB);
        Arrays.sort(CD);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        A = new long[N];
        B = new long[N];
        C = new long[N];
        D = new long[N];
        AB = new long[N * N];
        CD = new long[N * N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }
    }
}