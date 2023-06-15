package Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class No11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for (int i = n - 1; i >= 0;) {
            if (k - arr[i] >= 0) {
                k -= arr[i];
                cnt++;
            } else {
                i--;
            }
        }
        bw.write(Integer.toString(cnt));

        bw.close();
        br.close();
    }
}
