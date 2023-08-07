package Math;

import java.io.*;
import java.util.StringTokenizer;

public class No1456 {
    private static final int PRIME_MAX = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        boolean[] prime = new boolean[PRIME_MAX + 1];
        for (int i = 2; i < prime.length; i++) {
            prime[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (!prime[i])
                continue;
            for (int j = i + i; j < prime.length; j += i)
                prime[j] = false;
        }

        int count = 0;
        for (int i = 2; i <= PRIME_MAX; i++) {
            if (prime[i]) {
                long tmp = i;
                while (i <= b / (double) tmp) {
                    if (a / (double) tmp <= i)
                        count++;
                    tmp *= i;
                }
            }
        }
        bw.write(Integer.toString(count));

        bw.close();
        br.close();
    }
}