package Search;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class No1167 {

    private static List<Node>[] relations;
    private static boolean[] visited;
    private static boolean[] stored;
    private static Stack<Node> stack = new Stack<>();

    private static Node max = new Node(0, 0);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int v = Integer.parseInt(br.readLine());
        relations = new List[v + 1];
        for (int i = 1; i <= v; i++) {
            relations[i] = new ArrayList();
        }

        StringTokenizer st;
        for (int i = 1; i <= v; i++) {
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            while (true) {
                int vertex = Integer.parseInt(st.nextToken());
                if (vertex == -1)
                    break;
                int distance = Integer.parseInt(st.nextToken());
                relations[target].add(new Node(vertex, distance));
            }
        }

        visited = new boolean[v + 1];
        stored = new boolean[v + 1];
        for (int i = 1; i <= v; i++) {
            if (relations[i].size() == 1)
                DFS(i, 0);
        }

        visited = new boolean[v + 1];
        stored = new boolean[v + 1];
        DFS(max.vertex, 0);

        bw.write(Integer.toString(max.distance));

        bw.close();
        br.close();
    }

    public static void DFS(int v, int sum) {
        if (visited[v])
            return;
        visited[v] = true;

        Node peeked = stack.isEmpty() ? null : stack.peek();
        boolean check = false;
        List<Node> relation = relations[v];
        for (Node node : relation) {
            if (!visited[node.vertex] && !stored[node.vertex]) {
                check = true;
                stack.push(node);
            }
        }

        if (!check) {
            if (max.distance < sum) {
                max = new Node(v, sum);
            }
            return;
        }

        while (!stack.isEmpty()) {
            if (peeked != null && stack.peek().vertex == peeked.vertex)  return;

            Node node = stack.pop();
            DFS(node.vertex, sum + node.distance);
        }
    }

    public static class Node {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}