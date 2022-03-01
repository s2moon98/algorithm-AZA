package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static ArrayList<Point>[] xIndex;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void logic() {
        long answer = 0;
        long curValue = 0L;
        PriorityQueue<Point> pq = new PriorityQueue<>();

        // x 위치에 들어가 있는 point들을 pq로 집어넣음
        // pq는 그 중 y가 큰 애들로 정렬
        for (ArrayList<Point> index : xIndex) {
            if (index.isEmpty()) continue;
            for (Point now : index) {
                pq.add(now);
                curValue += now.value;
            }
            int prevTop = -1;
            while (!pq.isEmpty() && pq.size() > C) {
                prevTop = pq.peek().y;
                curValue -= pq.poll().value;

                while (!pq.isEmpty() && pq.peek().y == prevTop)
                    curValue -= pq.poll().value;
            }
            answer = Math.max(answer, curValue);
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        xIndex = new ArrayList[100005];

        for (int i = 0; i < xIndex.length; i++)
            xIndex[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            long value = Integer.parseInt(st.nextToken());
            xIndex[i].add(new Point(x, y, value));
        }
    }
}

class Point implements Comparable<Point> {
    int x;
    int y;
    long value;

    public Point(int x, int y, long value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public int compareTo(Point o) {
        return o.y - this.y;
    }
}