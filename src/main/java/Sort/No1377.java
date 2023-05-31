package Sort;

import java.io.*;
import java.util.Arrays;

public class No1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Node(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(arr);

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i].index - i);
        }
        bw.write(max + 1 + "\n");

        bw.close();
        br.close();
    }

    public static class Node implements Comparable<Node> {
        int number;
        int index;

        public Node(int number, int index) {
            this.number = number;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return number - o.number;
        }
    }
}