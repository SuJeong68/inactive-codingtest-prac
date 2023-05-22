package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] line = br.readLine().toCharArray();

        int sum = 0;
        for (char ch : line) {
            sum += Integer.parseInt(String.valueOf(ch));
        }
        System.out.println(sum);
    }
}
