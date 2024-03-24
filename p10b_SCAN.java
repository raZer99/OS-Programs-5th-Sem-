//10. Write a program to simulate the following Disk Scheduling Algorithms
//a) FCFS b) SCAN c) C-SCAN
import java.util.*;
public class p10b_SCAN
{
    static int size=8;
    static int disk=200;
    static void SCAN(int arr[],int head,String dir)
    {
        int crttrk, dis, skcnt=0;
        Vector<Integer> left = new Vector<Integer>(),
                        right = new Vector<Integer>(),
                        seq = new Vector<Integer>();

        if(dir=="left") left.add(0);
        else if(dir=="right") right.add(disk-1);

        for(int i=0;i<size;i++){
            if(arr[i]<=head) left.add(arr[i]);
            else right.add(arr[i]);
        }

        Collections.sort(left);
        Collections.sort(right);
        int run=2;
        while(run-- >0){
            if(dir=="left"){
                for(int i=left.size()-1;i>=0;i--){
                    crttrk = left.get(i);
                    dis = Math.abs(crttrk-head);
                    skcnt += dis;
                    seq.add(crttrk);
                    head = crttrk;
                }
                dir = "right";
            }
            else if(dir=="right"){
                for(int i=0;i<right.size();i++){
                    crttrk = right.get(i);
                    dis = Math.abs(crttrk-head);
                    skcnt += dis;
                    seq.add(crttrk);
                    head = crttrk;
                }
                dir = "left";
            }
        }
        System.out.println("The total seek oprn is : " +skcnt);
        System.out.println("Seek sequence is : ");
        for(int i=0;i<seq.size();i++){
            System.out.println(seq.get(i));
        }
    }
    public static void main(String args[])
    {
        int arr[] ={176, 79, 34, 60, 92, 11, 41, 114};
        int head=50;
        String dir = "left";
        SCAN(arr,head,dir);
    }
}



/*
 * int crtrk,dis,skcnt=0;
        Vector<Integer> left = new Vector<Integer>(),
                        right = new Vector<Integer>(),
                        seq = new Vector<Integer>();

        if(dir=="left") left.add(0);
        else if(dir =="right") right.add(disk-1);
        for(int i=0;i<size;i++){
            if(arr[i]<head) left.add(arr[i]);
            else right.add(arr[i]);
        }
        Collections.sort(left);
        Collections.sort(right);
        int run=2;
        while(run-- >0){
            if(dir=="left"){
                for(int i=left.size()-1;i>=0;i--){
                    crtrk=left.get(i);
                    dis = Math.abs(crtrk - head);
                    skcnt +=dis;
                    seq.add(crtrk);
                    head = crtrk;
                }
                dir="right";
            }
            else if(dir=="right"){
                for(int i=0;i<right.size();i++){
                    crtrk=right.get(i);
                    dis = Math.abs(crtrk - head);
                    skcnt +=dis;
                    seq.add(crtrk);
                    head = crtrk;
                }
                dir="left";
            }
        }
        System.out.println("The total seek oprn is : " +skcnt);
        System.out.println("Seek sequence is : ");
        for(int i=0;i<seq.size();i++){
            System.out.println(seq.get(i));
        }
 */























/*import java.util.*;
 
class p10b_SCAN{
    static int size = 8;
    static int disk_size = 200;
    static void SCAN(int arr[], int head, String direction){
        int seek_count = 0;
        int distance, cur_track;
        Vector<Integer> left = new Vector<Integer>(),
                        right = new Vector<Integer>();
        Vector<Integer> seek_sequence = new Vector<Integer>();
    
        if (direction == "left")
            left.add(0);
        else if (direction == "right")
            right.add(disk_size - 1);
    
        for (int i = 0; i < size; i++) {
            if (arr[i] < head)
                left.add(arr[i]);
            if (arr[i] > head)
                right.add(arr[i]);
        }
        Collections.sort(left);
        Collections.sort(right);
        int run = 2;
        while (run-- >0){
            if (direction == "left") {
                for (int i = left.size() - 1; i >= 0; i--) {
                    cur_track = left.get(i);
                    seek_sequence.add(cur_track);
                    distance = Math.abs(cur_track - head);
                    seek_count += distance;
                    head = cur_track;
                }
                direction = "right";
            }
            else if (direction == "right") {
                for (int i = 0; i < right.size(); i++) {
                    cur_track = right.get(i);
                    seek_sequence.add(cur_track);
                    distance = Math.abs(cur_track - head);
                    seek_count += distance;
                    head = cur_track;
                }
                direction = "left";
            }
        }
        System.out.print("Total number of seek operations = " + seek_count + "\n");
        System.out.print("Seek Sequence is" + "\n");
        for (int i = 0; i < seek_sequence.size(); i++){
            System.out.print(seek_sequence.get(i) + "\n");
        }
    }
    public static void main(String[] args){
        int arr[] = { 176, 79, 34, 60, 92, 11, 41, 114 };
        int head = 50;
        String direction = "left";
        SCAN(arr, head, direction);
    }
}*/