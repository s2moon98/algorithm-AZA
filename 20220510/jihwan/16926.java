package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken()) % (N*M);
        board = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < R; i++) rotate();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    private static void rotate() {
        int line = Math.min(N, M) / 2;

        for(int i = 0; i < line; i++) {
            int temp = board[i][i];

            for(int j = i; j < M-1-i; j++) board[i][j] = board[i][j+1];
            for(int j = i; j < N-1-i; j++) board[j][M-1-i] = board[j+1][M-1-i];
            for(int j = M-1-i; j > i; j--) board[N-1-i][j] = board[N-1-i][j-1];
            for(int j = N-1-i; j > i; j--) board[j][i] = board[j-1][i];
            board[i+1][i] = temp;
        }
    }
}