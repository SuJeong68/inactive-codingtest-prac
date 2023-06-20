package Greedy;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1931 {
    private static PriorityQueue<Meeting> pq = new PriorityQueue<>((o1, o2) -> {
        if (o1.endTime > o2.endTime) {
            return 1;
        } else if (o1.endTime < o2.endTime) {
            return -1;
        } else {
            return o1.startTime - o2.startTime;
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int count = 0;
        int start = -1;
        while (!pq.isEmpty()) {
            Meeting meeting = pq.poll();
            if (meeting.endTime - meeting.startTime == 0) {
                count++;
                start = meeting.endTime;
                continue;
            }

            if (start > meeting.startTime) {
                continue;
            }

            count++;
            start = meeting.endTime;
        }
        bw.write(Integer.toString(count));


        bw.close();
        br.close();
    }

    public static class Meeting {
        int startTime;
        int endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}