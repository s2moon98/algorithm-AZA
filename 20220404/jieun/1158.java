import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> peopleList = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++)
            peopleList.add(i);

        int curInd = k-1;
        while (peopleList.size() != 0)
        {
            if (curInd >= peopleList.size())
                curInd = curInd % peopleList.size();

            answer.add(peopleList.get(curInd));
            peopleList.remove(curInd);

            curInd += k-1;
        }

        String answerString = answer.stream()
            .map(Object::toString)
            .collect(Collectors.joining(", ", "<", ">"));

        System.out.println(answerString);
    }
}
