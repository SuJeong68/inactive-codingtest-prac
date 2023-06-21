package Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class No1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        String[] splited = br.readLine().split("[-]");
        for (int i = 0; i < splited.length; i++, sum = 0) {
            StringTokenizer st = new StringTokenizer(splited[i], "+");
            while (st.hasMoreTokens()) {
                sum += Integer.parseInt(st.nextToken());
            }
            splited[i] = Integer.toString(sum);
        }

        sum = Integer.parseInt(splited[0]);
        for (int i = 1; i < splited.length; i++) {
            sum -= Integer.parseInt(splited[i]);
        }
        bw.write(Integer.toString(sum));

        bw.close();
        br.close();
    }
}