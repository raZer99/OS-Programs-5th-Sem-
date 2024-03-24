//5. Write a program to simulate the following contiguous memory allocation techniques a) Worst-fit b) Best-fit c) First-fit
import java.util.*;
public class prog5_bestFit{
    static void bestfit(int ps[],int bs[],int m,int n)
    {
        int alloc[] = new int[10];
        for(int i=0;i<n;i++){
            alloc[i]=-1;
        }
        for(int i=0;i<n;i++){
            int wstidx=-1;
            for(int j=0;j<m;j++){
                if(bs[j]>=ps[i]){
                    if(wstidx==-1){
                        wstidx=j;
                    }
                    else if(bs[wstidx]>bs[j]){
                        wstidx=j;
                    }
                }
            }
            if(wstidx!=-1){
                alloc[i]=wstidx;
                bs[wstidx] -= ps[i];
            }
        }
        System.out.println("Process\tProcess Size\tBlock no.");
        for(int i=0;i<n;i++){
            System.out.print("P " +(i+1) +"\t" +ps[i] +"\t\t");
            if(alloc[i]!=-1){
                System.out.print(alloc[i]+1);
            }else{
                System.out.print("Not allocated!");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int ps[] = {212,413,113,426};
        int bs[] = {100,500,200,300,600};
        int m  = bs.length;
        int n = ps.length;
        bestfit(ps, bs, m, n);
    }
}
/*
import java.util.*;
public class prog5_bestFit
{
    static void bestfit(int bs[], int m, int ps[], int n)
    {
        int alloc[] = new int[n];
        for(int i=0;i<n;i++)
            alloc[i]=-1;
        for(int i=0;i<n;i++){
            int bstidx = -1;
            for(int j=0;j<m;j++){
                if(bs[j]>=ps[i] ){
                    if(bstidx == -1){
                        bstidx=j;
                    }
                    else if(bs[bstidx]>bs[j]){
                        bstidx=j;
                    }
                }
            }
            if(bstidx!=-1){
                alloc[i]=bstidx;
                bs[bstidx] -= ps[i];
            }
        }
        System.out.println("Process\tProcess Size\tBlock no.");
        for(int i=0;i<n;i++){
            System.out.print(" "+(i+1) +"\t" +ps[i] +"\t\t");
            if(alloc[i]!=-1)
                System.out.print(alloc[i]+1);
            else 
                System.out.print("Not Allocated");
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        int bs[]={100,500,200,300,600};
        int ps[] = {212,417,112,426};
        int m=bs.length;
        int n = ps.length;
        bestfit(bs,m,ps,n);
    }
}
*/