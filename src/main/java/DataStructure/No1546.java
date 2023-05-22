package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] grade = br.readLine().split(" ");

        int max = 0;
        for (String s : grade) {
            int num = Integer.parseInt(s);
            if (max < num)  max = num;
        }

        double sum = 0;
        for (String s : grade) {
            double num = Double.parseDouble(s);
            sum += num / max * 100;
        }
        System.out.println(sum / n);
    }
}
