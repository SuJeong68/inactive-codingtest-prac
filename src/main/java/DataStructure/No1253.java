package DataStructure;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(Integer.valueOf(st.nextToken()));
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = queue.poll();
        }

        int cnt = 0, target = n - 1;
        while (target >= 0) {
            int index = 0;
            int[] newArr = new int[n-1];
            for (int i = 0; i < n; i++) {
                if (target != i) {
                    newArr[index++] = arr[i];
                }
            }

            if (isGood(newArr, arr[target--]))  cnt++;
        }
        bw.write(String.valueOf(cnt));

        bw.close();
        br.close();
    }

    public static boolean isGood(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == target) return true;

            if (sum >= target)  end--;
            else                start++;
        }
        return false;
    }
}