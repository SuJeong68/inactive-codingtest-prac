package Sort;

import java.io.*;

public class No10989 {

    private static final int MAX = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] counts = new int[MAX];

        for (int i = 0; i < n; i++) {
            counts[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i < MAX; i++) {
            if (counts[i] != 0) {
                for (int j = 0; j < counts[i]; j++)
                    bw.write(i + "\n");
            }
        }

        bw.close();
        br.close();
    }
}