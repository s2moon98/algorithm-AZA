package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] snowBalls;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }


    // 보고 함
    private static void logic() {
        int answer = Integer.MAX_VALUE;
        Arrays.sort(snowBalls);

        for(int i = 0; i < N-3; i++) {
            for(int j = i+3; j < N; j++) {
                int left = i+1;
                int right = j-1;

                while(left < right) {
                    int anna = snowBalls[i] + snowBalls[j];
                    int elsa = snowBalls[left] + snowBalls[right];
                    int res = elsa - anna;

                    answer = Math.min(answer, Math.abs(anna - elsa));

                    if(res > 0) right--; // 엘사가 더 큰 눈사람을 만든거니까 더 작은 눈뭉치를 골라야함.
                    else left++; // 그 반대
                }
            }
        }

        System.out.println(answer);
    }

    private static int 가보자고(int left, int right) {
        if(left+1 >= right-1) return Integer.MAX_VALUE;
        int anaSnowMan = snowBalls[left] + snowBalls[right];
        int elsaSnowMan = snowBalls[left+1] + snowBalls[right-1];
        return Math.abs(anaSnowMan - elsaSnowMan);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        snowBalls = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++)
            snowBalls[i] = Integer.parseInt(st.nextToken());
    }
}