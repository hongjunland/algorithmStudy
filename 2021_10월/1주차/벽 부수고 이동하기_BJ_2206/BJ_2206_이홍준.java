package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2206_이홍준 {
    static int N;
    static int M;
    static int[][] Mat;
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};
    static int[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        Mat = new int[N][M];
        visited = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                Mat[i][j] = chars[j]-'0';
                visited[i][j][0] = Integer.MAX_VALUE;
                visited[i][j][1] = Integer.MAX_VALUE;
            }
        }
        bfs();
        if(visited[N-1][M-1][0]==Integer.MAX_VALUE && visited[N-1][M-1][1]==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(Math.min(visited[N-1][M-1][0],visited[N-1][M-1][1]));

    }
    static void bfs(){
        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(0,0,0));
        visited[0][0][0] = 1;
        visited[0][0][1] = 1;
        while (!queue.isEmpty()){
            Location location = queue.poll();
            int isUsed  = location.isUsed;
            int row = location.row;
            int col = location.col;
            for(int i = 0 ; i < 4 ; i++){
                int nr = row+dr[i];
                int nc = col+dc[i];
                if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
                if(Mat[nr][nc]==0){
                    if(visited[nr][nc][isUsed]>visited[row][col][isUsed]+1) {
                        visited[nr][nc][isUsed] = visited[row][col][isUsed] + 1;
                        queue.offer(new Location(nr, nc, isUsed));
                    }
                }else{
                    if(isUsed==0 && visited[nr][nc][1]>visited[row][col][isUsed]+1){
                        visited[nr][nc][1] = visited[row][col][isUsed]+1;
                        queue.offer(new Location(nr,nc,1));
                    }
                }
            }
        }
    }
    static class Location{
        int row;
        int col;
        int isUsed;

        public Location(int row, int col, int isUsed) {
            this.row = row;
            this.col = col;
            this.isUsed = isUsed;
        }
    }
}
