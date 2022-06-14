package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, answer;
    static Egg[] eggs;

    public static void main(String[] args) throws IOException {
        input();
        smashEgg(0, 0);

        System.out.println(answer);
    }

    private static void smashEgg(int index ,int count) {
        if(index == N) {
            answer = Math.max(answer, count);
            return;
        }

        if(eggs[index].isArmorBroken() || count == N-1) {
            smashEgg(index+1, count);
            return;
        }

        int temp = count;

        for(int i = 0; i < N; i++) {
            if(i == index) continue;
            if(eggs[i].isArmorBroken()) continue;

            attack(i, index);

            if(eggs[i].isArmorBroken()) count++;
            if(eggs[index].isArmorBroken()) count++;

            smashEgg(index+1, count);

            count = temp;
            rollback(i, index);
        }
    }

    private static void attack(int i, int j) {
        eggs[i].crash(eggs[j].getAttackPoint());
        eggs[j].crash(eggs[i].getAttackPoint());
    }

    private static void rollback(int i, int j) {
        eggs[i].rollBack(eggs[j].getAttackPoint());
        eggs[j].rollBack(eggs[i].getAttackPoint());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int armor = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(armor, weight);
        }
    }
}

class Egg {
    int armor;
    int weight;

    public Egg(int armor, int weight) {
        this.armor = armor;
        this.weight = weight;
    }

    public void crash(int attack) {
        this.armor -= attack;
    }

    public void rollBack(int attack) {
        this.armor += attack;
    }

    public boolean isArmorBroken() {
        return armor <= 0;
    }

    public int getAttackPoint() {
        return weight;
    }
}