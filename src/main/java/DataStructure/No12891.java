package DataStructure;

import java.io.*;
import java.util.StringTokenizer;

public class No12891 {
    private static final int DNA_CHAR_COUNT = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        char[] dna = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int cnt = 0, index = 0, pCnt = 0;
        int[] tempCnt = new int[DNA_CHAR_COUNT];
        while (index < s) {
            if (pCnt == p) {
                deleteHead(dna[index - p], tempCnt);
            } else {
                pCnt++;
            }

            addTail(dna[index], tempCnt);
            if (p == pCnt) {
                if (a <= tempCnt[0] && c <= tempCnt[1] && g <= tempCnt[2] && t <= tempCnt[3]) {
                    cnt++;
                }
            }
            index++;
        }
        bw.write(String.valueOf(cnt));

        bw.close();
        br.close();
    }

    private static void addTail(char ch, int[] tempCnt) {
        switch (ch) {
            case 'A':
                tempCnt[0]++;
                break;
            case 'C':
                tempCnt[1]++;
                break;
            case 'G':
                tempCnt[2]++;
                break;
            case 'T':
                tempCnt[3]++;
                break;
        }
    }

    private static void deleteHead(char ch, int[] tempCnt) {
        switch (ch) {
            case 'A':
                tempCnt[0]--;
                break;
            case 'C':
                tempCnt[1]--;
                break;
            case 'G':
                tempCnt[2]--;
                break;
            case 'T':
                tempCnt[3]--;
                break;
        }
    }
}