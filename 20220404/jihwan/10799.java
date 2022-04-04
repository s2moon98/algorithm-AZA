package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static String question;
    static Stack<Integer> stack = new Stack<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        input();
        logic();
        System.out.println(answer);
    }

    private static void logic() {
        for(int i = 0; i < question.length(); i++) {
            char now = question.charAt(i);

            if(now == '(') stack.push(i);
            else {
                if(stack.peek() == i-1) {
                    stack.pop();
                    answer += stack.size();
                }
                else {
                    answer++;
                    stack.pop();
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        question = br.readLine();
    }
}