package DataStructure;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No12891 {
    private static final int DNA_CHAR_COUNT = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        String[] dna = br.readLine().split("");

        Map<String, Integer> minCnt = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        minCnt.put("A", Integer.valueOf(st.nextToken()));
        minCnt.put("C", Integer.valueOf(st.nextToken()));
        minCnt.put("G", Integer.valueOf(st.nextToken()));
        minCnt.put("T", Integer.valueOf(st.nextToken()));

        int cnt = 0, index = 0, pCnt = 0;
        int[] tempCnt = new int[DNA_CHAR_COUNT];
        while (index < s) {
            if (pCnt == p) {
                deleteHead(p, dna, index, tempCnt);
            } else {
                pCnt++;
            }

            addTail(dna, index, tempCnt);
            if (p == pCnt) {
                if (minCnt.get("A") <= tempCnt[0] && minCnt.get("C") <= tempCnt[1] &&
                        minCnt.get("G") <= tempCnt[2] && minCnt.get("T") <= tempCnt[3]) {
                    cnt++;
                }
            }
            index++;
        }
        bw.write(String.valueOf(cnt));

        bw.close();
        br.close();
    }

    private static void addTail(String[] dna, int index, int[] tempCnt) {
        switch (dna[index]) {
            case "A":
                tempCnt[0]++;
                break;
            case "C":
                tempCnt[1]++;
                break;
            case "G":
                tempCnt[2]++;
                break;
            case "T":
                tempCnt[3]++;
                break;
        }
    }

    private static void deleteHead(int p, String[] dna, int index, int[] tempCnt) {
        switch (dna[index - p]) {
            case "A":
                tempCnt[0]--;
                break;
            case "C":
                tempCnt[1]--;
                break;
            case "G":
                tempCnt[2]--;
                break;
            case "T":
                tempCnt[3]--;
                break;
        }
    }
}