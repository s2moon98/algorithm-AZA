import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static boolean[] visited;
    public static List<Integer>[] computers;
    public static List<Integer> answers;

    public static int maxCnt;

    public static void dfs(int i, int cnt)
    {
        if (maxCnt == cnt)
            answers.add(i);
        else if (maxCnt < cnt)
        {
            maxCnt = cnt;
            answers.clear();
            answers.add(i);
        }

        if (!visited[i])
        {
            visited[i] = true;
            for (int index : computers[i])
            {
                dfs(index, cnt+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[n+1];
        computers = new List[n+1];
        for (int i = 0; i <= n; i++)
            computers[i] = new ArrayList<>();

        for (int i = 0; i < m; i++)
        {
            int in = sc.nextInt();
            int out = sc.nextInt();

            computers[in].add(out);
        }

        answers = new ArrayList<>();
        maxCnt = 0;

        for (int i = 1; i <= m; i++)
        {
            if (computers[i].size() > 0)
                dfs(i, 1);
        }

        Collections.sort(answers);
        StringBuilder sb = new StringBuilder();
        for (int answer : answers)
        {
            sb.append(answer + " ");
        }
        System.out.print(sb);
    }
}
