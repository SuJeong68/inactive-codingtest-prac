package Search;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No11724 {

    private static ArrayList<Integer>[] arr;
    private static boolean[] visited;

    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u].add(v);
            arr[v].add(u);
        }

        visited = new boolean[arr.length];
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        bw.write(Integer.toString(count));

        bw.close();
        br.close();
    }

    private static void DFS(int idx) {
        if (visited[idx])   return;
        visited[idx] = true;

        ArrayList<Integer> connected = arr[idx];
        for (Integer node : connected) {
            if (!visited[node])
                DFS(node);
        }
    }
}