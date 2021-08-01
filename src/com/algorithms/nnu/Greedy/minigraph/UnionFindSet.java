package com.algorithms.nnu.Greedy.minigraph;

//首先我们实现并查集（用来判断是否构成回路--是否属于一个并查集）
public class UnionFindSet {

    //查询树的根
    public static int find(int x, int [] par){
        if(par[x] == x){
            return x;
        }else{
            //压缩路径，第二次查询可以直接返回x的根而不用递归
            return par[x] = find(par[x], par);
        }
    }

    //合并
    public static void unite(int x, int y, int [] par, int [] rank){
        x = find(x, par);
        y = find(y, par);

        if(x == y){
            return ;
        }

        if(rank[x] < rank[y]){
            par[x] = y;
        }else{
            par[y] = x;
            if(rank[x] == rank[y]) rank[x]++;
        }
    }

    //判断x和y是否属于同一个集合
    public static boolean same(int x, int y, int [] par){
        return find(x, par) == find(y, par);
    }
}