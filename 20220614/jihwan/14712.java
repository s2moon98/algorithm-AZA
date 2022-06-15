package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        input();
        countNemmo(0);

        System.out.println(answer);
    }

    private static void countNemmo(int count) {
        if(count == N*M) {
            answer++;
            return ;
        }

        int x = count / M + 1;
        int y = count % M + 1;

        if(checkBoom(x, y)) countNemmo(count+1);

        else {
            countNemmo(count+1);
            isVisited[x][y] = true;
            countNemmo(count+1);
            isVisited[x][y] = false;
        }
    }

    private static boolean checkBoom(int x, int y) {
        return isVisited[x-1][y] && isVisited[x][y-1] && isVisited[x-1][y-1];
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isVisited = new boolean[N+1][M+1];
    }
}