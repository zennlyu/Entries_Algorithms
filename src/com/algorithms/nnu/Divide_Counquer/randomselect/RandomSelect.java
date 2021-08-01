package com.algorithms.nnu.Divide_Counquer.randomselect;
import java.util.Scanner;
import java.util.Random;

public class RandomSelect {
    public static void swap(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }
    public int Random (int x, int y) {
        Random random = new Random();
        int num = random.nextInt(y)%(y - x + 1) + x;
        return num;
    }
    public int partition(int[] list, int low, int high) {
        int tmp = list[low];  //数组的第一个作为中轴
        while (low < high) {
            while (low < high && list[high] > tmp) {
                high--;
            }
            list[low] = list[high];  //比中轴小的记录移到低端
            while (low < high && list[low] < tmp) {
                low++;
            }
            list[high] = list[low];  //比中轴大的记录移到高端
        }
        list[low] = tmp;       //中轴记录到尾
        return low;          //返回中轴的位置
    }
    public int RandomizedPartition (int[] arrays, int left, int right) {
        int i = Random(left, right);
        swap(arrays[i], arrays[left]);
        return partition(arrays, left, right);
    }
    public int RandomizedSelect(int[] arrays, int left, int right, int k) {
        if(left == right ) {
            return arrays[left];
        }
        int i = RandomizedPartition(arrays, left, right);
        int j = i - left + 1;
        if(k <= j) {
            return RandomizedSelect(arrays,left, i,k) ;
        }
        else {
            return RandomizedSelect(arrays,i+1,right,k-j);
        }
    }
    public static void main(String args[]) {
        System.out.println("脚本之家测试结果：");
        int[] a = {7,5,3,4,8,6,9,1,2,99,72};
        for (int i = 0; i < 9; i ++) {
            System.out.print(a[i]+ " ");
        }
        System.out.println();
        RandomSelect r = new RandomSelect();
        System.out.println("你要查询的元素是数组中第几小的？");
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = r.RandomizedSelect(a,0,8,m);
        System.out.println("这个数组中第" + m + "小的元素是："+ n);
    }
}