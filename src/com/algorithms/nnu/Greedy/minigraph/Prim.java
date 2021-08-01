package com.algorithms.nnu.Greedy.minigraph;

/**
 * 最小生成树的prim算法
 * @author liuy
 */
public class Prim {

    public static void prim(int num, float[][] weight) {  //num为顶点数，weight为权
        float[] lowcost = new float[num + 1];  //到新集合的最小权

        int[] closest = new int[num + 1];  //代表与s集合相连的最小权边的点

        boolean[] s = new boolean[num + 1];  //s[i] == true代表i点在s集合中

        s[1] = true;  //将第一个点放入s集合

        for(int i = 2; i <= num; i++) {  //初始化辅助数组
            lowcost[i] = weight[1][i];
            closest[i] = 1;
            s[i] = false;
        }

        for(int i = 1; i < num; i++) {
            float min = Float.MAX_VALUE;
            int j = 1;
            for(int k = 2; k <= num; k++) {
                if((lowcost[k] < min) && (!s[k])) {//根据最小权加入新点
                    min = lowcost[k];
                    j = k;
                }
            }

            System.out.println("加入点" + j + ". " + j + "---" + closest[j]);//新加入点的j和与j相连的点

            s[j] = true;//加入新点j

            for(int k = 2; k <= num; k++) {
                if((weight[j][k] < lowcost[k]) && !s[k]) {//根据新加入的点j,求得最小权
                    lowcost[k] = weight[j][k];
                    closest[k] = j;
                }
            }
        }
    }

    public static void main(String[] args) {
        //              ①
        //            /  |  /
        //           6   1   5
        //          /    |    /
        //        ②-5--③--5--④
        //         /    //    /
        //          3  6  4  2
        //           //    //
        //           ⑤--6-⑥
        //最小生成树为：
        //              ①
        //               |
        //               1
        //               |
        //        ②-5--③        ④
        //         /     /    /
        //          3     4  2
        //           /     //
        //           ⑤        ⑥
        //
        float m = Float.MAX_VALUE;
        float[][] weight = {{0, 0, 0, 0, 0, 0, 0},
                {0, m, 6, 1, 5, m, m},
                {0, 6, m, 5, m, 3, m},
                {0, 1, 5, m, 5, 6, 4},
                {0, 5, m, 5, m, m, 2},
                {0, m, 3, 6, m, m, 6},
                {0, m, m, 4, 2, 6, m}};//上图的矩阵
        prim(weight.length - 1, weight);
        //加入点3. 3---1
        //加入点6. 6---3
        //加入点4. 4---6
        //加入点2. 2---3
        //加入点5. 5---2
    }
}