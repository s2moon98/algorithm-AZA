import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int zeroCnt;
    public static int[][] sudoku;
    public static List<Point> zeroList = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        sudoku = new int[9][9];

        zeroCnt = 0;

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                sudoku[i][j] = sc.nextInt();
                if (sudoku[i][j] == 0)
                {
                    zeroCnt++;
                    zeroList.add(new Point(i, j));
                }
            }
        }

        dfs();

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                System.out.print(sudoku[i][j]);
            }
            System.out.println();
        }

    }

    public static void dfs()
    {
        if (zeroCnt == 0)
            return;

        for (Point p : zeroList)
        {
            for (int i = 1; i <= 9; i++ )
            {
                int boxi = ((int)(p.x / 3)) * 3;
                int boxj = ((int)(p.y / 3)) * 3;
                if (rowCheck(i, p.x) && colCheck(i, p.y) && boxCheck(i, boxi, boxj))
                {
                    zeroCnt--;
                    sudoku[p.x][p.y] = i;
                    zeroList.remove(p);
                    dfs();
                }

                zeroCnt++;
                sudoku[p.x][p.y] = 0;
                zeroList.add(p);
            }
        }

    }

    public static boolean rowCheck(int num, int rowNum)
    {
        for (int i = 0; i < 9; i++)
        {
            if (sudoku[rowNum][i] == num)
                return false;
        }
        return true;
    }

    public static boolean colCheck(int num, int colNum)
    {
        for (int i = 0; i < 9; i++)
        {
            if (sudoku[i][colNum] == num)
                return false;
        }
        return true;
    }

    public static boolean boxCheck(int num, int boxi, int boxj)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (sudoku[boxi + i][boxj + j] == num)
                    return false;
            }
        }
        return true;
    }

    public static class Point
    {
        int x;
        int y;

        Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

}
