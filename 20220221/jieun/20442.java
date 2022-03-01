import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Map<Integer, Integer> rMap = new HashMap();

        int[] leftK = new int[s.length()];
        int[] rightK = new int[s.length()];
        int maxCnt = 0;

        int cnt;
        int rCnt = 0;

        // 오른쪽 k 개수 구하기
        cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'K') {
                cnt++;
            }
            else {
                rCnt++;
                rMap.put(rCnt, i);

                leftK[i] = cnt;
            }
        }

        if (rCnt == 0) {
            System.out.print(0);
            return;
        }

        // 왼쪽 k 개수 구하기
        cnt = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == 'K') {
                cnt++;
            }
            else {
                rightK[i] = cnt;
            }
        }

        // ㅋㅋ루ㅋㅋ 최대 길이 구하기
        int rStart = 1;
        int rEnd = rCnt;

        int startInd = rMap.get(rStart);
        int endInd = rMap.get(rEnd);

        while (startInd <= endInd) {
            maxCnt = Math.max(maxCnt, rEnd - rStart + 1 + 2 * Math.min(leftK[startInd], rightK[endInd]));

            if (startInd == endInd)
                break;
            else if (leftK[startInd] > rightK[endInd]) {
                rEnd--;
                endInd = rMap.get(rEnd);
            }
            else {
                rStart++;
                startInd = rMap.get(rStart);
            }
        }

        System.out.print(maxCnt);
    }

}
