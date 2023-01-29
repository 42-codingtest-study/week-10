import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * [약수를 활용한 문제풀이]
 *
 * (a^2 −b^2=G)인 방정식
 * (a+b)(a−b) = G = x ∗ y
 * 2a = x + y
 */

public class BOJ01484 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set = new HashSet<>();
        TreeSet<Integer> ans = new TreeSet<>();       //오름차순 출력

        int G = Integer.parseInt(br.readLine());

        setDivisor(set, G);
        gerAnswer(set, ans, G);
        printResult(ans);
    }

    private static void printResult(TreeSet<Integer> ans) {
        if(ans.size()==0)
            System.out.println(-1);

        else {
            for (int answer : ans)
                System.out.println(answer);
        }
    }

    private static void gerAnswer(HashSet<Integer> set, TreeSet<Integer> ans, int G) {
        for (int num : set) {
            if ((num + (G / num)) % 2 == 0 && num != (G / num)) {
                int sum = (num + (G / num)) / 2;
                ans.add(sum);
            }
        }
    }

    private static void setDivisor(HashSet<Integer> set, int G) {
        for (int i=1; i<=Math.sqrt(G); i++) {
            if (G % i == 0) {          //자연수인 약수
                set.add(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new BOJ01484().solution();
    }
}
