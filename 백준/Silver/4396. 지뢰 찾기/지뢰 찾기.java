import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};

    public static class Bomb
    {
        int x;
        int y;

        Bomb(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Bomb> bombList = new ArrayList<>();
        char[][] bombMap = new char[n][n];
        char[][] map = new char[n][n]; // 출력할 지도

        // 지뢰 위치 입력 받기
        for (int i = 0; i < n; i++)
        {
            String s = sc.next();
            for (int j = 0; j < s.length(); j++)
            {
                bombMap[i][j] = s.charAt(j);

                if (s.charAt(j) == '*')
                    bombList.add(new Bomb(i, j));
            }
        }

        boolean bombPop = false;

        for (int i = 0; i < n; i++)
        {
            String s = sc.next();
            for (int j = 0; j < n; j++)
            {
                if (s.charAt(j) == 'x')
                {
                    if (bombMap[i][j] == '*')
                        bombPop = true;

                    int bombCnt = 0;

                    for (int ind = 0; ind < 8; ind++)
                    {
                        int nx = i + dx[ind];
                        int ny = j + dy[ind];

                        if (nx >= 0 && nx < n && ny >= 0 && ny < n)
                        {
                            if (bombMap[nx][ny] == '*')
                                bombCnt++;
                        }
                    }

                    map[i][j] = Character.forDigit(bombCnt, 10);
                }
                else
                    map[i][j] = '.';
            }
        }

        if (bombPop)
        {
            for (Bomb bomb : bombList)
            {
                map[bomb.x][bomb.y] = '*';
            }
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    }
}
