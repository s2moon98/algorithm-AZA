import java.util.Scanner;

public class Main {

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static int n;
    public static int m;

    public static int[][] map;
    public static boolean[][] visited;
    public static int min;

    public static void dfs(int x, int y, boolean alreadyBroke, int cnt)
    {
        if (x == n-1 && y == m-1)
        {
            min = Math.min(min, cnt);
            return;
        }

        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m)
            {
                if (!visited[nx][ny])
                {
                    if (map[nx][ny] == '0')
                    {
                        visited[nx][ny] = true;
                        dfs(nx, ny, alreadyBroke, cnt+1);
                        visited[nx][ny] = false;
                    }
                    else if (map[nx][ny] == '1' && !alreadyBroke)
                    {
                        visited[nx][ny] = true;
                        dfs(nx, ny, true, cnt+1);
                        visited[nx][ny] = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++)
        {
            String s = sc.next();
            for (int j = 0; j < m; j++)
                map[i][j] = s.charAt(j);
        }

        min = Integer.MAX_VALUE;
        visited[0][0] = true;
        dfs(0, 0, false, 1);

        if (min == Integer.MAX_VALUE) min = -1;
        System.out.print(min);
    }
}
