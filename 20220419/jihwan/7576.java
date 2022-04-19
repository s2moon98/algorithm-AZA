package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, answer = 0;
    static int[][] box;
    static int[][] res;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Point> pq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        input();
        logic();
        System.out.println(answer);
    }

    private static void logic() {

        while(!pq.isEmpty()) {
            Point now = pq.poll();

            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(checkBoundary(nx, ny) && box[nx][ny] == 0 && res[nx][ny] == -1) {
                    pq.add(new Point(nx, ny));
                    res[nx][ny] = res[now.x][now.y]+1;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(box[i][j] == 0 && res[i][j] == -1) {
                    answer = -1;
                    return ;
                }
                answer = Math.max(answer, res[i][j]);
            }
        }

    }

    private static boolean checkBoundary(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        res = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                res[i][j] = -1;
                if(box[i][j] == 1) {
                    pq.add(new Point(i, j));
                    res[i][j] = 0;
                }
            }
        }
    }
}
class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}