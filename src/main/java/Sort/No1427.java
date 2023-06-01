package Sort;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class No1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            return o1 >= o2 ? -1 : 1;
        });
        Arrays.stream(br.readLine().split("")).forEach(n -> queue.add(Integer.parseInt(n)));

        while (queue.size() > 0) {
            bw.write(Integer.toString(queue.poll()));
        }

        bw.close();
        br.close();
    }
}