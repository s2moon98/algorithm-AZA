import java.util.Scanner;

public class Main {

    public static int[][] map;

    public static void turn(int sx, int sy, int ex, int ey)
    {
        int temp = map[sx][sy];

        // 위
        for (int i = sy; i < ey; i++)
           map[sx][i] = map[sx][i+1];

        // 왼쪽
        for (int i = sx; i < ex; i++)
            map[i][ey] = map[i+1][ey];

        // 아래
        for (int i = ey; i > sy; i--)
            map[ex][i] = map[ex][i-1];

        // 오른쪽
        for (int i = ex; i > sx+1; i--)
            map[i][sy] = map[i-1][sy];

        map[sx+1][sy] = temp;
    }

    public static void wholeTurn(int n, int m)
    {
        int sx = 0;
        int sy = 0;

        int ex = n-1;
        int ey = m-1;

        while (sx <= ex && sy <= ey)
        {
            turn(sx++, sy++, ex--, ey--);
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();

        map = new int[n][m];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
                map[i][j] = sc.nextInt();
        }

        for (int i = 0; i < r; i++)
            wholeTurn(n, m);

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }

    }
}
