package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        logic();
        printAnswer();
    }

    private static void printAnswer() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for(int i = 0; i < answer.size()-1; i++)
            sb.append(answer.get(i)).append(", ");

        sb.append(answer.get(N-1)).append(">");

        System.out.println(sb);
    }

    private static void logic() {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++) q.add(i);

        int count = 0;
        while(!q.isEmpty()) {
            count++;
            int now = q.poll();
            if(count != K) {
                q.add(now);

            }
            else {
                answer.add(now);
                count = 0;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }
}