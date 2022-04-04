import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static class Balloon {
        int index;
        int value;

        Balloon(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Balloon> balloons = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            balloons.add(new Balloon(i, sc.nextInt()));
        }

        int curInd = 0;
        while (balloons.size() > 0) {

            if (curInd >= balloons.size())
                curInd = curInd % balloons.size();

            else if (curInd < 0) {
                while (curInd < 0)
                    curInd += balloons.size();
            }

            Balloon curBalloon = balloons.get(curInd);
            System.out.print(curBalloon.index + " ");
            balloons.remove(curBalloon);

            curInd += curBalloon.value;
            if (curBalloon.value > 0) curInd -= 1;
        }
    }
}
