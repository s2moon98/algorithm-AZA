package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, SN;
    static int[] switches;
    static Human[] students;


    public static void main(String[] args) throws IOException {
        input();
        logic();
        printSwitch();
    }

    private static void printSwitch() {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(switches[i]).append(" ");
            if(i % 20 == 0) sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void logic() {
        for(int i = 0; i < SN; i++) {
            Human now = students[i];
            if(now.gender == 1) changeByMan(now.number);
            else changeByWoman(now.number);
        }
    }

    private static void changeByMan(int number) {
        int point = number;
        while(point <= N) {
            changeSwitch(point);
            point += number;
        }
    }

    private static void changeByWoman(int number) {
        changeSwitch(number);
        if(number == 1 || number == N) return ;
        int left = number-1;
        int right = number+1;

        while(left >= 1 && right <= N && switches[left] == switches[right]) {
            changeSwitch(left);
            changeSwitch(right);
            left--;
            right++;
        }
    }

    private static void changeSwitch(int number) {
        if(switches[number] == 0) switches[number] = 1;
        else switches[number] = 0;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        switches = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) switches[i] = Integer.parseInt(st.nextToken());

        SN = Integer.parseInt(br.readLine());
        students = new Human[SN];

        for(int i = 0; i < SN; i++) {
            st = new StringTokenizer(br.readLine());
            students[i] = new Human(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }
}

class Human {
    int gender;
    int number;

    Human(int gender, int number) {
        this.gender = gender;
        this.number = number;
    }
}