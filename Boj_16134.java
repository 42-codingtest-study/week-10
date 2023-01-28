import java.math.BigInteger;
import java.util.*;

public class Boj_16134 {
    public static void main(String[] args) {

        long n, r;
        Scanner scanner = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(scanner.nextLine());

        n = Long.parseLong(st.nextToken());
        r = Long.parseLong(st.nextToken());

        long a = 1;
        long b = 1;
        for (int i = 0; i < r; i++) {
            a = a * (n-i) % 1000000007;
            b = b * (r-i) % 1000000007;
        }
        long ans = (a % 1000000007 * div(b, 1000000005)% 1000000007)%1000000007;
        System.out.println(ans);
        //System.out.println(a%1000000007);
    }

    public static long div(long a, long  b) {
        if (b== 1)
            return a;
        long tmp = div(a, b/2);
        if (b % 2 == 1) {
            return tmp*tmp%1000000007*a%1000000007;
        }
        else return tmp*tmp%1000000007;
    }

}

