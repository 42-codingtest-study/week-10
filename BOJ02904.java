import java.io.*;
import java.util.*;

public class BOJ02904 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] t = eratos();

        ArrayList<Integer> ka = getPrimeNumbr(t);

        int a = Integer.parseInt(br.readLine());

        int[] k = calculateScore(br, t, ka, a);
        getAnswer(t, a, k);
    }

    private static int[] calculateScore(BufferedReader br, int[] t, ArrayList<Integer> ka, int a)
        throws IOException {
        int[] k=new int[a];
        String[] s = br.readLine().split(" ");
        for(int i=0; i< a; i++){
            k[i]=Integer.parseInt(s[i]);
            int r=k[i];
            for(int j=0; j< ka.size() && r!=1; j++){
                while(r% ka.get(j)==0){
                    t[ka.get(j)]++;
                    r/= ka.get(j);
                }
            }
        }
        return k;
    }

    private static ArrayList<Integer> getPrimeNumbr(int[] t) {
        ArrayList<Integer> ka=new ArrayList<>();
        for (int i=2; i<=1000000; i++) {
            if (t[i]!=-1) ka.add(i);
        }
        return ka;
    }

    private static void getAnswer(int[] t, int a, int[] k) {
        long r=1;
        int c=0;
        for(int i=2; i<=1000000; i++){
            if(t[i]>= a){
                r*=(long)Math.pow(i, t[i]/ a);
                for(int j=0; j< a; j++) {
                    int n = k[j], p = 0;
                    while (n % i == 0) {
                        n /= i;
                        p++;
                    }
                    c +=Math.max(0, t[i]/ a -p);
                }
            }
        }
        System.out.println(r+" "+c);
    }

    private static int[] eratos() {
        int[] t=new int[1000001];
        for(int i=2; i<=1000000; i++){
            if(t[i]==-1) continue;
            for(int j=2; i*j<=1000000; j++) t[i*j]=-1;
        }
        return t;
    }

    public static void main(String[] args) throws IOException {
        new BOJ02904().solution();
    }
}