//1. Write a program to simulate the following non-preemptive CPU scheduling algorithms to find turnaround time and waiting time.
//a) FCFS b) SJF c) Round Robin d) Priority
import java.util.*;
public class prog1_SJF{
    public static void main(String[] args)
    {
        int[] p =new int[20];
        int[] bt=new int[20];
        int[] wt=new int[20];
        int[] tat=new int[20];
        float wtavg, tatavg;
        Scanner sc = new Scanner(System.in);
        int n,temp;
        System.out.println("Enter no. of processes : ");
        n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Enter burst time for process  " +(i+1));
            bt[i]=sc.nextInt();
            p[i]=i;
        }
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(bt[i]>bt[j]){
                    temp=bt[i];
                    bt[i]=bt[j];
                    bt[j]=temp;

                    temp=p[i];
                    p[i]=p[j];
                    p[j]=temp;
                }
            }
        }
        wtavg=0;
        tat[0]=bt[0];
        tatavg=tat[0];
        for(int i=1;i<n;i++){
            wt[i] = wt[i-1] + bt[i-1];
            tat[i] = tat[i-1] + bt[i];
            tatavg += tat[i];
            wtavg += wt[i];
        }
        System.out.println("\nProcess\tBurst Time\tWaiting Time\tTurnaround time\n");
        for(int i=0;i<n;i++){
            System.out.println("P " +p[i] +"\t" +bt[i] +"\t\t" +wt[i] +"\t\t" +tat[i]);
        }
        System.out.println("\nAverage Waiting time : " +(wtavg/n));

        System.out.println("\nAverage Turnaround time : " +(tatavg/n));
    }
}























/* 
import java.util.*;
public class prog1_SJF
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int p[] = new int[20];
        int bt[] = new int[20];
        int wt[] = new int[20];
        int tat[] = new int[20];
        float tatavg=0, wtavg=0;
        int n,temp;
        System.out.println("Enter no. of processes : ");
        n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Enter burst time for process " +(i+1) + ":");
            bt[i]=sc.nextInt();
            p[i]=i;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(bt[i]>bt[j]){
                    temp=bt[i];
                    bt[i]=bt[j];
                    bt[j]=temp;

                    temp=p[i];
                    p[i]=p[j];
                    p[j]=temp;
                }
            }
        }
        wt[0]=0;
        tat[0]=bt[0];
        tatavg=bt[0];
        for(int i=1;i<n;i++){
            wt[i]=wt[i-1]+bt[i-1];
            tat[i]=tat[i-1]+bt[i];
            wtavg+= wt[i];
            tatavg+= tat[i];
        }
        System.out.println("\nProcess\tBurst Time\tWaiting Time\tTotal Arrival time\n");
        for(int i=0;i<n;i++){
            System.out.println("\nP"+p[i] +"\t" +bt[i] +"\t\t" +wt[i] +"\t\t" +tat[i]);
        }
        System.out.println("\nAvg turnaround time : " +tatavg/n);
        System.out.println("\nAvg waiting time : " +wtavg/n);
    }
}
*/
