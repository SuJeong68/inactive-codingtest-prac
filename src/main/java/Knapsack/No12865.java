package Knapsack;

import java.io.*;
import java.util.StringTokenizer;

public class No12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Item[] items = new Item[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            items[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[] tmpBackpack = new int[k + 1];
        for (int i = 1; i <= n; i++) {
            Item item = items[i];
            for (int j = k; j >= item.w; j--) {
                tmpBackpack[j] = Math.max(tmpBackpack[j], tmpBackpack[j-item.w] + item.v);
            }
        }
        bw.write(Integer.toString(tmpBackpack[k]));

        bw.close();
        br.close();
    }

    public static class Item {
        int w;
        int v;

        public Item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}