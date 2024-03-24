//6. Write a program to simulate deadlock avoidance using banker's algorithm.
import java.util.Arrays;
class p6_bankers{
    static boolean safe(int[][] max, int[][] alloc,int[] avl){
        int n =alloc.length;
        int m =avl.length;
        int[][] need = new int[10][10];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                need[i][j]=max[i][j]-alloc[i][j];
            }
        }
        boolean[] finish = new boolean[n];
        int cnt=0;
        int[] work = Arrays.copyOf(avl,m);
        int[] seq = new int[n];
        while(cnt<n){
            boolean found = false;
            for(int i=0;i<n;i++){
                if(!finish[i] && canexec(need,i,work)){
                    for(int j=0;j<m;j++){
                        work[j] += alloc[i][j];
                    }
                    finish[i]=true;
                    found=true;
                    seq[cnt++]=i;
                }
            }
            if(!found){
                System.out.println("System is not in safe state");
                return false;
            }
        }
        System.out.println("System is in safe state and the safe sequence is : ");
        for(int i=0;i<n;i++){
            System.out.print(" P" +seq[i]);
        }
        return true;
    }
    private static boolean canexec(int need[][],int process, int work[]){
        for(int j=0;j<work.length;j++){
            if(need[process][j]>work[j]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        int[] available = {3, 3, 2};
        int[][] max = {
            {7, 5, 3},
            {3, 2, 2},
            {9, 0, 2},
            {2, 2, 2},
            {4, 3, 3}
        };
        int[][] allocation = {
            {0, 1, 0},
            {2, 0, 0},
            {3, 0, 2},
            {2, 1, 1},
            {0, 0, 2}
        };

        safe( max, allocation, available);
    }
}










































/*
import java.util.Arrays; 
class p6_bankers
{
    static boolean safe(int[][] max, int[][] alloc, int[] avl)
    {
        int n=alloc.length;
        int m=avl.length;
        int[][] need=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                need[i][j]=max[i][j]-alloc[i][j];
            }
        }
        boolean[] finish = new boolean[n];
        int[] work = Arrays.copyOf(avl,m);
        int cnt=0;
        int[] seq = new int[n];
        while(cnt<n){
            boolean found=false;
            for(int i=0;i<n;i++){
                if(!finish[i] && canexc(need,i,work)){
                    for(int j=0;j<m;j++){
                        work[j] += alloc[i][j];
                    }
                    seq[cnt++]=i; //if ke ANDAR
                    finish[i]=true;
                    found=true;
                }
            }
            if(!found){
                System.out.print("System is not in safe state");
                return false;
            }
        }
        System.out.print("System is in safe state. Safe sequence: ");
        for (int i = 0; i < n; i++)
            System.out.print("P" + seq[i] + " ");
        System.out.println();
        return true;
    }
    private static boolean canexc(int[][] need, int process, int[] work){
        for(int j=0;j<work.length;j++){
            if(need[process][j]>work[j]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        int[] available = {3, 3, 2};
        int[][] max = {
            {7, 5, 3},
            {3, 2, 2},
            {9, 0, 2},
            {2, 2, 2},
            {4, 3, 3}
        };
        int[][] allocation = {
            {0, 1, 0},
            {2, 0, 0},
            {3, 0, 2},
            {2, 1, 1},
            {0, 0, 2}
        };

        safe( max, allocation, available);
    }
}
*/






























/*import java.util.Arrays;

class p6_bankers {

    static boolean checkSafeSystem(int[] available, int[][] max, int[][] allocation) {
        int n = allocation.length;
        int m = available.length;
        int[][] need = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                need[i][j] = max[i][j] - allocation[i][j];

        boolean[] finish = new boolean[n];
        int[] work = Arrays.copyOf(available, m);
        int[] safeSequence = new int[n];
        int count = 0;

        while (count < n) {
            boolean found = false;
            for (int i = 0; i < n; i++) {
                if (!finish[i] && canExecute(need, i, work)) {
                    for (int j = 0; j < m; j++)
                        work[j] += allocation[i][j];
                    safeSequence[count++] = i;
                    finish[i] = true;
                    found = true;
                }
            }
            if (!found) {
                System.out.println("System is not in safe state due to lack of resources.");
                return false;
            }
        }

        System.out.print("System is in safe state. Safe sequence: ");
        for (int i = 0; i < n; i++)
            System.out.print("P" + safeSequence[i] + " ");
        System.out.println();
        return true;
    }

    private static boolean canExecute(int[][] need, int process, int[] work) {
        for (int j = 0; j < work.length; j++) {
            if (need[process][j] > work[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] available = {3, 3, 2};
        int[][] max = {
            {7, 5, 3},
            {3, 2, 2},
            {9, 0, 2},
            {2, 2, 2},
            {4, 3, 3}
        };
        int[][] allocation = {
            {0, 1, 0},
            {2, 0, 0},
            {3, 0, 2},
            {2, 1, 1},
            {0, 0, 2}
        };

        checkSafeSystem(available, max, allocation);
    }
}*/

// import java.util.Arrays;
// class p7_safety {
//     static final int PROCESSES = 5;
//     static final int RESOURCES = 3;

//     static boolean isSafe(int[] processes, int[] avail, int[][] maxm, int[][] allot) {
//         int[][] need = new int[PROCESSES][RESOURCES];
//         for (int i = 0; i < PROCESSES; i++)
//             for (int j = 0; j < RESOURCES; j++)
//                 need[i][j] = maxm[i][j] - allot[i][j];

//         boolean[] finish = new boolean[PROCESSES];
//         int[] safeSeq = new int[PROCESSES];
//         int[] work = avail.clone();
//         int count = 0;
//         while (count < PROCESSES) {
//             boolean found = false;
//             for (int p = 0; p < PROCESSES; p++) {
//                 if (!finish[p]) {
//                     if (canExecute(need, p, work)) {
//                         for (int k = 0; k < RESOURCES; k++)
//                             work[k] += allot[p][k];
//                         safeSeq[count++] = p;
//                         finish[p] = true;
//                         found = true;
//                     }
//                 }
//             }
//             if (!found) {
//                 System.out.println("System is not in safe state");
//                 return false;
//             }
//         }
//         System.out.println("System is in safe state.\nSafe sequence is: " + Arrays.toString(safeSeq));
//         return true;
//     }

//     private static boolean canExecute(int[][] need, int process, int[] work) {
//         for (int j = 0; j < RESOURCES; j++)
//             if (need[process][j] > work[j])
//                 return false;
//         return true;
//     }

//     public static void main(String[] args) {
//         int[] processes = {0, 1, 2, 3, 4};
//         int[] avail = {3, 3, 2};
//         int[][] maxm = {{7, 5, 3},
//                         {3, 2, 2},
//                         {9, 0, 2},
//                         {2, 2, 2},
//                         {4, 3, 3}};
//         int[][] allot = {{0, 1, 0},
//                         {2, 0, 0},
//                         {3, 0, 2},
//                         {2, 1, 1},
//                         {0, 0, 2}};
//         isSafe(processes, avail, maxm, allot);
//     }
// }