package Math;

import java.io.*;

public class No1016 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        long min = Long.parseLong(input[0]);
        long max = Long.parseLong(input[1]);

        boolean[] arr = new boolean[(int) (max - min + 1)];
        for (int i = 2; i <= Math.sqrt(max); i++) {
            long squareNumber = (long) Math.pow(i, 2);
            for (long j = min / squareNumber; j * squareNumber <= max; j++) {
                if (min > j * squareNumber)
                    continue;
                arr[(int) (j * squareNumber - min)] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i])
                count++;
        }
        bw.write(Integer.toString(count));

        bw.close();
        br.close();
    }
}