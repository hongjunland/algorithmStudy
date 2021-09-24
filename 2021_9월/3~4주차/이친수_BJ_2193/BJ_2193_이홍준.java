package bj.week5;

import java.util.Scanner;

public class BJ_2193_이홍준 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long a = 0;
        long b = 1;
        long c = a+b;
        for(int i = 1; i <= num ; i++){
            a = b;
            b = c;
            c = a+b;
        }
        System.out.println(a);
    }
}
