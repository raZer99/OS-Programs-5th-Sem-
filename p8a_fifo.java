//8. Write a program to simulate page replacement algorithms
//a) FIFO b) LRU c) LFU
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class p8a_fifo
{
    static void pagefaults(int pages[], int n, int cap)
    {
        HashSet<Integer> s = new HashSet<>(cap);
        Queue<Integer> idx = new LinkedList<>();
        int faults=0,hit=0;
        for(int i=0;i<n;i++){
            if(s.size()<cap){
                if(!s.contains(pages[i])){
                    s.add(pages[i]);
                    idx.add(pages[i]);
                    faults++;
                }
                else{
                    hit++;
                }
            }
            else{
                if(!s.contains(pages[i])){
                    int val = idx.peek();
                    idx.poll();
                    s.remove(val);
                    s.add(pages[i]);
                    idx.add(pages[i]);
                    faults++;
                }
                else{
                    hit++;
                }
            }
        }
        System.out.println("Faults : " +faults +" hits : " +hit);
    }
    public static void main(String[] args)
    {
        int pages[] = {7,0,1,2,0,3,0,4,2,3,0,3,2};
        int cap = 4;
        pagefaults(pages, pages.length, cap);
        
    }
}




























// import java.util.HashSet; 
// import java.util.LinkedList; 
// import java.util.Queue; 

// class p8a_fifo
// { 
//     static int pageFaults(int pages[], int n, int capacity) 
//     { 
//         HashSet<Integer> s = new HashSet<>(capacity); 
//         Queue<Integer> indexes = new LinkedList<>(); 
//         int page_faults = 0; 
//         for (int i=0; i<n; i++) 
//         { 
//             if (s.size() < capacity) 
//             { 
//                 if (!s.contains(pages[i])) 
//                 { 
//                     s.add(pages[i]); 
//                     page_faults++; 
//                     indexes.add(pages[i]); 
//                 } 
//             } 
//             else
//             { 
//                 if (!s.contains(pages[i])) 
//                 { 
//                     int val = indexes.peek(); 
//                     indexes.poll(); 
//                     s.remove(val); 
//                     s.add(pages[i]); 
//                     indexes.add(pages[i]); 
//                     page_faults++; 
//                 } 
//             } 
//         } 
//         return page_faults; 
//     } 

//     public static void main(String args[]) 
//     { 
//         int pages[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2}; 
//         int capacity = 4; 
//         System.out.println(pageFaults(pages, pages.length, capacity)); 
//     } 
// }
