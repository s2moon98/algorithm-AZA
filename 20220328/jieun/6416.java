import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Map<Integer, Integer> treeMap;
        Set<Integer> nodes;
        int vertexCnt;
        boolean isTree;
        int rootCnt;
        
        int caseCnt = 1;

        while (true)
        {
            treeMap = new HashMap<>();
            nodes = new HashSet<>();
            vertexCnt = 0;
            isTree = true;
            rootCnt = 0;

            while (true)
            {
                int node1 = sc.nextInt();
                int node2 = sc.nextInt();

                if (node1 == -1 && node2 == -1)
                    return;

                if (node1 == 0 && node2 == 0)
                    break;

                vertexCnt++;
                if (treeMap.get(node2) != null)
                {
                    // 간선 두개 들어오는 노드 존재
                    isTree = false;
                    break;
                }

                treeMap.put(node2, node1);

                nodes.add(node1);
                nodes.add(node2);
            }


            if (isTree)
            {
                // 루트 노드 하나인지 검사
                for (Integer node : nodes)
                {
                    // 들어오는 간선 없다 -> root
                    if (treeMap.get(node) == null)
                    {
                        rootCnt++;
                        if (rootCnt > 1)
                            isTree = false;
                    }
                }
            }
            
            if (isTree)
            {
                // 모든 경로 존재하는지 검사
                if (nodes.size() - vertexCnt != 1)
                    isTree = false;    
            }
            
            if (isTree)
                System.out.println("Case" + caseCnt + "is a tree.");
            else
                System.out.println("Case" + caseCnt + "is not a tree.");
            
            caseCnt++;

        }
    }
}
