package Greedy;

import java.io.*;
import java.util.PriorityQueue;

public class No1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minuspq = new PriorityQueue<>();
        PriorityQueue<Integer> pluspq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num <= 0)
                minuspq.add(num);
            else if (num == 1)
                sum++;
            else
                pluspq.add(num);
        }

        int x, y;
        while (!minuspq.isEmpty()) {
            x = minuspq.poll();
            if (x == 0 || minuspq.isEmpty()) {
                sum += x;   break;
            }

            y = minuspq.poll();
            sum += x * y;
        }

        while (!pluspq.isEmpty()) {
            x = pluspq.poll();
            if (pluspq.isEmpty()) {
                sum += x;   break;
            }

            y = pluspq.poll();
            sum += x * y;
        }

        bw.write(Long.toString(sum));

        bw.close();
        br.close();
    }
}