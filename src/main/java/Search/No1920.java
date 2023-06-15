package Search;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1920 {
    private static int[] sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sorted = Arrays.stream(arr).sorted().toArray();

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            bw.write(find(Integer.parseInt(st.nextToken()), 0, sorted.length - 1) + "\n");
        }

        bw.close();
        br.close();
    }

    public static String find(int input, int start, int end) {
        if (start > end)    return "0";
        
        int middle = (start + end) / 2;
        if (sorted[middle] == input) {
            return "1";
        } else if (sorted[middle] > input) {
            return find(input, start, middle - 1);
        } else {
            return find(input, middle + 1, end);
        }
    }
}