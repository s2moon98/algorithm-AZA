package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Node root;

    public static class Node {
        int num;
        Node left, right;

        Node(int num) {
            this.num = num;
        }

        void insert(int n) {
            if(n < this.num) {
                if(this.left == null) this.left = new Node(n);
                else this.left.insert(n);
            }
            else {
                if(this.right == null) this.right = new Node(n);
                else this.right.insert(n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        postOrder(root);
    }

    private static void postOrder(Node node) {
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        root = new Node(Integer.parseInt(br.readLine()));

        while (true) {
            String s = br.readLine();
            if(s == null || s.equals("")) return;
            root.insert(Integer.parseInt(s));
        }
    }
}