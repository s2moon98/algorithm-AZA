package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, N, time;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] board;
    static int[][] bombTime;
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        input();
        logic();
        printAnswer();
    }

    private static void printAnswer() {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++)
                System.out.print(board[i][j]);
            System.out.println();
        }
    }

    private static void logic() {
        time = 1;

        while(time++ < N) {
            if(time % 2 == 0) setBomb();
            else getBomb();
        }
    }

    private static void getBomb() {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(bombTime[i][j] == time) {
                    boooom(i, j);
                }
            }
        }
    }

    private static void boooom(int x, int y) {
        board[x][y] = '.';

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isRange(nx, ny) && board[nx][ny] == 'O' && bombTime[nx][ny] != time) {
                bombTime[nx][ny] = 0;
                board[nx][ny] = '.';
            }
        }
    }

    private static boolean isRange(int x, int y) {
        if(x>=0 && y>=0 && x<R && y<C) return true;
        return false;
    }

    private static void setBomb() {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(board[i][j] == '.') {
                    board[i][j] = 'O';
                    bombTime[i][j] = time+3;
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        bombTime = new int[R][C];

        for(int i = 0; i < R; i++) {
            String line = br.readLine();
            for(int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
                if(board[i][j] == 'O') {
                    q.add(new Node(i, j));
                    bombTime[i][j] = 3;
                }
            }
        }
    }
}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}