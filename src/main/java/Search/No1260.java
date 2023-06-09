package Search;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class No1260 {
    private static ArrayList<Integer>[] relations;
    private static StringBuilder sb = new StringBuilder();

    private static boolean[] visited;
    private static Stack<Integer> stack = new Stack<>();
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        relations = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            relations[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relations[a].add(b);
            relations[b].add(a);
        }

        visited = new boolean[n + 1];
        stack.push(v);  DFS(v);
        sb.append("\n");
        visited = new boolean[n + 1];
        queue.add(v);   BFS(v);

        bw.write(sb.toString());

        bw.close();
        br.close();
    }

    private static void DFS(int v) {
        if (visited[v])
            return;

        visited[v] = true;
        sb.append(v).append(" ");

        List<Integer> relation = relations[v].stream().sorted((a, b) -> { return a < b ? 1 : -1; }).collect(Collectors.toList());
        for (int i = 0; i < relation.size(); i++) {
            int node = relation.get(i);
            if (visited[node])
                continue;
            stack.add(node);
        }

        while (!stack.isEmpty()) {
            DFS(stack.pop());
        }
    }

    private static void BFS(int v) {
        if (visited[v])
            return;

        visited[v] = true;
        sb.append(v).append(" ");

        List<Integer> relation = relations[v].stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < relation.size(); i++) {
            int node = relation.get(i);
            if (visited[node])
                continue;
            queue.add(node);
        }

        while (!queue.isEmpty()) {
            BFS(queue.poll());
        }
    }


}