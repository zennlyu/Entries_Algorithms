package com.nnu.Greedy.dijkstra;

public class Dijkstra1 {

    public static void main(String[] args) {
        float max = Float.MAX_VALUE;
        float[][] a = new float[][] {{0, 0, 0, 0, 0, 0},
                {0, max, 10, max, 30, 100},
                {0, max, max, 60, max, max},
                {0, max, max, max, max, 20},
                {0, max, max, 10, max, 50},
                {0, max, max, max, max, max}};
        int v = 1;
        int n = 5;
        float[] dist = new float[n + 1];
        int[] prev = new int[n + 1];
        dijkstra(v, a, dist, prev);
        for (int i = 1; i <= n; i++) {
            if (i != v) {
                System.out.println(v + "->" + i + " : " + dist[i]);
            }
        }
    }

    /**
     * 单元最短路径问题的 Dijkstra 算法
     * @param v: 源顶点
     * @param a：邻接矩阵
     * @param dist：存放最短路径
     * @param prev：存放当前顶点的前一个顶点
     */
    public static void dijkstra(int v, float[][] a, float[] dist, int[] prev) {

        int n = dist.length - 1;
        if (v < 1 || v > n) return;
        // 代表当前顶点是否被添加到集合S中
        boolean[] s = new boolean[n + 1];
        // 初始化
        for (int i = 1; i <= n; i++) {
            dist[i] = a[v][i];
            s[i] = false;
            if (dist[i] == Float.MAX_VALUE) prev[i] = 0;
            else prev[i] = v;
        }
        dist[v] = 0;
        s[v] = true;
        for (int i = 1; i < n; i++) {
            float temp = Float.MAX_VALUE;
            int u = v;
            for (int j = 1; j <= n; j++) {  // 寻找不在S中的最小值
                if (!s[j] && (dist[j] < temp)) {  // 从剩余顶点选择
                    u = j;
                    temp = dist[j];
                }
            }
            // 加入s中
            s[u] = true;
            for (int j = 1; j <= n; j++) {  // 更新dist
                if ((!s[j]) && (a[u][j] < Float.MAX_VALUE)){
                    float newdist = dist[u] + a[u][j];
                    if (newdist < dist[j]) {
                        dist[j] = newdist;
                        prev[j] = u;
                    }
                }
            }
        }
    }
}