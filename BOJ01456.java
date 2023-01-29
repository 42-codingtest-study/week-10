import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 10^7 의 제곱은 10^14 이므로 10^7 보다 큰 수들은 소수 여부를 판별하지 않아도 된다
 * 에라스토테네스의 체를 활용한다
 *  2부터 B보다 작거나 같은 거의 소수들을 리스트에 담는다
 *  리스트의 사이즈는 0 <= 거의 소수 <= B 의 개수이므로
 *  A보다 같거나 작은 거의 소수의 개수를 빼준다
 *  이분탐색으로 구한다
 */
public class BOJ01456 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1 ≤ A ≤ B ≤ 10^14
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int max = 10000000;

        boolean[] prime = eratos(max);

        ArrayList<Long> list = getPrimeNumber(b, max, prime);

        Collections.sort(list);

        int left = binarySearch(a, list);

        System.out.println(list.size() - left);
    }

    private static int binarySearch(long a, ArrayList<Long> list) {
        int left = 0;
        int right = list.size()-1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(list.get(mid) >= a) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    private static ArrayList<Long> getPrimeNumber(long b, int max, boolean[] prime) {
        ArrayList<Long> list = new ArrayList<Long>();
        for(int i = 2; i <= max; i++) {
            if(b <= i) break;
            if(!prime[i]) {
                for(int j = 2; true; j++) {
                    if((long)Math.pow(i, j) > b) break;
                    list.add((long)Math.pow(i, j));
                }
            }
        }
        return list;
    }

    private static boolean[] eratos(int max) {
        boolean prime[] = new boolean[max + 1];
        for (int i = 2; i <= max; i++)
            for (int j = i * 2; j <= max; j += i)
                prime[j] = true;
        return prime;
    }

    public static void main(String[] args) throws IOException {
        new BOJ01456().solution();
    }

}
