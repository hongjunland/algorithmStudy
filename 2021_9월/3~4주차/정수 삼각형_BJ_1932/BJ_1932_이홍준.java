package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1932_이홍준 {
    static int[][] Mat;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Mat = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            for (int j = 0; j < i+1; j++) {
                Mat[i][j] = sc.nextInt();
            }
        }
        for(int i = 1 ; i < N ; i++){
            for(int j = 0 ; j <= i ; j++){
                if(j==0) Mat[i][j]+=Mat[i-1][j];
                else if(j==i) Mat[i][j]+=Mat[i-1][j-1];
                else Mat[i][j] += Math.max(Mat[i-1][j-1],Mat[i-1][j]);
            }
        }
        Arrays.sort(Mat[N-1]);
        System.out.println(Mat[N-1][N-1]);
    }
}
