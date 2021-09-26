package com.company;

import java.util.Scanner;

public class BJ_11726_이홍준 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long a = 1;
        long b = 2;
        long c = a+b;
        for(int i = 2 ; i < N ; i++) {
            a = b;
            b = c;
            c = (a + b)%10007;
        }
        if(N==1) b = 1;
        System.out.println(b);

    }
}
