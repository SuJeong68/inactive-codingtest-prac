package Search;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No13023 {
    private static ArrayList<Integer>[] relationship;
    private static boolean[] visited;
    private static boolean isExists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        relationship = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            relationship[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relationship[a].add(b);
            relationship[b].add(a);
        }

        for (int i = 0; i < n && !isExists; i++) {
            DFS(i, 1);
            if (isExists)   break;
        }

        if (isExists)   bw.write("1");
        else            bw.write("0");

        bw.close();
        br.close();
    }

    private static void DFS(int idx, int depth) {
        if (depth == 5 || isExists) {
            isExists = true;
            return;
        }
        visited[idx] = true;
        for (int r : relationship[idx]) {
            if (!visited[r])    DFS(r, depth + 1);
        }
        visited[idx] = false;
    }
}