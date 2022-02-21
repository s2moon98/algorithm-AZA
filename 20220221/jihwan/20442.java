package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String kkrkk;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void logic() {
        int answer = 0;
        int count = 0, num = 0;
        for (int i = 0; i < kkrkk.length(); i++)
            if (!isK(kkrkk.charAt(i))) count++;

        int[] leftK = new int[count];
        int[] rightK = new int[count];
        int left = 0, right = count - 1;

        count = 0;
        for (int i = 0; i < kkrkk.length(); i++) {
            if (isK(kkrkk.charAt(i))) count++;
            else leftK[num++] = count;
        }

        count = 0;
        num = rightK.length-1;
        for (int i = kkrkk.length() - 1; i >= 0; i--) {
            if (isK(kkrkk.charAt(i))) count++;
            else rightK[num--] = count;
        }

        while (left <= right) {
            answer = Math.max(answer, right - left + 1 + 2 * Math.min(leftK[left], rightK[right]));
            if (leftK[left] < rightK[right]) left++;
            else right--;
        }

        System.out.println(answer);
    }

    private static boolean isK(char now) {
        if (now == 'K') return true;
        return false;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        kkrkk = br.readLine();
    }
}