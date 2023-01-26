import java.util.*;

public class Boj_1456 {

    public static void main(String[] args) {
        long n ,m;
        Scanner scanner = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(scanner.nextLine());
        n = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());
//10^7 까지 소수 개수 세서 계속 제곱하면서 범위에 맞으면 리스트에 계속 넣는다
        List<Integer> primeList = new ArrayList<>();
        int table[] = new int[10000002];

        for (int i = 2; i*i <= 10000000; i++) {
            if (table[i] == 1) {
                continue;
            }
            for (int j = 2 * i; j <= 10000000; j += i) {
                table[j] = 1;
            }
        }

        int cnt = 0;
        Set<Long> s = new HashSet<>();

        for (long i = 2; i <= 10000000; i++) {
            if (table[(int)i] == 1) {
                continue;
            }
            long cur = i*i;
            while (cur <= m) {
                if (cur >= n) {
                    cnt++;
                }
                if ( i > 100000) break;
                cur *= i;
            }
        }

        System.out.println(cnt);
       // System.out.println(s.size());
    }

    public static int getAnswer(long value, long n, long m ,Set<Long> s) {

        int cnt = 0;
        long multied = 1;
        //System.out.println("beginning value " + value );
        multied = value * value;
        while (multied <= m) {
            //System.out.println("multied is " + multied);
            if (multied >= n) {
                s.add(multied);
            }
            multied = multied * value;
        }
        return cnt;
    }
}
