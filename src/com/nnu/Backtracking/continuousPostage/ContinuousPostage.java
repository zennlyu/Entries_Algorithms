package com.nnu.Backtracking.continuousPostage;

/**
 * 连续邮资问题--回溯法
 * @author Lican
 *
 */
public class ContinuousPostage {
    public int n;//邮票的不同面值的数量
    public int m;//每张信封允许贴的最多邮票数
    public int maxR;//当前最优值
    public int maxint;//大整数
    public int maxl;//邮资上界
    public int[] x;//当前解
    public int [] y;//贴出各种邮资所需最少邮票数
    public int[] bestx;//当前最优解

    public int maxStamp(int mm,int nn){
        int maxll=1500;
        n=nn;
        m=mm;
        maxR=0;
        maxint=Integer.MAX_VALUE;
        maxl=maxll;
        bestx=new int[n+1];
        x=new int[n+1];
        y=new int[maxl+1];
        for(int i=1;i<=maxl;i++)
            y[i]=maxint;
        x[1]=1;
        y[0]=0;
        backtrack(2,1);
        return maxR;
    }
    public void backtrack(int i,int r){
        for(int j=0;j<=x[i-2]*(m-1);j++){
            if(y[j]<m){
                for(int k=1;k<=m-y[j];k++){
                    if(y[j]+k<y[j+x[i-1]*k])
                        y[j+x[i-1]*k]=y[j]+k;
                }
            }
        }
        while(y[r]<maxint) r++;

        if(i>n){
            if(r-1 > maxR){
                maxR = r-1;
                for(int j=1; j<=n; j++)
                    bestx[j] = x[j];
            }
            return;
        }
        int[] z = new int[maxl+1];
        for(int k=1; k<=maxl; k++){
            z[k] = y[k];
        }
        for(int j=x[i-1]+1; j<=r; j++){
            if(y[r-j] < m){
                x[i] = j;
                backtrack(i+1,r+1);
                for(int k=1; k<=maxl; k++)
                    y[k] = z[k];
            }
        }
    }
    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        ContinuousPostage st = new ContinuousPostage();
        int maxR = st.maxStamp(m, n);
        System.out.println("能贴出的最大邮资为："+maxR);
        for(int i=1; i<=n; i++){
            System.out.print(st.bestx[i]+" ");
        }
    }
}