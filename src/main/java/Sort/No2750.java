package Sort;

import java.io.*;
import java.util.Arrays;

public class No2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        Arrays.stream(arr).forEach(a -> {
            try {
                bw.write(a + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        bw.close();
        br.close();
    }
}