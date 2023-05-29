package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int num = 1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input >= num) {
                while (num <= input) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int p = stack.pop();
                if (input > p) {
                    System.out.println("NO");
                    return;
                }
                sb.append("-\n");
            }
        }
        System.out.println(sb);

        br.close();
    }
}