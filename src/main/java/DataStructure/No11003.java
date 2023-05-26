package DataStructure;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class No11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Node> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            Node node = new Node(arr[i], i);
            if (deque.peekFirst() != null && deque.peekFirst().value >= node.value) {
                if (deque.peekFirst().value == node.value)
                    deque.removeFirst();
                deque.addFirst(node);
            } else {
                while (deque.peekLast() != null && deque.peekLast().value >= node.value) {
                    deque.removeLast();
                }
                deque.addLast(node);
            }

            while (i >= l && deque.peekFirst().index <= i - l) {
                deque.removeFirst();
            }
            bw.write(deque.peekFirst().value + " ");
        }

        bw.close();
        br.close();
    }

    public static class Node {
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}