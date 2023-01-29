import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [소수 + 펠린드롬]
 *
 * 에라스토테네스 활용
 * 팰린드롬인지 검사
 */

public class BOJ01990 {
    public static boolean[] isPrime = new boolean[100_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        eratos();

        StringBuilder sb = getResult(a, b);

        System.out.println(sb);
    }

    private static StringBuilder getResult(int a, int b) {
        StringBuilder sb = new StringBuilder();
        for (int i = a; i <= b; i++) {
            if (!isPrime[i] && isPalindrome(i)) {
                sb.append(i).append("\n");
            }
        }
        sb.append(-1);
        return sb;
    }

    public static boolean isPalindrome(int n) {
        String t = String.valueOf(n);

        for (int i = 0; i < t.length() / 2; i++) {
            if (t.charAt(i) != t.charAt(t.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void eratos() {
        isPrime[0] = isPrime[1] = true;

        for (int i = 2; i * i <= 100_000_000; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= 100_000_000; j += i) {
                    isPrime[j] = true;
                }
            }
        }
    }
}