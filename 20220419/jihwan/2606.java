package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int C, P, answer = 0;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        input();
        logic();
        System.out.println(answer-1);
    }

    private static void logic() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while(!q.isEmpty()) {
            int now = q.poll();
            visited[now] = true;

            for (int next : graph[now]) {
                if(!visited[next]) {
                    q.add(next);
                }
            }
        }

        for(int i = 1; i <= C; i++)
            if(visited[i]) answer++;

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        C = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        graph = new ArrayList[C+1];
        visited = new boolean[C+1];

        for(int i = 1; i <= C; i++)
            graph[i] = new ArrayList<>();

        for(int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

    }
}