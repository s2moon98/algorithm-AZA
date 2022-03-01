package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, X;
    static int[] visitors;

    public static void main(String[] args) throws IOException {
        input();
        Answer answer = logic();
        printAnswer(answer);
    }

    private static void printAnswer(Answer answer) {
        if (answer.max == 0) System.out.println("SAD");
        else {
            System.out.println(answer.max);
            System.out.println(answer.count);
        }
    }

    private static Answer logic() {
        int left = 0, right = X - 1;
        int max = 0, count = 1, window = 0;

        for (int i = left; i <= right; i++)
            window += visitors[i];

        max = window;
        while (right < N - 1) {
            right++;
            int next = window + visitors[right] - visitors[left];
            if (next > max) {
                max = next;
                count = 1;
            }
            else if (next == max) count++;

            window = next;
            left++;
        }

        return new Answer(max, count);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        visitors = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            visitors[i] = Integer.parseInt(st.nextToken());
    }
}

class Answer {
    int max;
    int count;

    Answer(int max, int count) {
        this.max = max;
        this.count = count;
    }
}