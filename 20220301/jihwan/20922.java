package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//?
public class Main {
    static int N, K;
    static int[] numbers;
    static int[] count;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void logic() {
        int start = 0, end = 0, answer = 0;

        while(end < N) {
            answer = Math.max(answer, end-start);
            int now = numbers[end];
            if(count[now] < K) {
                count[now]++;
                end++;
            }
            else { //count[now] >= K
                int first = numbers[start];
                count[first]--;
                start++;
            }
        }
        answer = Math.max(answer, end-start); // 마지막 반복문 돌고, 변경점 있다면 answer 수정

        System.out.println(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        count = new int[100001];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
    }
}