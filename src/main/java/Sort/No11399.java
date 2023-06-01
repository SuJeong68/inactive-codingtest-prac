package Sort;

import java.io.*;
import java.util.Arrays;

public class No11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Integer[] arr = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .toArray(Integer[]::new);

        int res = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            res += sum;
        }
        bw.write(Integer.toString(res));

        bw.close();
        br.close();
    }
}