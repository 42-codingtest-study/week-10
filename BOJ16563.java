import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16563 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] isPrime = eratos();

        int a = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");
        getResult(sb, isPrime, a, s);

        System.out.println(sb);
    }

    private static void getResult(StringBuilder sb, boolean[] isPrime, int a, String[] s) {
        for (int i = 0; i < a; i++) {
            int x = Integer.parseInt(s[i]);
            int p = 2;
            while (x != 1 && p <= 2237) {
                if(!isPrime[p]) {
                    while (x % p == 0) {
                        x /= p;
                        sb.append(p).append(" ");
                    }
                }
                p++;
            }
            if(x!=1) sb.append(x);
            sb.append("\n");
        }
    }

    private static boolean[] eratos() {
        boolean[] isPrime = new boolean[2238];
        for (int i = 2; i <= 2237; i++) {
            if (isPrime[i])
                continue;
            for (int j = 2; i * j <= 2237; j++)
                isPrime[i * j] = true;
        }
        return isPrime;
    }

    public static void main(String[] args) throws IOException {
        new BOJ16563().solution();
    }
}
