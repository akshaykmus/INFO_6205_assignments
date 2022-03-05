package edu.neu.coe.info6205.union_find;

import java.util.Random;
import java.util.Scanner;

public class UF_client {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the number of Sites :");
        int n = scanner.nextInt();
//        int count = count(n);
//        System.out.println(count);
        int[] count =null;
        for(int i = n;i<=n*10;i=i+n){
            int total = 0;
            for(int j=0;j<500;j++){
                count = count(i);
                total +=count[1];
            }
            int avg = total/500;
            System.out.println("Sites="+i+" Count="+avg + " connections = " + count[0]) ;
        }
    }
    public static int[] count(int n){
        UF_HWQUPC unionfind = new UF_HWQUPC(n);
        int i;
        int connections=0;
        for(i=0;unionfind.components()>1;i++){
            Random rn = new Random();
            int a = rn.nextInt(n);
            int b = rn.nextInt(n);
            if (!unionfind.isConnected(a, b)) connections++;
                unionfind.connect(a,b);
        }
        int[] arr = new int[2];
        arr[0] = connections;
        arr[1] = i;
        return arr;
    }
}
