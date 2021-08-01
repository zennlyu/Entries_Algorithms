package com.algorithms.nnu.Divide_Counquer.perm;

public class Perm_Simple {
    static int num = 0;
    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,5};
        perm(arr,0,arr.length-1);
        System.out.println("总个数  = "+ num);
    }

    public static void perm(int arr[], int k, int m){
        if(k == m){
            for(int e:arr)
                System.out.print(e);
            System.out.println();
            num++;
        }else{
            for(int i = k; i <= m; i++){
                swap(arr, i, k);
                perm(arr, k+1, m);
                swap(arr, i, k);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}