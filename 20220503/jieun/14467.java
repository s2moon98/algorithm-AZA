import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer>[] see = new ArrayList[11];
        for (int i = 1 ; i < 11; i++)
            see[i] = new ArrayList<>();

        for (int i = 0; i < n; i++)
            see[sc.nextInt()].add(sc.nextInt());

        int cnt = 0;
        for (int i = 1; i <= 10; i++)
        {
            if (see[i].size() == 0)
                continue;

            int initLocation = see[i].get(0);

            for (int j = 1; j < see[i].size(); j++)
            {
                if (initLocation != see[i].get(j))
                {
                    cnt++;
                    initLocation = see[i].get(j);
                }
            }
        }

        System.out.println(cnt);
    }
}
