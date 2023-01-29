import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * [소수구하기 핵심]
 *
 * 시간 초과 문제 고려하기
 *
 * -> 반복문 횟수를 어떻게 줄일까?
 *
 * 1. 에라스토테네스의 체 활용
 *      - 소수의 특성을 활용해 소수 유무를 배열에 저장할 수 있다
 * 2. 중복을 허용햐지 않는 두 소수를 구하는 것이므로
 *      - 2부터 number /2 까지 두 숫자가 소수인지 확인한다
 */

public class BOJ17103 {

    public void solution() throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        boolean[] isPrime = new boolean[1000001];

        // 에라스토테네스의 체
        setPrime(isPrime);
        // 두 소수 갯수 구하기
        getCount(sb, br, isPrime);
        System.out.println(sb);
    }

    private static void getCount(StringBuilder sb, BufferedReader br, boolean[] isPrime)
        throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++){
            int number = Integer.parseInt(br.readLine());
            int sum = 0;
            for (int j = 2; j * 2 <= number; j++){
                if (isPrime[j] && isPrime[number - j])
                    sum++;
            }
            sb.append(sum).append("\n");
        }
    }

    private static void setPrime(boolean[] isPrime) {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        // i 가 소수라면 i * 1 를 true 로 설정
        for (int i = 2; i < 1000; i++) {
            if (!isPrime[i])
                continue;
            // 이후 모든 배수는 false
            for (int j = 2; i * j < 1000001; j++)
                isPrime[i * j] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        new BOJ17103().solution();
    }
}
