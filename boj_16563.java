package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_16563 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // 특정 범위 내의 소수 구하기
        boolean[] isNotPrime = new boolean[5_000_001]; // int 범위 벗어나면 못함
        int[] minFactor = new int[5_000_0001];
        // 1은 소수가 아니다
        isNotPrime[1] = true;
        for(int i = 2; i <= 5_000_000; i++){
            minFactor[i] = i;
        }

        for (int i = 2; i * i <= 5_000_000; i++) {
            // 소수이이면
            if (!isNotPrime[i])
            // 그 배수들은 모두 제외
            {
                for (int j = i * i; j <= 5_000_000; j += i) {
                    if (!isNotPrime[j])
                        minFactor[j] = i;
                    isNotPrime[j] = true;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Integer num = Integer.valueOf(st.nextToken());
            while (num > 1){
                bw.write(minFactor[num] + " ");
                num /= minFactor[num];
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

//    private static void printPrime(Integer num, ArrayList<Integer> prime) {
//        for (Integer primeNumber : prime) {
//            num = divideByPrime(num, primeNumber);
//            if (num == 1) break;
//        }
//        System.out.println();
//    }
//
//    private static Integer divideByPrime(Integer num, int i) {
//        if (num % i == 0) {
//            num /= i;
//            System.out.print(i + " ");
//            return divideByPrime(num, i);
//        } else {
//            return num;
//        }
//    }

}
