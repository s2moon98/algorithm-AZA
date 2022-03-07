import java.util.Scanner;

public class Main {
    public static Egg []eggs;
    public static int n;
    public static int ans;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        eggs = new Egg[n];

        for (int i = 0; i < n; i++)
        {
            int power = sc.nextInt();
            int weight = sc.nextInt();
            eggs[i] = new Egg(power, weight);
        }

        ans = 0;

        dfs(0, 0);

        System.out.println(ans);

    }

    public static void dfs(int cur, int cnt)
    {
        if (cur == n-1) {
            ans = Math.max(ans, cnt);
            return;
        }

        if (eggs[cur].power <= 0) return;     // 내 계란이 깨지면 넘어간다

        for (int i = 0; i < n; i++) {
            if (eggs[i].power <= 0) continue;       // 상대방이 깨진 계란이면 넘어간다
            if (i == cur) continue;

            eggs[cur].power -= eggs[i].weight;
            eggs[i].power -= eggs[cur].weight;

            if (eggs[cur].power <= 0) cnt++;
            if (eggs[i].power <= 0) cnt++;

            dfs(i, cnt);

            eggs[cur].power += eggs[i].weight;
            eggs[i].power += eggs[cur].weight;
        }

    }

    public static class Egg
    {
        int power;
        int weight;

        Egg(int power, int weight)
        {
            this.power = power;
            this.weight = weight;
        }
    }

}
