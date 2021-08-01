package com.algorithms.nnu.Dynamic_Programming.polygogame;

//本代码所用示例为：+ -7 + 4 * 2 * 5
public class PolygonGame
{
    static int n; //边和点个数
    static int minf, maxf;
    static int[] v; //点集
    static char[] op; //边集
    static int[][][] m; //存储最终计算结果

    public static void main(String[] args)
    {
        n = 4;
        //以下所有数组下标为0的都不使用
        //构造出的多边形的最终结果：+ -7 + 4 * 2 * 5
        v = new int[]{Integer.MIN_VALUE, -7, 4, 2, 5};
        op = new char[] {' ', '+', '+', '*', '*'};
        m = new int[n + 1][n + 1][2];
        for(int i = 1; i <= n; i++)
        {
            //m[i][j][0]：表示链的起点为i，长度为j时的结果最小值
            m[i][1][0] = v[i];
            //m[i][j][1]：表示链的起点为i，长度为j时的结果最大值
            m[i][1][1] = v[i];
        }
        int result = polyMax();
        System.out.println(result);
    }

    /**
     * 参数含义：
     * i：链的起点
     * s：断开位置
     * j：链长度
     *
     */
    public static void minMax(int i,int s,int j)
    {
        int[] e = new int[n + 1];
        int a = m[i][s][0],
                b = m[i][s][1],
                r = (i + s - 1) % n + 1, //多边形是封闭的，不能出现下标溢出
                c = m[r][j - s][0],
                d = m[r][j - s][1];
        if(op[r] == '+')
        {
            minf = a + c;
            maxf = b + d;
        }
        else
        {
            e[1] = a * c;
            e[2] = a * d;
            e[3] = b * c;
            e[4] = b * d;
            minf = e[1];
            maxf = e[1];
            for(int k = 2; k < 5; k++)
            {
                if(minf > e[k])
                    minf = e[k];
                if(maxf < e[k])
                    maxf = e[k];
            }
        }
    }

    public static int polyMax()
    {
        for(int j = 2; j <= n; j++) //链的长度
            //链的起点，多边形是封闭的，不会存在什么问题
            for(int i = 1; i <= n; i++)
                for(int s = 1; s < j; s++) //断开的位置
                {
                    minMax(i, s, j);
                    if(m[i][j][0] > minf)
                        m[i][j][0] = minf;
                    if(m[i][j][1] < maxf)
                        m[i][j][1] = maxf;
                }
        int temp = m[1][n][1];
        for(int i = 1; i <= n; i++)
            if(temp < m[i][n][1])
            {
                temp = m[i][n][1];
            }
        return temp;
    }
}