package com.algorithms.nnu.Backtracking.circlepermutation;

/**
 * 圆排列问题--回溯法--排列树
 * @author Lican
 *
 */

public class CirclePermutation {
    public int n;//待排列圆的个数
    public float min;//当前最优值
    public float[] x;//当前圆排列圆心横坐标
    public float[] r;//当前圆排列
    public float circlePerm(int nn,float[] rr){
        n=nn;
        r=rr;
        min=1000000;
        x=new float[n+1];
        backtrack(1);
        return min;
    }

    public void backtrack(int t){
        if(t>n)
            compute();
        else{
            for(int j=t;j<=n;j++){
                swap(r,t,j);
                float centerx=center(t);
                if(centerx+r[t]+r[1]<min){//下界约束
                    x[t]=centerx;
                    backtrack(t+1);
                }
                swap(r,t,j);
            }
        }
    }

    public void swap(float[] r,int i,int j){
        float temp=r[i];
        r[i]=r[j];
        r[j]=temp;
    }

    public float center(int t){//计算当前所选择圆的圆心横坐标
        float temp=0;
        for(int j=1;j<t;j++){
            float valuex=(float) (x[j]+2.0*Math.sqrt(r[t]*r[j]));
            if(valuex>temp)
                temp=valuex;
        }
        return temp;
    }

    public void compute(){//计算当前圆排列的长度
        float low=0;
        float high=0;
        for(int i=1;i<=n;i++){
            if(x[i]-r[i]<low) low=x[i]-r[i];
            if(x[i]+r[i]>high) high=x[i]+r[i];
        }
        if(high-low<min)
            min=high-low;
    }

    public static void main(String[] args) {
        int n=3;
        float[] r={0,1,1,2};//r下标从1开始， 0无用，只是凑数
        CirclePermutation c = new CirclePermutation();
        float min=c.circlePerm(n, r);
        System.out.println("最小圆排列长度为"+min);
    }
}