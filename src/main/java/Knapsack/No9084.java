package Knapsack;

import java.io.*;
import java.util.StringTokenizer;

public class No9084 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] coins = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }

            bw.write(getWayCount(coins, Integer.parseInt(br.readLine())));
            bw.newLine();
        }

        bw.close();
        br.close();
    }

    public static String getWayCount(int[] coins, int target) {
        int[] tmp = new int[target + 1];
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (0 > j - coins[i])
                    continue;
                tmp[j] = 0 < j - coins[i] ? tmp[j] + tmp[j - coins[i]] : tmp[j] + 1;
            }
        }
        return Integer.toString(tmp[target]);
    }
}