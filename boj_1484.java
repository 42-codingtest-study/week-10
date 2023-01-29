package math;

import java.util.Scanner;

public class boj_1484 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int G = scanner.nextInt();

        int start = 1;
        int end = 1;
        boolean flag = false;

        while(true){
            long diff = (long)(Math.pow(start,2))-(long)(Math.pow(end,2));
            if (start - end == 1 && diff > G) break;

            if (diff >= G)
                end++;
            else
                start++;

            if (diff == G) {
                System.out.println(start);
                flag = true;
            }
        }
        if (!flag)
            System.out.println(-1);
    }
}
