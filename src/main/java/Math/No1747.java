package Math;

import java.io.*;

public class No1747 {
    private static final int MAX_N = 1003001;
    private static boolean[] prime = new boolean[MAX_N + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 2; i <= MAX_N; i++) {
            prime[i] = true;
        }

        for (int i = 2; i < Math.sqrt(MAX_N); i++) {
            for (int j = i + i; j <= MAX_N; j += i) {
                prime[j] = false;
            }
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = n; i <= MAX_N; i++) {
            if (!prime[i])
                continue;

            String num = Integer.toString(i);
            if (isPalindrome(num, num.length())) {
                bw.write(num);
                break;
            }
        }

        bw.close();
        br.close();
    }

    private static boolean isPalindrome(String num, int len) {
        for (int i = 0; i < (double) len / 2; i++) {
            if (num.charAt(len - 1 - i) != num.charAt(i))
                return false;
        }
        return true;
    }
}