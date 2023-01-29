package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1456 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        ArrayList<Integer> prime = getPrimeNumbers(B);

        // 그 소수들을 순회하면서 B 이하의 값들에서 소수의 N 제곱 있는지 확인
        int cnt = 0;
        for (Integer primNumber : prime) {
            int curCnt = getLength(primNumber);
            long tmp = primNumber;
            while ((tmp*= primNumber) <= B) {
                if (A <= tmp)
                    cnt++;
                int tmpCnt = getLength(tmp);
                if (curCnt + tmpCnt > 15)
                    break ;
            }
        }
        System.out.println(cnt);
    }

    // 특정 범위 내의 소수 구하기 - 에라토스테네스의 체 활용
    private static ArrayList<Integer> getPrimeNumbers(Long LIMIT) {
        int sqrtN = (int) Math.sqrt(LIMIT);
        ArrayList<Integer> prime = new ArrayList<>();
        boolean[] isNotPrime = new boolean[sqrtN + 1]; // int 범위 벗어나면 못함
        // 1은 소수가 아니다
        isNotPrime[1] = true;

        for (int i = 2; i <= sqrtN; i++) {
            // 소수이면
            if (!isNotPrime[i])
            {
                //소수만 모으고
                prime.add(i);
                for (int j = i * 2; j <= sqrtN; j += i) {
                    // 그 배수들은 모두 제외
                    isNotPrime[j] = true;
                }
            }
        }
        return prime;
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
