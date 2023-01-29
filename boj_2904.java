package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2904 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        ArrayList<Integer> primeNumbers = getPrimeNumbers(1_000_000);
        int N = Integer.parseInt(br.readLine());

        int[] visited = new int[1_000_001];
        int[][] v = new int[N][primeNumbers.size()];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            int score;
            score = Integer.parseInt(st.nextToken());

            for (int j = 0; j < primeNumbers.size(); j++){
                if (score == 1) break;

                while (score % primeNumbers.get(j) == 0){
                    score /= primeNumbers.get(j);
                    visited[primeNumbers.get(j)]++;
                    v[i][j]++;
                }
            }
        }
        int gcd = 1;
        int cnt = 0;
        for (int i = 0; i < primeNumbers.size(); i++){
            int d = visited[primeNumbers.get(i)] / N;

            for (int j = 0; j < N; j++) {
                if (v[j][i] < d){
                    cnt += d - v[j][i];
                }
            }
            gcd *= Math.pow(primeNumbers.get(i),d);
        }
        bw.write(gcd + " " + cnt);
        bw.flush();
        bw.close();
    }

    // 특정 범위 내의 소수 구하기 - 에라토스테네스의 체 활용
    private static ArrayList<Integer> getPrimeNumbers(int LIMIT) {
        ArrayList<Integer> prime = new ArrayList<>();
        boolean[] isPrime = new boolean[LIMIT + 1]; // int 범위 벗어나면 못함

        //처음에 모두 소수라고 가정
        Arrays.fill(isPrime, true);

        //2 부터 sqrt(n) 까지
        for (int i = 2; i * i <= LIMIT; i++) {
            // 이미 지워진 수는 무시
            if (!isPrime[i]) {
                continue;
            }

            for (int j = i * i; j <= LIMIT; j += i) {
                // 그 배수들은 모두 제외
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
