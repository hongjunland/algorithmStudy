package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14503_이홍준 {
    static int N;
    static int M;
    static int[][] Mat;
    static final int[] dr = {-1,0,1,0};
    static final int[] dc = {0,1,0,-1};
    static int row;
    static int col;
    static int dir;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        Mat = new int[N][M];

        line = br.readLine().split(" ");
        row = Integer.parseInt(line[0]);
        col = Integer.parseInt(line[1]);
        dir = Integer.parseInt(line[2]);

        for (int i = 0; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        outer :
        while (true){
            if(Mat[row][col]==0){
                Mat[row][col] = 2;
                cnt++;
            }
            for(int i = 0 ; i < 4 ; i++){
                dir = (dir+3)%4;    //((dir+4)-1)%4 왼쪽방향
                int nr = row+dr[dir];
                int nc = col+dc[dir];
                if(nr>=0 && nr<N && nc>=0 && nc<M && Mat[nr][nc]==0){
                    row = nr;
                    col = nc;
                    continue outer;
                }
            }
            int backDir = (dir+6)%4;
            int backRow = row+dr[backDir];
            int backCol = col+dc[backDir];
            if(backRow>=0 && backRow<N && backCol>=0 && backCol<M && Mat[backRow][backCol]!=1){
                row = backRow;
                col = backCol;
                continue;
            }
            break;
        }
        System.out.println(cnt);
    }
}
