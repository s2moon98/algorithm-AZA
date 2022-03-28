import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static String[] switches;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        switches = sc.nextLine().split(" ");

        int studentCnt = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < studentCnt; i++) {
            String[] studentInfo = sc.nextLine().split(" ");

            int ind = Integer.parseInt(studentInfo[1]);
            if (studentInfo[0].equals("1")) {
                // 남자
                while (ind <= n) {
                    change(ind);
                    ind = ind + Integer.parseInt(studentInfo[1]);
                }
            }
            else {
                // 여자
                change(ind);
                int cnt = 1;
                while (ind - cnt > 0 && ind + cnt <= n) {
                    if (!switches[ind - cnt - 1].equals(switches[ind + cnt - 1]))
                        break;
                    else {
                        change(ind - cnt);
                        change(ind + cnt);
                        cnt++;
                    }
                }
            }
        }

        for (int i = 0; i < switches.length; i++) {
            System.out.print(switches[i]);
            if (i != switches.length - 1)
                System.out.print(" ");
        }
    }

    public static void change(int ind) {
        if (switches[ind - 1].equals("0"))
            switches[ind - 1] = "1";
        else
            switches[ind - 1] = "0";
    }
}
