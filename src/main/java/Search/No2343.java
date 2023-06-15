package Search;

import java.io.*;
import java.util.StringTokenizer;

public class No2343 {
    private static int n;
    private static int m;
    private static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 강의 개수
        m = Integer.parseInt(st.nextToken());   // 블루레이 개수

        int sum = 0, max = 0;
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }
        bw.write(Integer.toString(binarySearch(max, sum)));

        bw.close();
        br.close();
    }

    private static int binarySearch(int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (getBlurayCnt(mid) > m)
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }

    private static int getBlurayCnt(int mid) {
        int sum = 0, cnt = 1;
        for (int i = 0; i < n; i++) {
            if (sum + arr[i] > mid) {
                sum = 0;
                cnt++;
            }
            sum += arr[i];
        }
        return cnt;
    }
}