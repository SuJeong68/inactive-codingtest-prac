package Sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1517 {
    private static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        divideAndConquer(arr);
        bw.write(Long.toString(answer));

        bw.close();
        br.close();
    }

    private static long[] divideAndConquer(long[] arr) {
        long[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
        long[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

        if (left.length > 1)   left = divideAndConquer(left);
        if (right.length > 1)  right = divideAndConquer(right);

        int ridx = 0, residx = 0, cnt = 0;
        long[] res = new long[arr.length];
        for (long l : left) {
            for (int r = ridx; r < right.length; r++) {
                if (l > right[r]) {
                    cnt++;
                    res[residx++] = right[r];
                    ridx = r + 1;
                } else {
                    break;
                }
            }
            answer += cnt;
            res[residx++] = l;
        }

        for (int r = ridx; r < right.length; r++) {
            res[residx++] = right[r];
        }

        return res;
    }
}