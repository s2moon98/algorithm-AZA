package coding_test;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static HashSet<Integer> set;
    static int[] count;
    static int root, testCase=0, trunk; // root, 테케, 간선
    static boolean flag = true;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            init();
            input();
            if(!flag) break;
            logic();
        }
    }

    private static void logic() {
        // 들어오는 간선의 개수 0 -> root
        // 들어오는 간선의 개수가 1개보다 많으면?

        // 아무것도 없어도 트리래.
        if(set.isEmpty()) {
            printResult(true);
            return ;
        }

        for (Integer leaf : set) {
            if(count[leaf] == 0) root++;
            if(count[leaf] > 1) {
                printResult(false);
                return ;
            }
        }

        printResult(root == 1 && set.size() - trunk == 1);
    }

    private static void printResult(boolean isTree) {
        if(isTree) System.out.println("Case " + testCase +" is a tree.");
        else System.out.println("Case " + testCase +" is not a tree.");
    }

    private static void init() {
        set = new HashSet<>();
        count = new int[1001];
        root = 0;
        testCase++;
        trunk = 0;
    }

    private static void input() {
        while(true) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            if(u == 0 && v == 0) return;
            if(u == -1 && v == -1) {
                flag = false;
                return ;
            }

            set.add(u);
            set.add(v);
            count[v]++;
            trunk++;
        }
    }
}