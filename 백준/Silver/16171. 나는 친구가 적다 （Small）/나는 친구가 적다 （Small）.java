import java.util.Scanner;

public class Main {

    public static boolean isExist(String s, String keyword)
    {
        int stringCurIndex = 0;
        int keywordCurIndex = 0;

        while (keywordCurIndex < keyword.length())
        {
            if (Character.isDigit(s.charAt(stringCurIndex)))
            {
                stringCurIndex++;
                continue;
            }

            if (s.charAt(stringCurIndex) != keyword.charAt(keywordCurIndex))
                return false;

            stringCurIndex++;
            keywordCurIndex++;
        }

        return true;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String keyword = sc.next();

        Character firstAlphabet = keyword.charAt(0);

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == firstAlphabet)
            {
                if (isExist(s.substring(i), keyword))
                {
                    System.out.print("1");
                    return;
                }
            }
        }

        System.out.print("0");
    }
}
