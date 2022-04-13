package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static int[] ans;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void logic() {
        int maxValue = -1;
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            bfs(i);
        }

        for(int i = 1; i <= N; i++)
            maxValue = Math.max(maxValue, ans[i]);

        for(int i = 1; i <= N; i++) {
            if(ans[i] == maxValue) sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    private static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();

        q.add(node);
        visited[node] = true;
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next : graph[now]) {
                if(!visited[next]) {
                    ans[next]++;
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) graph[i] = new ArrayList<Integer>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u, v;

            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
        }
    }
}