package Math;

import java.io.*;
import java.util.StringTokenizer;

public class No1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            bw.write(Long.toString(lcm(a, b)));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    // Least common multiple
    private static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    private static long gcd(long a, long b) {
        long min = Math.min(a, b);
        long max = Math.max(a, b);

        if (max % min == 0)
            return min;
        return gcd(min, max % min);
    }
}