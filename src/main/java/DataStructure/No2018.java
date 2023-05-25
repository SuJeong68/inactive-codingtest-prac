package DataStructure;

import java.io.*;

public class No2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 1;
        int tail = (n % 2 == 1) ? (n / 2 + 1) : (n / 2);
        int head = tail - 1;

        while (head < tail && head != 0) {
            long sum = calc(head, tail);
            if (sum == n) {
                cnt++;
                head--; tail--;
            } else if (sum < n) {
                head--;
            } else {
                tail--;
            }
        }
        System.out.println(cnt);
    }

    private static long calc(int head, int tail) {
        int sum = 0;
        for (int i = head; i <= tail; i++) {
            sum += i;
        }
        return sum;
    }
}
