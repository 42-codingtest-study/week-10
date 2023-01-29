package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class boj_1153 {

    // 빠른 입력
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 빠른 출력
    // 버퍼를 잡아 놓았기 때문에 bw.flush(); bw.close(); 를 반드시 호출 해주어야 한다.
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] f_num = new int[4];
    static ArrayList<Integer> prime;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        prime = getPrimeNumbers(1_000_000);

        if(n < 8) {
            System.out.println(-1);
            return;
        }else {
            if(n % 2 ==0) {
                n -= 4;
                goldbach(n);
                f_num[0] = f_num[1] = 2;
            }else {
                n -= 5;
                goldbach(n);
                f_num[0] = 2;
                f_num[1] = 3;
            }
        }

        for (int i = 0; i < 4; i++){
            System.out.print(f_num[i] + " ");
        }
    }

    private static void goldbach(int num) {
        for(int i=0; i<prime.size(); i++) {

            for(int j=0; j<prime.size(); j++) {
                int sum = prime.get(i) + prime.get(j);

                if(sum == num) {
                    f_num[2] = prime.get(i);
                    f_num[3] = prime.get(j);
                    return;
                }else if(sum > num) {
                    break;
                }
            }
        }
    }

    private static ArrayList<Integer> getPrimeNumbers(int LIMIT) {
        ArrayList<Integer> prime = new ArrayList<>();
        boolean[] isPrime = new boolean[LIMIT + 1]; // int 범위 벗어나면 못함

        for (int i = 2; i <= LIMIT; i++) {
            //처음에 모두 소수라고 가정
            isPrime[i] = true;
        }
        //2 부터 sqrt(n) 까지
        for (int i = 2; i * i <= LIMIT; i++) {
            // 이미 지워진 수는 무시
            if (!isPrime[i]) {
                continue;
            }

            for (int j = i * i; j <= LIMIT; j += i) {
                //그 배수들은 모두 제외
                isPrime[j] = false;
            }
        }

        //소수 모으기
        for(int i = 2; i<= LIMIT; i++)
            if (isPrime[i])
                prime.add(i);
        return prime;
    }

}
