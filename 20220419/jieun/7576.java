import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static class Tomato
    {
        int x;
        int y;

        Tomato(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int cnt = 0;
        int rottenCnt = 0;

        int[][] box = new int[n][m];
        List<Tomato> curTomatoes = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                box[i][j] = sc.nextInt();
                if (box[i][j] == 1)
                {
                    curTomatoes.add(new Tomato(i, j));
                    cnt++;
                }
                else if (box[i][j] == -1)
                    rottenCnt++;
            }
        }

        int answer = -1;

        int cur = 1;

        List<Tomato> newTomatoes = new ArrayList<>();
        while (curTomatoes.size() > 0)
        {
            newTomatoes.clear();

            for (Tomato tomato : curTomatoes)
            {
                if (box[tomato.x][tomato.y] == cur)
                {
                    for (int ind = 0; ind < 4; ind++)
                    {
                        int nx = tomato.x + dx[ind];
                        int ny = tomato.y + dy[ind];

                        if (nx >= 0 && nx < n && ny >= 0 && ny < m)
                        {
                            if (box[nx][ny] == 0)
                            {
                                newTomatoes.add(new Tomato(nx, ny));
                                box[nx][ny] = cur+1;
                                cnt++;
                            }
                        }
                    }
                }
            }

            if (cnt == m*n - rottenCnt)
                answer = cur - 1;

            cur++;

            curTomatoes.clear();
            curTomatoes.addAll(newTomatoes);
        }

        System.out.print(answer);
    }
}
