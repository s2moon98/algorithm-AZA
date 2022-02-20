import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int maxVisit = 0;
        int maxVisitCnt = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // 초기값
        for (int i = 0; i < x; i++)
            maxVisit += arr[i];

        int visitSum;
        int prevVisitSum = maxVisit;
        for (int i = 1; i <= n-x; i++) {
            visitSum = prevVisitSum;

            visitSum -= arr[i-1];
            visitSum += arr[i+x-1];

            prevVisitSum = visitSum;

            if (maxVisit < visitSum) {
                maxVisit = visitSum;
                maxVisitCnt = 1;
            }
            else if (maxVisit == visitSum) {
                maxVisitCnt++;
            }
        }

        if (maxVisit == 0) {
            System.out.print("SAD");
        }
        else {
            System.out.println(maxVisit);
            System.out.print(maxVisitCnt);
        }
    }

}
