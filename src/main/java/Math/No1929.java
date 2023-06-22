package Math;

import java.io.*;
import java.util.StringTokenizer;

public class No1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            arr[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!arr[i])
                continue;

            for (int j = i * 2; j <= n; j += i) {
                arr[j] = false;
            }
        }

        for (int i = m; i <= n; i++) {
            if (arr[i])
                bw.write(i + "\n");
        }

        bw.close();
        br.close();
    }
}