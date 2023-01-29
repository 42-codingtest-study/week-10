package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1990 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 특정 범위 내의 소수 구하기
        boolean[] isNotPrime = new boolean[100_000_001]; // int 범위 벗어나면 못함
        // 1은 소수가 아니다
        isNotPrime[1] = true;
        for (int i = 2; i <= 100_000_000; i++)
        // 소수이면
        {
            if (!isNotPrime[i])
            // 그 배수들은 모두 제외
            {
                for (int j = i * 2; j <= 100_000_000; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        for (int i = a; i <= b; i++) {
            if (!isNotPrime[i]) {
                int len = getLength(i);
                String tmp = String.valueOf(i);
                boolean flag = isPelindrom(len, tmp);
                if (flag) {
                    System.out.println(tmp);
                }
            }
        }
        System.out.println(-1);
    }

    private static boolean isPelindrom(int len, String tmp) {
        for (int j = 0; j < len / 2; j++) {
            if (tmp.charAt(j) != tmp.charAt(len -1 -j)) {
                return false;
            }
        }
        return true;
    }

    private static int getLength(long num) {
        int cnt = 0;
        while (num != 0) {
            cnt++;
            num /= 10;
        }
        return cnt;
    }
}

