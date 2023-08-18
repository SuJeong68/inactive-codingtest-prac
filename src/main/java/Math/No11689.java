package Math;

import java.io.*;

public class No11689 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        long sum = n;
        // 에라토스테네스의 체 응용
        for (long k = 2; k * k <= n; k++) {
            // 소인수인 경우
            if (n % k == 0) {
                // 소인수가 아니게 될 때까지 n 값 나누기
                // if n == 20 이면 k == 2일 때,
                // 20 / 2 = 10 -> 10 / 2 = 5
                while (n % k == 0)
                    n /= k;
                sum *= 1 - 1 / (double) k;
            }
        }
        // if n == 10으로 시작할 시 k가 3까지 돌아 최대 소인수 5를 얻지 못함
        // 때문에 마지막에 10 / 2 => 5 가 남게 됨.
        if (n != 1)
            sum *= 1 - 1 / (double) n;
        bw.write(Long.toString(sum));

        br.close();
        bw.close();
    }
}