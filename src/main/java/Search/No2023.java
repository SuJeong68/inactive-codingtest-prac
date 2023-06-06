package Search;

import java.io.*;

public class No2023 {

    private static int n;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        if (n == 1) {
            sb.append(2).append("\n");
            sb.append(3).append("\n");
            sb.append(5).append("\n");
            sb.append(7).append("\n");
        }

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);

        bw.write(sb.toString());

        bw.close();
        br.close();
    }

    private static void DFS(int primeNumber, int cnt) {
        if (cnt >= n)  return;

        for (int i = 1; i < 10; i++) {
            int num = primeNumber * 10 + i;
            if (isPrimeNumber(num)) {
                if (cnt == n - 1)
                    sb.append(num).append("\n");
                else
                    DFS(num, cnt + 1);
            }
        }
    }

    private static boolean isPrimeNumber(int num) {
        for (int i = 2; i < Math.sqrt(num) + 1; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}