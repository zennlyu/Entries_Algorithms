package com.nnu.Greedy.minigraph;

/*
 * 首先我们给出图的存储结构
 */
import java.util.ArrayList;
import java.util.List;

public class Graph {

    /*
     * 点的存储
     */
    private List<String> vex;
    /*
     * 边的存储
     */
    private int edges[][];

    public Graph(List<String> vex, int[][] edges) {
        this.vex = vex;
        this.edges = edges;
    }
    public List<String> getVex() {
        return vex;
    }
    public void setVex(List<String> vex) {
        this.vex = vex;
    }
    public int[][] getEdges() {
        return edges;
    }
    public void setEdges(int edges[][]) {
        this.edges = edges;
    }
    public int getVexNum() {
        return vex.size();
    }
    public int getEdgeNum() {
        return edges.length;
    }
}