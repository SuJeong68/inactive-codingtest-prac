package Math;

import java.io.*;
import java.util.StringTokenizer;

public class No1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        StringBuilder res = new StringBuilder();
        for (long i = 0; i < gcd(Math.max(a, b), Math.min(a, b)); i++)
            res.append("1");

        bw.write(res.toString());

        br.close();
        bw.close();
    }

    private static long gcd(long max, long min) {
        while (max % min > 0) {
            long tmp = max;
            max = min;
            min = tmp % min;
        }
        return min;
    }
}