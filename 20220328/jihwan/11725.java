package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<ArrayList<Integer>> tree;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        input();
        logic();
        printAnswer();
    }

    private static void printAnswer() {
        for(int i = 2; i <= N; i++)
            System.out.println(answer[i]);
    }

    private static void logic() {
        Queue<Integer> q = new LinkedList<>();

        q.add(1);

        while(!q.isEmpty()) {
            int now = q.poll();
            ArrayList<Integer> children = tree.get(now);

            for(Integer child : children) {
                if(answer[child] == 0) {
                    answer[child] = now;
                    q.add(child);
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        answer = new int[N+1];
        tree = new ArrayList<>(N+1);
        for(int i = 0; i <= N; i++) tree.add(new ArrayList<>());

        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

    }
}