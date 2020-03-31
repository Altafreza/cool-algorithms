package backtracking.combinatorics;

import java.util.Scanner;

public class EqualPartition {
    static boolean equalsum(int a[],int n,int sum,int i)
    {
        if(0==sum)
            return true;
        if(i>=n || sum<0)
            return false;
        return equalsum(a,n,sum-a[i],i+1) || equalsum(a,n,sum,i+1) ;
    }
    public static void main (String[] args)throws Exception {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for(int i = 0; i < test; i++){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            for(int j = 0; j < n; j++){
                arr[j] = sc.nextInt();
                sum += arr[j];
            }
            if(equalsum(arr,n,sum/2,0) && sum%2==0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
