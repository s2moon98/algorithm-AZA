import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static int[][] trains;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        trains = new int[n+1][21];

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            int trainInd, seatInd;
            switch(num) {
                case 1:
                    trainInd = sc.nextInt();
                    seatInd = sc.nextInt();

                    func1(trainInd, seatInd);

                    break;
                case 2:
                    trainInd = sc.nextInt();
                    seatInd = sc.nextInt();

                    func2(trainInd, seatInd);

                    break;
                case 3:
                    trainInd = sc.nextInt();

                    func3(trainInd);

                    break;
                case 4:
                    trainInd = sc.nextInt();

                    func4(trainInd);

                    break;
            }
        }

        Set<String> trainResults = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            trainResults.add(Arrays.toString(trains[i]).substring(1));
        }

        System.out.println(trainResults.size());

    }

    public static void func1(int trainInd, int seatInd)
    {
        if (trains[trainInd][seatInd] == 0)
            trains[trainInd][seatInd] = 1;
    }

    public static void func2(int trainInd, int seatInd)
    {
        if (trains[trainInd][seatInd] == 1)
            trains[trainInd][seatInd] = 0;
    }

    public static void func3(int trainInd)
    {
        int cur = 20;
        while (cur > 1) {
            trains[trainInd][cur] = trains[trainInd][cur - 1];
            cur--;
        }
        trains[trainInd][1] = 0;
    }

    public static void func4(int trainInd)
    {
        int cur = 1;
        while (cur < 20) {
            trains[trainInd][cur] = trains[trainInd][cur + 1];
            cur++;
        }
        trains[trainInd][20] = 0;
    }

}
