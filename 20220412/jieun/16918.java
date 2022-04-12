import java.util.Scanner;

public class Main {

    public static Integer[][] map;
    public static int r;
    public static int c;

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void install(int ind)
    {
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                if (map[i][j] == -1)
                    map[i][j] = ind;
            }
        }
    }

    public static void bomb(int ind, int x, int y)
    {
        map[x][y] = -1;

        for (int k = 0; k < 4; k++)
        {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < r && ny >= 0 && ny < c)
            {
                if (map[nx][ny] == ind - 3)
                {
                    bomb(ind, nx, ny);
                }
                map[nx][ny] = -1;
            }
        }

    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        int n = sc.nextInt();

        map = new Integer[r][c];

        for (int i = 0; i < r; i++)
        {
            String s = sc.next();
            for (int j = 0; j < s.length(); j++)
            {
                map[i][j] = s.charAt(j) == '.' ? -1 : 0;
            }
        }

        for (int ind = 2; ind <= n; ind++)
        {
            if (ind % 2 == 0)
                install(ind);

            else
            {
                for (int i = 0; i < r; i++)
                {
                    for (int j = 0; j < c; j++)
                    {
                        if (map[i][j] == ind-3)
                            bomb(ind, i, j);
                    }
                }
            }
        }

        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                if (map[i][j] == -1)
                    System.out.print('.');
                else
                    System.out.print('0');
            }
            System.out.println();
        }
    }
}
