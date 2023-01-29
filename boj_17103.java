package math;

import java.util.Scanner;

public class boj_17103 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean[] isPrime = new boolean[1000001];
        isPrime[1] = true;
        for (int i = 2; i <= 1000000; i++){
            if (!isPrime[i]){
                for (int j = i * 2; j<=1000000; j += i){
                    isPrime[j] = true;
                }
            }
        }

        int T = scanner.nextInt();
        for (int i = 0; i < T; i++){
            int N = scanner.nextInt();
            int cnt = 0;
            for (int j = 2; j <= N / 2 ; j++){
                if (!isPrime[j] && !isPrime[N - j])
                    ++cnt;
            }
            System.out.println(cnt);
        }
    }

}
