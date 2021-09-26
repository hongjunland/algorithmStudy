package com.company;

import java.util.Scanner;

public class BJ_1011_이홍준 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1 ; test_case<=T; test_case++){
            long X = sc.nextLong();
            long Y = sc.nextLong();
            Y = Y-X;
            long sum = 0;
            long cnt = 0;
            long step = 0;
            boolean up = true;
            while (sum<Y){
                cnt++;
                if(up) step++;
                sum+=step;
                up = !up;
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}
