package DataStructure;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) < Math.abs(o2)) {
                    return -1;
                } else if (Math.abs(o1) > Math.abs(o2)) {
                    return 1;
                } else {
                    if (o1 < o2)    return -1;
                    else            return 1;
                }
            }
        });

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input != 0) {
                pq.add(input);
            } else {
                if (pq.isEmpty())   bw.write("0\n");
                else                bw.write(pq.poll() + "\n");
            }
        }

        bw.close();
        br.close();
    }
}