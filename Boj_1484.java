import java.util.*;

public class Boj_1484 {

    public static void main(String[] args) {
        int g;
        Scanner scanner = new Scanner(System.in);
        g = Integer.parseInt(scanner.nextLine());
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= g/2; i++) {
            int a = i;
            if (g % a == 0) {
                int b = g/a;
                //System.out.println("a and b are " + a + " " + b);
                int result = getTwoVal(a, b);
                if (result != -1) {
                    answer.add(result);
                }
            }
        }
        if (answer.size() == 0) {
            System.out.println(-1);
            return;
        }
        Collections.sort(answer);
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }

    public static int getTwoVal(int minus, int plus) {
        int prev, now;

        for (int i = 1; i < plus; i++) {
            prev = i;
            now = minus + prev;
            if (prev + now == plus) {
                return now;
            }
        }
        return -1;
    }

    public static class Pair {
        int left, right;
        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

}
