import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        boolean[] isPrint = new boolean[s.length()];

        List<Character> origin = new ArrayList<>();
        for (Character c : s.toCharArray())
        {
            origin.add(c);
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(origin);
        while (origin.size() != 0)
        {
            Character c = origin.get(0);
            int index = s.indexOf(c);
            isPrint[index] = true;

            for (int i = 0; i < s.length(); i++)
            {
                if (isPrint[i])
                    sb.append(s.charAt(i));
            }

            System.out.println(sb.toString());
            origin.remove(0);
            sb.setLength(0);
        }

    }
}
