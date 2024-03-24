
import java.util.Arrays;
class p7_safety {
    static final int PROCESSES = 5;
    static final int RESOURCES = 3;

    static boolean isSafe(int[] processes, int[] avail, int[][] maxm, int[][] allot) {
        int[][] need = new int[PROCESSES][RESOURCES];
        for (int i = 0; i < PROCESSES; i++)
            for (int j = 0; j < RESOURCES; j++)
                need[i][j] = maxm[i][j] - allot[i][j];

        boolean[] finish = new boolean[PROCESSES];
        int[] safeSeq = new int[PROCESSES];
        int[] work = avail.clone();
        int count = 0;
        while (count < PROCESSES) {
            boolean found = false;
            for (int p = 0; p < PROCESSES; p++) {
                if (!finish[p]) {
                    if (canExecute(need, p, work)) {
                        for (int k = 0; k < RESOURCES; k++)
                            work[k] += allot[p][k];
                        safeSeq[count++] = p;
                        finish[p] = true;
                        found = true;
                    }
                }
            }
            if (!found) {
                System.out.println("System is not in safe state");
                return false;
            }
        }
        System.out.println("System is in safe state.\nSafe sequence is: " + Arrays.toString(safeSeq));
        return true;
    }

    private static boolean canExecute(int[][] need, int process, int[] work) {
        for (int j = 0; j < RESOURCES; j++)
            if (need[process][j] > work[j])
                return false;
        return true;
    }

    public static void main(String[] args) {
        int[] processes = {0, 1, 2, 3, 4};
        int[] avail = {3, 3, 2};
        int[][] maxm = {{7, 5, 3},
                        {3, 2, 2},
                        {9, 0, 2},
                        {2, 2, 2},
                        {4, 3, 3}};
        int[][] allot = {{0, 1, 0},
                        {2, 0, 0},
                        {3, 0, 2},
                        {2, 1, 1},
                        {0, 0, 2}};
        isSafe(processes, avail, maxm, allot);
    }
}




/* 
import java.util.Arrays;
public class p7_safety
{
    static final int p = 5;
    static final int r = 3;
    static boolean safe(int[] process,int[][] max, int[][] alloc, int[] avl )
    {
        int[][] need = new int[p][r];
        for(int i=0;i<p;i++){
            for(int j=0;j<r;j++){
                need[i][j] = max[i][j]-alloc[i][j];
            }
        }
        boolean[] finish = new boolean[p];
        int[] work = avl.clone();
        int[] seq = new int[p];
        int cnt=0;
        while(cnt<p){
            boolean found = false;
            for(int i=0;i<p;i++){
                if(!finish[i] && can(need,i,work)){
                    for(int j=0;j<r;j++)
                        work[j] += alloc[i][j]; //work[j] remember
                    finish[i]=true;
                    seq[cnt++]=i;
                    found=true;
                }
            }
            if (!found) {
                System.out.println("System is not in safe state");
                return false;
            }
        }
        System.out.println("System is in safe state and seq is : " +Arrays.toString(seq));
            return true;
    }
    private static boolean can(int[][] need, int k, int[] work){
        for(int j=0;j<r;j++){
            if(need[k][j]>work[j]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        int[] process = {0,1,2,3,4};
        int[] avl = {3,3,2};
        int[][] max = {{7,5,3},
                        {3,2,2},
                         {9,0,2},
                          {2,2,2},
                            {4,3,3}};
        int[][] alloc = {{0,1,0},
                         {2,0,0},
                            {3,0,2},
                            {2,1,1},
                            {0,0,2}};
        safe(process, max, alloc, avl);
    }
}
*/

// class safety{
//     static int P = 5;
//     static int R = 3;
//     static void calculateNeed(int need[][], int maxm[][],int allot[][]){
//         for (int i = 0 ; i < P ; i++)
//             for (int j = 0 ; j < R ; j++)
//                 need[i][j] = maxm[i][j] - allot[i][j];
//     }
//     static boolean isSafe(int processes[], int avail[], int maxm[][],int allot[][]){
//         int [][]need = new int[P][R];
//         calculateNeed(need, maxm, allot);
//         boolean []finish = new boolean[P];
//         int []safeSeq = new int[P];
//         int []work = new int[R];
//         for (int i = 0; i < R ; i++)
//             work[i] = avail[i];
//         int count = 0;
//         while (count < P){
//             boolean found = false;
//             for (int p = 0; p < P; p++){
//                 if (finish[p] == false){
//                     int j;
//                     for (j = 0; j < R; j++)
//                         if (need[p][j] > work[j])
//                             break;
//                     if (j == R){
//                         for (int k = 0 ; k < R ; k++)
//                             work[k] += allot[p][k];
//                         safeSeq[count++] = p;
//                         finish[p] = true;
//                         found = true;
//                     }
//                 }
//             }
//             if (found == false){
//                 System.out.print("System is not in safe state");
//                 return false;
//             }
//         }
//         System.out.print("System is in safe state.\nSafe" +" sequence is: ");
//         for (int i = 0; i < P ; i++)
//             System.out.print(safeSeq[i] + " ");
//         return true;
//     }
//     public static void main(String[] args) {
//         int processes[] = {0, 1, 2, 3, 4};
//         int avail[] = {3, 3, 2};
//         int maxm[][] = {{7, 5, 3},
//                         {3, 2, 2},
//                         {9, 0, 2},
//                         {2, 2, 2},
//                         {4, 3, 3}};
//         int allot[][] = {{0, 1, 0},
//                         {2, 0, 0},
//                         {3, 0, 2},
//                         {2, 1, 1},
//                         {0, 0, 2}};
//         isSafe(processes, avail, maxm, allot);
//     }
// }




