package Knapsack;

import java.io.*;
import java.util.StringTokenizer;

public class No2629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        StringTokenizer st;

        int[] weights = new int[Integer.parseInt(br.readLine())];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < weights.length; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
            sum += weights[i];
        }

        int[] beads = new int[Integer.parseInt(br.readLine())];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < beads.length; i++) {
            beads[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] table = new boolean[sum + 1];
        table[0] = true;

        for (int weight : weights) {
            for (int j = sum; j >= 0; j--) {
                if (table[j])
                    table[j + weight] = true;
            }
            for (int j = 0; j <= sum; j++) {
                if (table[j])
                    table[Math.abs(j - weight)] = true;
            }
        }

        for (int bead : beads) {
            if (bead > sum)
                bw.write("N ");
            else if (table[bead])
                bw.write("Y ");
            else
                bw.write("N ");
        }

        bw.close();
        br.close();
    }
}