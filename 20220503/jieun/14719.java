import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        Integer[] heights = new Integer[w];
        int max = 0;
        int maxInd = -1;
        for (int i = 0; i < w; i++)
        {
            int height = sc.nextInt();

            heights[i] = height;

            if (height > max)
            {
                max = height;
                maxInd = i;
            }
        }

        int sum = 0;

        // 왼쪽
        int curInd = maxInd;
        while (curInd >= 0 )
        {
            // 왼쪽에서 최대 값 찾기
            int leftMax = 0;
            int leftMaxInd = -1;
            for (int i = curInd - 1; i >= 0; i--)
            {
                if (leftMax < heights[i])
                {
                    leftMax = heights[i];
                    leftMaxInd = i;
                }
            }

            if (leftMaxInd == -1)
                break;

            // 물의 양 더하기
            int water = 0;
            for (int i = leftMaxInd + 1; i < curInd; i++)
            {
                water += leftMax - heights[i];
            }

            sum += water;

            curInd = leftMaxInd;
        }


        // 오른쪽
        curInd = maxInd;
        while (curInd < w)
        {
            // 오른쪽에서 최대 값 찾기
            int rightMax = 0;
            int rightMaxInd = -1;
            for (int i = curInd + 1; i < w; i++)
            {
                if (rightMax < heights[i])
                {
                    rightMax = heights[i];
                    rightMaxInd = i;
                }
            }

            if (rightMaxInd == -1)
                break;

            // 물의 양 더하기
            int water = 0;
            for (int i = curInd + 1; i < rightMaxInd; i++)
            {
                water += rightMax - heights[i];
            }

            sum += water;

            curInd = rightMaxInd;
        }

        System.out.print(sum);
    }
}

