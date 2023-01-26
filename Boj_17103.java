import java.io.BufferedReader;
import java.util.*;

public class Boj_17103 {

    public static void main(String[] args) {
        int tc;
        Scanner scanner = new Scanner(System.in);
        tc = Integer.parseInt(scanner.nextLine());
        int table[] = new int[1000002];

        for (int i = 2; i <= 1000; i++) {
            int j = i;
            if (table[i] == 0) {
                for(j = 2; i * j <= 1000000; j++) {
                    table[i * j] = 1;
                }
            }


        }

//        for (int i = 1; i <= 1000; i++) {
//            if (table[i] != 1) {
//                System.out.print(i + " ");
//            }
//        }
        //System.out.println();
        //소수 테이블을 완성하자.
        for (int idx = 0; idx < tc; idx++) {
            int cnt = 0;
            int n = Integer.parseInt(scanner.nextLine());
            for (int i = 2; i <= n/2; i++) {
                if (table[i] != 1) {
                    if (table[n - i] != 1) {
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
