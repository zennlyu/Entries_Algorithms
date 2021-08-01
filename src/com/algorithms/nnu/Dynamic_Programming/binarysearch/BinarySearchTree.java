package com.algorithms.nnu.Dynamic_Programming.binarysearch;

public class BinarySearchTree {
    public void optimalBinarySearchTree(float[] a,float[] b,float[][] m,int[][] s,float[][] w){
        int n=a.length-1;
        for(int i=0;i<=n;i++){//初始化构造无内部节点的情况
            w[i+1][i]=a[i];
            m[i+1][i]=0;
            s[i+1][i]=0;
        }
        for(int r=0;r<n;r++){//r为i与j之间的差值
            for(int i=1;i<=n-r;i++){
                int j=i+r;
                /*以下为 改进后的地方*/
                int i1=s[i][j-1]>i?s[i][j-1]:i;
                int j1=s[i+1][j]>i?s[i+1][j]:j;
                //i，j之间距离为r时，首选i为根，其左子树为空，右子树为节点
                w[i][j]=w[i][j-1]+a[j]+b[j];//计算w[i][j]
                m[i][j]=m[i][i1-1]+m[i1+1][j];//k=i1时的情况
                s[i][j]=i1;
                //左子树为节点：i1,i1+1……k-1,右子树为节点：k+1,k+2,……j1
                for(int k=i1+1;k<=j1;k++){//i1<=k<=j1,通过k循环，找到min{m(i,k-1)+m(k+1,j)}的值
                    float temp=m[i][k-1]+m[k+1][j];
                    if(temp<m[i][j]){
                        m[i][j]=temp;
                        s[i][j]=k;//k作为根节点
                    }
                }
                m[i][j]+=w[i][j];//m(i,j)=wi,j+min{m(i,k-1)+m(k+1,j)}
            }
        }
    }
    public void backtrace(int[][] s,int n,int i,int j,int p,String str){
        int k=s[i][j];
        if(k>0){
            if(p==0){
                System.out.println("root is:"+k);
            }else{
                System.out.println(str+" of "+p+" is "+k+"; and (i:j) is "+i+":"+j);
            }
            int t=k-1;
            if(t>=i&&t<=n)
                backtrace(s,n,i,t,k,"left");
            t=k+1;
            if(t<=j)
                backtrace(s,n,t,j,k,"right");
        }
    }
    public static void main(String[] args) {
        float a[] = {0.15f,0.1f,0.05f,0.05f};//a,b的下标都是从0开始
        float b[] = {0.00f,0.5f,0.1f,0.05f};
        int n=a.length-1;
        float[][] m=new float[n+2][n+2];
        int[][] s=new int[n+2][n+2];//因为w[i+1][i]存在，i最大为n，即可以从0.....n,n+1,共n+2个
        float[][] w=new float[n+2][n+2];
        BinarySearchTree bi = new BinarySearchTree();
        bi.optimalBinarySearchTree(a, b, m, s, w);
        System.out.println("二叉搜索树最小平均路长为："+m[1][n]);
        bi.backtrace(s, n, 1, n, 0, "0");
    }
}