//8. Write a program to simulate page replacement algorithms
//a) FIFO b) LRU c) LFU
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;

class p8b_LRU
{
    static void pagefaults(int pages[], int n, int cap)
    {
        HashSet<Integer> s = new HashSet<>(cap);
        HashMap<Integer,Integer> idx = new HashMap<>();
        int faults=0, hit =0;
        for(int i=0;i<n;i++){
            if(s.size()<cap){
                if(!s.contains(pages[i])){
                    s.add(pages[i]);
                    faults++;
                }
                else{
                    hit++;
                }
                idx.put(pages[i],i);
            }
            else{
                if(!s.contains(pages[i])){
                    int lru = Integer.MAX_VALUE, val = Integer.MIN_VALUE;
                    Iterator<Integer> itr = s.iterator();
                    while(itr.hasNext()){
                        int temp = itr.next();
                        if(idx.get(temp)<lru){
                            lru = idx.get(temp);
                            val = temp;
                        }
                    }
                    s.remove(val); //outside while loop
                    idx.remove(val);
                    s.add(pages[i]);
                    faults++;
                }
                else{
                    hit++;
                }
                idx.put(pages[i],i);
            }

        }
        System.out.println("Faults : " +faults +" hits : " +hit);
    }
    public static void main(String[] args)
    {
        int pages[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
        int cap = 4;
        pagefaults(pages, pages.length, cap);
    }
}



/*
 HashSet<Integer> s = new HashSet<>(cap);
        HashMap<Integer,Integer> idx = new HashMap<>();
        int faults=0, hit =0;
        for(int i=0;i<n;i++){
            if(s.size()<cap){
                if(!s.contains(pages[i])){
                    s.add(pages[i]);
                    faults++;
                }
                else{
                    hit++;
                }
                idx.put(pages[i],i);
            }
            else{
                if(!s.contains(pages[i])){
                    int lru = Integer.MAX_VALUE, val = Integer.MIN_VALUE;
                    Iterator<Integer> itr = s.iterator();
                    while(itr.hasNext()){
                        int temp = itr.next();
                        if(idx.get(temp)<lru){
                            lru = idx.get(temp);
                            val = temp;
                        }
                    }
                    s.remove(val); //outside while loop
                    idx.remove(val);
                    s.add(pages[i]);
                    faults++;
                }
                else{
                    hit++;
                }
                idx.put(pages[i],i);
            }

        }
 */





















// import java.util.HashMap; 
// import java.util.HashSet; 
// import java.util.Iterator; 
  
// class p8b_LRU
// { 
//     static int pageFaults(int pages[], int n, int capacity) 
//     { 
//         HashSet<Integer> s = new HashSet<>(capacity); 
//         HashMap<Integer, Integer> indexes = new HashMap<>(); 
//         int page_faults = 0; 
//         for (int i=0; i<n; i++) 
//         { 
//             if (s.size() < capacity) 
//             { 
//                 if (!s.contains(pages[i])) 
//                 { 
//                     s.add(pages[i]); 
//                     page_faults++; 
//                 } 
//                 indexes.put(pages[i], i); 
//             } 
//             else
//             { 
//                 if (!s.contains(pages[i])) 
//                 { 
//                     int lru = Integer.MAX_VALUE, val=Integer.MIN_VALUE; 
//                     Iterator<Integer> itr = s.iterator(); 
//                     while (itr.hasNext()) { 
//                         int temp = itr.next(); 
//                         if (indexes.get(temp) < lru) 
//                         { 
//                             lru = indexes.get(temp); 
//                             val = temp; 
//                         } 
//                     } 
//                     s.remove(val); 
//                     indexes.remove(val); 
//                     s.add(pages[i]); 
//                     page_faults++; 
//                 } 
//                 indexes.put(pages[i], i); 
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
