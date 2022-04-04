import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static class Laser {
        int s;
        int e;

        Laser(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static class Stick {
        int s;
        int e;

        Stick(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        List<Laser> lasers = new ArrayList<>();
        List<Stick> sticks = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (i != s.length() - 1) {

                    if (s.charAt(i+1) == ')') {
                        lasers.add(new Laser(i, i+1));
                        i++;
                    }

                    else
                        stack.push(i);
                }
            }

            else if (s.charAt(i) == ')') {
                int start = stack.pop();

                sticks.add(new Stick(start, i));
            }
        }

        int[] stickCnt = new int[sticks.size()];

        for (Laser laser : lasers) {
            for (int stickInd = 0; stickInd < sticks.size(); stickInd++) {
                Stick curStick = sticks.get(stickInd);
                if (curStick.s < laser.s && curStick.e > laser.e) {
                    stickCnt[stickInd]++;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < sticks.size(); i++) {
            cnt += stickCnt[i] + 1;
        }

        System.out.print(cnt);

    }
}
