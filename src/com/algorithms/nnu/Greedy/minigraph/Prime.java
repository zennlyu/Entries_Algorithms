package com.algorithms.nnu.Greedy.minigraph;

import java.util.ArrayList;
import java.util.List;

public class Prime {

    int m = Integer.MAX_VALUE;

    int[][] edges = {
            {0, 3, 1, m, 4},
            {3, 0, 2, m, m},
            {1, 2, 0, 5, 6},
            {m, m, 5, 0, m},
            {4, m, 6, m, 0},
    };

    //打印最小生成树
    void MST_Prime(Graph G) {
        int vexNum = G.getVexNum();//节点个数
        int[] min_weight = new int[vexNum];//当前结果树到所有顶点的最短距离
        int[] adjvex = new int[vexNum];//adjvex[C]=0，代表C是通过A加入结果树的（0是A的下标）
        /*初始化两个辅助数组*/
        for(int i = 0; i < vexNum; i++) {
            min_weight[i] = (G.getEdges())[0][i];//第一个顶点到其余顶点的距离
            adjvex[i]=0;
        }
        int min_edg;//当前挑选的最小权值
        int min_vex = 0;//最小权值对应的节点下标
        /*循环剩余n-1个点*/
        for(int i = 1; i < vexNum; i++) {
            min_edg = Integer.MAX_VALUE;
            for(int j = 1; j < vexNum; j++) {
                if(min_weight[j]!=0 && min_weight[j] < min_edg) {
                    //寻找还没有被挑选进来的，最小权重的点
                    min_edg = min_weight[j];
                    min_vex = j;
                }
            }
            min_weight[min_vex] = 0;//纳入结果树
            /*修改对应辅助数组的值*/
            for(int j = 0; j < vexNum; j++) {
                if(min_weight[j]!=0 && (G.getEdges())[min_vex][j]<min_weight[j] && (G.getEdges())[min_vex][j]>0) {
                    min_weight[j] = (G.getEdges())[min_vex][j];
                    adjvex[j]=min_vex;
                }
            }
            int pre = adjvex[min_vex];
            int end = min_vex;
            System.out.println("("+G.getVex().get(pre)+","+G.getVex().get(end)+")");
        }
    }

    //初始化图
    Graph init() {
        List<String> vex=new ArrayList<String>();
        vex.add("A");
        vex.add("B");
        vex.add("C");
        vex.add("D");
        vex.add("E");
        Graph graph = new Graph(vex, edges);
        return graph;
    }


    public static void main(String[] args) {
        Prime prime = new Prime();
        Graph graph = prime.init();
        prime.MST_Prime(graph);
    }
}