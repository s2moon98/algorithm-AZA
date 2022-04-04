package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Deque<Balloon> queue = new ArrayDeque<>();
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        logic();
        printAnswer();
    }

    private static void printAnswer() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++)
            sb.append(answer.get(i)).append(" ");

        System.out.println(sb);
    }

    private static void logic() {
        while(!queue.isEmpty()) {
            Balloon now = queue.pop();
            answer.add(now.point);

            if(queue.isEmpty()) break;

            if(now.next > 0) {
                for(int i = 0; i < now.next-1; i++)
                    queue.add(queue.pollFirst());
            }
            else {
                for(int i = 0; i < Math.abs(now.next); i++)
                    queue.addFirst(queue.pollLast());
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++) queue.add(new Balloon(i, Integer.parseInt(st.nextToken())));
    }
}

class Balloon {
    int point;
    int next;

    Balloon(int point, int next) {
        this.point = point;
        this.next = next;
    }
}