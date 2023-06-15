package Search;

import java.io.*;

public class No1300 {
    private static long n;
    private static long k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Long.parseLong(br.readLine());
        k = Long.parseLong(br.readLine());

        bw.write(Long.toString(binarySearch(1, k)));

        bw.close();
        br.close();
    }

    private static long binarySearch(long start, long end) {
        while (start < end) {
            long mid = (start + end) / 2;
            long count = getCount(mid);
            if (count < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private static long getCount(long target) {
        long count = 0;
        for (long i = 1; i <= n; i++) {
            count += Math.min(target / i, n);
        }
        return count;
    }
}
