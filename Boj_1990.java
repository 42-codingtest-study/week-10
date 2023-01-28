import java.util.*;

public class Boj_1990 {
    public static void main(String[] args) {
        int a, b;
        Scanner scanner = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(scanner.nextLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        Set<Integer> sosuList = new HashSet<>();

        for (int i = a; i <= b; i++) {
            if (check_pelin(i) == true)
            {
               // System.out.println("pelin succeed : " + i);
                if (check_sosu(i, b) == true) {
                    System.out.println(i);
                }
            }
        }

        System.out.println(-1);
    }

    public static boolean check_sosu(int n, int b) {

        if (n == 2 || n == 3 || n == 5 || n == 7) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(b); i++) {
            if (i == n) {
                continue;
            }
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean check_pelin(int n) {

        Deque<Integer> dq = new LinkedList<>();
        String toStr = n + "";

        if (toStr.length() == 1)
            return true;
        for (int i = 0; i < toStr.length() / 2; i++) {
            if (toStr.charAt(i) != toStr.charAt(toStr.length() - i-1)) {
                return false;
            }
        }
        return true;

    }
}
