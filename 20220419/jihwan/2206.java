package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static String[] board;
    static boolean[][][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void logic() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1, 1, false));

        while(!q.isEmpty()) {
            Point now = q.poll();

            if(now.x == N && now.y == M) {
                System.out.println(now.count);
                return ;
            }

            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx <= 0 || nx > N || ny <= 0 || ny > M) continue;

                if(board[nx].charAt(ny-1) == '0') {// 벽이 아니다
                    if(!now.destroyed && !visited[nx][ny][0]) { // 한번도 부신적 없어요
                        q.add(new Point(nx, ny, now.count+1, false));
                        visited[nx][ny][0] = true;
                    }
                    else if(now.destroyed && !visited[nx][ny][1]) { // 이미 벽을 부셔봤어요
                        q.add(new Point(nx, ny, now.count+1, true));
                        visited[nx][ny][1] = true;
                    }
                }
                else {
                    if(!now.destroyed) { // 벽이다
                        q.add(new Point(nx, ny, now.count+1, true));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N+1];
        visited = new boolean[N+1][M+1][2];

        for(int i = 1; i <= N; i++) board[i] = br.readLine();
    }
}

class Point {
    int x, y, count;
    boolean destroyed;

    public Point(int x, int y, int count, boolean destroyed) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.destroyed = destroyed;
    }
}