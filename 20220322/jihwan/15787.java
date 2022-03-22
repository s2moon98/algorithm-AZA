package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer;
    static boolean[] visited = new boolean[1 << 21];
    static int[] trains;

    public static void main(String[] args) throws IOException {
        input();
        logic();
        System.out.println(answer);
    }

    private static void logic() {
        for(int i = 1; i <= N; i++) {
            if(!visited[trains[i]]) {
                answer++;
                visited[trains[i]] = true;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trains = new int[N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int train = Integer.parseInt(st.nextToken());

            if(command == 1) {
                int seat = Integer.parseInt(st.nextToken());
                trains[train] = trains[train] |= 1 << seat;
            }
            if(command == 2) {
                int seat = Integer.parseInt(st.nextToken());
                trains[train] = trains[train] & ~(1<<seat);
            }
            if(command == 3) {
                trains[train] = trains[train] << 1;
                trains[train] = trains[train] & ((1<<21)-1);
            }
            if(command == 4) {
                trains[train] = trains[train] >> 1;
                trains[train] = trains[train] & ~1;
            }
        }
    }
}