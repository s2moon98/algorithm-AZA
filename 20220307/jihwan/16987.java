package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, answer = 0;
    static Egg[] eggs;

    public static void main(String[] args) throws IOException {
        input();
        logic(0, 0);
        System.out.println(answer);
    }

    private static void logic(int point, int count) {
        if(point == N) {
            answer = Math.max(answer, count);
            return;
        }


        if(eggs[point].armor <= 0 || count == N-1) { // 손에 쥔 계란이 깨져있을 때, 모든 계란이 깨졌을 때
            logic(point+1, count);
            return;
        }

        int tempCount = count;

        for(int i = 0; i < N; i++) {
            if(i == point) continue;
            if(eggs[i].armor <= 0) continue;

            eggs[point].armor -= eggs[i].weight;
            eggs[i].armor -= eggs[point].weight;

            if(eggs[point].armor <= 0) count++;
            if(eggs[i].armor <= 0) count++;

            logic(point+1, count);

            count = tempCount;
            eggs[point].armor += eggs[i].weight;
            eggs[i].armor += eggs[point].weight;
        }
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            eggs[i] = new Egg(s, w);
        }
    }
}

class Egg {
    int armor;
    int weight;

    Egg(int armor, int weight) {
        this.armor = armor;
        this.weight = weight;
    }
}