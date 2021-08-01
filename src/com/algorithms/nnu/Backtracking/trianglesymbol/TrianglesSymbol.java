package com.algorithms.nnu.Backtracking.trianglesymbol;

public class TrianglesSymbol {

    static int n;//第一行的符号个数
    static int half;//n*(n+1)/4
    static int count;//当前“+”或者“-”的个数
    static int[][] p;//符号三角形矩阵
    static long sum;//已找到的符号三角形的个数

    public static float Compute(int nn) {
        n = nn;
        count = 0;
        sum = 0;
        half = (n*(n+1))>>1;
        if((half>>1)<<1 != half) {
            return 0;
        }
        half = half>>1;
        p = new int[n+1][n+1];
        backtrack(1);

        return sum;
    }

    /**
     * 算法1
     * @param t
     */
	/*
	public static void backtrack01(int t) {
		if(count>half || (t*(t-1)/2-count > half) {//对题解树的剪枝
			return;
		}
		if(t>n) {
			sum++;//符号三角形的总数目+1
		}
		else {
			//每个位置都有两种情况0,1
			for(int i = 0;i<2;i++) {
				p[1][t] = i;
				count += i;//对"-"个数进行技术，为了进行剪枝操作

				//接下来绘制其余的n-1行
				for(int j = 2;j<=t;j++) {
					//通过异或的方式求其余行数的放置方式
					p[j][t-j+1] = p[j-1][t-j+1]^p[j-1][t-j+2];
					count += p[j][t-j+1];
				}
				backtrack01(t+1);

				//恢复现场
				for(int j = 2;j<=t;j++) {
					count -= p[j][t-j+1];
				}
				count -= i;
			}
		}
	}
	*/

    public static void backtrack(int t) {
        if((count>half)||((t*(t-1)/2-count > half))) //对题解树的剪枝
        return;
        if(t>n) {
            sum++;
            //打印符号三角形
            for(int i =1;i<=n;i++) {
                for(int k = 1;k<i;k++) {
                    System.out.print(" ");
                }
                for(int j =1;j<=n;j++) {
                    if(p[i][j] == 0 && j<=n-i+1) {
                        System.out.print("+" + " ");
                    }
                    else if(p[i][j] == 1 && j<=n-i+1) {
                        System.out.print("-" + " ");
                    }
                    else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
        else {
            //每个位置都有两种情况0,1
            for(int i =0;i<2;i++) {
                p[1][t] = i;
                count += i;//计算“-”的个数

                //接下来绘制其余的n-1行
                for(int j = 2;j<=t;j++) {
                    //通过异或的方式求其余行数的放置方式
                    p[j][t-j+1] = p[j-1][t-j+1]^p[j-1][t-j+2];
                    count += p[j][t-j+1];

                }
                backtrack(t+1);

                //恢复现场
                for(int j =2;j<=t;j++) {
                    count -= p[j][t-j+1];
                }
                count -= i;

            }
        }
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        float SUM = Compute(4);
        System.out.print("总数： " + SUM);
    }
}