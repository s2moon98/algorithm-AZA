package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {
        input();
        fillBoard(0, 0);
    }

    private static void fillBoard(int x, int y) {
        // 왼쪽에서 오른쪽으로 쭉 채움
        if(y == 9) {
            fillBoard(x+1, 0);
            return;
        }

        // 위에서 아래로 끝까지 왔을 때 출력
        // 여러개 나올 필요 없으니까 exit
        if(x == 9) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++)
                    System.out.print(board[i][j] + " ");
                System.out.println();
            }
            System.exit(0);
        }

        if(board[x][y] == 0) {
            for(int i = 1; i <= 9; i++) {
                if(check(x, y, i)) {
                    board[x][y] = i;
                    fillBoard(x, y+1);
                }
            }
            board[x][y] = 0;
            return;
        }
        fillBoard(x, y+1);
    }

    private static boolean check(int x, int y, int value) {
        //세로줄 확인
        for(int i = 0; i < 9; i++) {
            if(board[i][y] == value) return false;
        }

        //가로줄 확인
        for(int i = 0; i < 9; i++) {
            if(board[x][i] == value) return false;
        }

        //상자 확인
        int boxX = (x/3) * 3;
        int boxY = (y/3) * 3;

        for(int i = boxX; i < boxX+3; i++) {
            for(int j = boxY; j < boxY+3; j++) {
                if (board[i][j] == value) return false;
            }
        }
        return true;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }
    }
}