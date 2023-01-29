import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ01153 {
    public static boolean[] isPrime = new boolean[1_000_001];
    public static List<Integer> list = new ArrayList<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N < 8) {
            System.out.println(-1);
            return;
        }

        eratos();
        setList(N);
        getAnswer();
    }

    private static void getAnswer() {
        StringBuilder answer = new StringBuilder();
        for (int n : list) {
            answer.append(n).append(" ");
        }
        System.out.println(answer);
    }

    private static void setList(int N) {
        list.add(2);

        if (N % 2 == 0) {
            list.add(2);

            getGoldBach(N - 4);
        } else {
            list.add(3);

            getGoldBach(N - 5);
        }
    }

    public static void getGoldBach(int remain) {
        for (int i = 2; i <= remain / 2; i++) {
            if (!isPrime[i] && !isPrime[remain - i]) {
                list.add(i);
                list.add(remain - i);

                break;
            }
        }
    }

    public static void eratos() {
        isPrime[0] = isPrime[1] = true;

        for (int i = 2; i * i <= 1_000_000; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= 1_000_000; j += i) {
                    isPrime[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new BOJ01153().solution();
    }
}