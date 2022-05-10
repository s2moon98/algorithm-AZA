package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int W, H, answer;
    static int[] blocks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        blocks = new int[W];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++) blocks[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < W; i++) {
            int left = blocks[i];
            int right = blocks[i];

            for(int l = i; l >= 0; l--) {
                if(left < blocks[l]) left = blocks[l];
            }
            for(int r = i; r < W; r++) {
                if(right < blocks[r]) right = blocks[r];
            }

            int size = Math.min(right, left) - blocks[i];
            if(size >= 0) answer+=size;
        }

        System.out.println(answer);
    }
}