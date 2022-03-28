import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Integer>[] treeList;
    public static int[] parents;
    public static boolean[] visited;

    public static void bfs(int n)
    {
        visited[n] = true;
        for (Integer i : treeList[n])
        {
            if (!visited[i])
            {
                parents[i] = n;
                bfs(i);
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        parents = new int[n+1];
        visited = new boolean[n+1];

        treeList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++)
        {
            treeList[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++)
        {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            treeList[node1].add(node2);
            treeList[node2].add(node1);
        }

        bfs(1);

        for (int i = 2; i <= n; i++)
        {
            System.out.println(parents[i]);
        }
    }
}
