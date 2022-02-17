package com.nnu.Branch_Bound.FIFOLoading;

import java.util.LinkedList;
import java.util.Queue;

public class FIFOLoading {
    //结点类
    private  class  Node{
        Node parent;//该结点的父节点
        int weight;//该结点的重量
        Boolean isLeftChild;//该结点的父节点的左子节点
        public Node(Node parent,int wt,Boolean isLeftChild){
            this.parent=parent;
            this.weight=wt;
            this.isLeftChild=isLeftChild;
        }
    }
    int n;//集装箱的数量
    int w[];//集装箱的重量数组
    int c;//船1的承载量

    Node bestE=null;//最优叶子结点的父节点
    int wt=0;//当前结点和之前的结点之和

    int bestW=0;//最优重量和
    int bestx[];//最优决策

    public FIFOLoading(int n, int w[], int c){
        this.n=n;
        this.c=c;
        this.w=w;
        this.bestx=new int[n+1];
    }
    //    活结点队列
    Queue<Node> queue=new LinkedList();
    private void EnQueue(int i,Node parent,int weight,Boolean leftChild){
        //达到叶子结点
        if(i==n){
            //重量和==bestW
            if (weight == bestW) {
                //  叶子结点的父节点
                bestE = parent;
                // 更新最优决策数组的最后一项
                bestx[n] = (bestE.isLeftChild) ? 1 : 0;
            }
        }else{
            // 创建新的结点
            Node b=new Node(parent,weight,leftChild);
            //添加结点到队列中
            queue.add(b);
        }
    }
    private void  maxLoding(){
        int i=1;//当前层数
        //创建根结点A
        Node A=new Node(null,0,true);
        Node e=A;//e记录即将放入队列的结点
        bestE=A;
        queue.add(null);
        int residue=0;//剩余集装箱重量
        for(int j=2;j<=n;j++){
            residue+=w[j];
        }
        int ew=0;//当前拓展结点的重量
        while (true){
            //w[i]为将扩展结点所相应的载重量
            wt=ew+w[i];
            //检查左子结点 可行则装入队列
            if(wt<=c){
                //更新最优重量
                if(wt>bestW){
                    bestW=wt;
                }
                //以左子节点身份进入
                EnQueue(i,e,wt,true);
            }
            // 检测右结点
            if(ew+residue>=bestW){
                EnQueue(i,e,ew,false);
            }
            //取队列的第一个结点
            e = queue.poll();
            //e=null表示同层结点尾部
            if(e==null){
                if(queue.isEmpty()){
                    break;
                }
                queue.add(null);
                //更新当前结点
                e=queue.remove();
//                进入下一层
                i++;
                residue-=w[i];
            }
            //更新扩展结点所相应的载重量
            ew=e.weight;
        }
        //构造当前最优解
        for (int j = n - 1; j > 0; j--) {
            bestx[j] = (bestE.isLeftChild) ? 1 : 0;
            bestE = bestE.parent;
        }
    }
    public static  void main(String args[]){
        int n=5;
        int c=120;//船1承载重量
        int[] w= {0,60,40,10,30,50};//集中箱i的重量
        FIFOLoading fifoLoading=new FIFOLoading(n,w,c);
        fifoLoading.maxLoding();
        System.out.println("船1最优装载量："+fifoLoading.bestW);
        System.out.println("决策数组为：");
        for(int i=1;i<=n;i++)
            System.out.print(fifoLoading.bestx[i]+" ");
    }
}
