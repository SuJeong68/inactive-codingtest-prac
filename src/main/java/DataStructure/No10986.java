package DataStructure;

import java.io.*;
import java.util.StringTokenizer;

public class No10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long sum = 0;
        long count = 0;
        long[] remainder = new long[m];
        for (int i = 1; i <= n; i++) {
            sum += Long.parseLong(st.nextToken());
            remainder[(int)(sum % m)]++;
            if (sum % m == 0)   count++;
        }

        for (int i = 0; i < m; i++) {
            long r = remainder[i];
            for (int j = 1; j < r; j++) {
                count += r - j;
            }
        }
        bw.write(String.valueOf(count));

        bw.close();
        br.close();
    }
}
