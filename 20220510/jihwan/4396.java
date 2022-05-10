package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] mineMap;
    static char[][] answerMap;
    static int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        boolean boom = false;
        mineMap = new char[N][N];
        answerMap = new char[N][N];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++)
                mineMap[i][j] = line.charAt(j);
        }

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++) {
                char now = line.charAt(j);
                if(now == 'x' && mineMap[i][j] == '*') boom = true;
                if(now == 'x') answerMap[i][j] = Character.forDigit(detection(i, j), 10);
                else answerMap[i][j] = '.';
            }
        }

        if(boom) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(mineMap[i][j] == '*') answerMap[i][j] = '*';
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) System.out.print(answerMap[i][j]);
            System.out.println();
        }
    }

    private static int detection(int x, int y) {
        int count = 0;
        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isBound(nx, ny) && mineMap[nx][ny] == '*') count++;
        }

        return count;
    }

    private static boolean isBound(int x, int y) {
        if(x < 0 || x >= N || y < 0 || y >= N) return false;
        return true;
    }
}