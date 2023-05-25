package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int start = 0, end = n - 1;
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (st.hasMoreTokens()) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = pq.poll();
        }

        int cnt = 0;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == m)   cnt++;

            if (sum >= m) {
                sum -= arr[end];
                end--;
            }
            else {
                sum -= arr[start];
                start++;
            }
        }
        System.out.println(cnt);

        br.close();
    }
}