package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, Q;
    static HashMap<String, Folder> tree = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree.put("main", new Folder("main"));

        for(int i = 0; i < N+M; i++) {
            st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String name = st.nextToken();
            int isFolder = Integer.parseInt(st.nextToken());
            Folder parentFolder = tree.get(parent);

            if(isFolder == 1) {
                Folder now = new Folder(name);
                tree.put(name, now);
                parentFolder.folderList.add(now);
            }
            else {
                File now = new File(name);
                parentFolder.fileSet.add(now);
            }
            tree.put(parent, parentFolder);
        }

        Q = Integer.parseInt(br.readLine());

        for(int i = 0; i < Q; i++) {
            String line = br.readLine();
            String[] query = line.split("/");
            countFiles(query[query.length-1]);
        }
    }

    private static void countFiles(String folderName) {
        HashSet<File> answerFile = new HashSet<>();
        int fileCount = 0;

        Queue<Folder> fq = new LinkedList<>();
        fq.add(tree.get(folderName));

        while(!fq.isEmpty()) {
            Folder folder = fq.poll();
            fileCount += folder.fileSet.size();

            answerFile.addAll(folder.fileSet);
            fq.addAll(folder.folderList);
        }

        System.out.println(answerFile.size() + " " + fileCount);
    }
}

class Folder {
    String name;
    HashSet<File> fileSet;
    List<Folder> folderList;

    public Folder(String name) {
        this.name = name;
        this.fileSet = new HashSet<>();
        this.folderList = new ArrayList<>();
    }
}

class File {
    String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return Objects.equals(name, file.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}