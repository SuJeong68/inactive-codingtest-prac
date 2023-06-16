package Greedy;

import java.io.*;
import java.util.PriorityQueue;

public class No1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> bundleSize = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            bundleSize.add(Long.parseLong(br.readLine()));
        }

        long sum = 0;
        while (bundleSize.size() != 1) {
            long temp = bundleSize.poll() + bundleSize.poll();
            sum += temp;
            bundleSize.add(temp);
        }
        bw.write(Long.toString(sum));

        bw.close();
        br.close();
    }
}