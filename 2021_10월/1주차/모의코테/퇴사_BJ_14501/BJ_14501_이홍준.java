import java.util.Arrays;
import java.util.Scanner;

public class BJ_14501_이홍준{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][]nums = new int[N+1][2];
        int[] dp = new int[N+2];
        for(int i = 1 ; i<=N ; i++){
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        dp[0] = 0;
        for(int i=1; i<=N+1; i++){
            for(int j=i; j<=N;j++){
                dp[j+1]= Math.max(dp[j],dp[j+1]);
            }
            if(i<=N){
                int t = nums[i][0];
                int cost = nums[i][1];
                if(t+i<=N+1){
                    if(dp[i]+cost>dp[t+i]){
                        dp[i]+=cost;
                        dp[t+i] = dp[i];
                    }
                }
            }
            dp[i] = Math.max(dp[i],dp[i-1]);
        }
        System.out.println(dp[N+1]);
//        System.out.println(Arrays.toString(dp));
    }
}
