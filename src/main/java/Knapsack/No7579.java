package Knapsack;

import java.io.*;
import java.util.StringTokenizer;

public class No7579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        App[] apps = new App[n + 1];
        StringTokenizer stM = new StringTokenizer(br.readLine());
        StringTokenizer stC = new StringTokenizer(br.readLine());

        int maxCost = 0;
        for (int i = 1; i <= n; i++) {
            int cost = Integer.parseInt(stC.nextToken());
            apps[i] = new App(Integer.parseInt(stM.nextToken()), cost);
            maxCost += cost;
        }

        int[] tmp = new int[maxCost + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = maxCost; j != 0 && j >= apps[i].c; j--) {
                tmp[j] = Math.max(tmp[j], tmp[j - apps[i].c] + apps[i].m);
            }
        }

        for (int i = 1; i <= maxCost; i++) {
            if (tmp[i] >= m) {
                bw.write(Integer.toString(i));
                break;
            }
        }

        bw.close();
        br.close();
    }

    public static class App {
        int m;
        int c;

        public App(int m, int c) {
            this.m = m;
            this.c = c;
        }
    }
}