package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String target = br.readLine();
        boolean exist = false;

        line = line.replaceAll("[0-9]", "");

        for(int i = 0; i <= line.length() - target.length(); i++) {
            if(line.substring(i, i+target.length()).equals(target)) exist = true;
        }
        System.out.println(exist ? 1 : 0);
    }
}