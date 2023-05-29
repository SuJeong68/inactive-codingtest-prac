package DataStructure;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class No17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!stack.empty() && arr[stack.peek()] < arr[i]) {
                while (!stack.empty() && arr[stack.peek()] < arr[i]) {
                    res[stack.pop()] = arr[i];
                }
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            res[stack.pop()] = -1;
        }

        for (int r : res) {
            bw.write(r + " ");
        }

        bw.close();
        br.close();
    }
}