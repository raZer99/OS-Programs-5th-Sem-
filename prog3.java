//3. Write a program to simulate the concept of Dining-Philosophers problem.
import java.util.concurrent.Semaphore;
class philosopher implements Runnable{
    private Semaphore room;
    private int phil;
    private Semaphore[] chop;
    public philosopher(int phil, Semaphore room, Semaphore[] chop)
    {
        this.phil=phil;
        this.room=room;
        this.chop=chop;
    }
    private void eat(){
        System.out.println("Philosopher " +phil +" has started eating.");
    }
    public void run(){
        try{
            room.acquire();
            System.out.println("Philosopher " +phil +" has entered the room.");
            chop[(phil+1)%5].acquire();
            eat();
            Thread.sleep(2000);
            System.out.println("Philosopher " +phil +" has finished eating.");
            chop[(phil+1)%5].release();
            chop[phil].release();
            room.release();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class prog3 {
    public static void main(String[] args){
        Semaphore room = new Semaphore(4);
        Semaphore[] chop = new Semaphore[5];
        for(int i=0;i<5;i++){
            chop[i] = new Semaphore(1);
        }
        Thread[] threads = new Thread[5];
        for(int i=0;i<5;i++){
            threads[i] = new Thread(new philosopher(i, room, chop));
        }
        try{
            for(int i=0;i<5;i++){
                threads[i].join();
                threads[i].start(); //remember to start ()
            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

























/* 
import java.util.concurrent.Semaphore;
class philosopher implements Runnable{
    private int phil;
    private Semaphore room;
    private Semaphore[] chopstick;
    public philosopher(int phil,Semaphore room, Semaphore[] chopstick){
        this.phil=phil;
        this.room=room;
        this.chopstick=chopstick;
    }
    private void eat(){
        System.out.println("Philosopher " +phil +"has started eating");
    } 
    public void run(){
        try{
            room.acquire();
            System.out.println("Philosopher " +phil +"has entered the room");
            chopstick[(phil+1)%5].acquire();
            eat();
            Thread.sleep(2000);
            System.out.println("Philosopher " +phil +"has finished eating");
            chopstick[(phil+1)%5].release();
            chopstick[phil].release();
            room.release();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class prog3{
    public static void main(String[] args){
        Semaphore room = new Semaphore(4);
        Semaphore[] chopstick = new Semaphore[5];
        for(int i=0;i<5;i++){
            chopstick[i] = new Semaphore(1);
        }
        Thread[] threads = new Thread[5];
        for(int i=0;i<5;i++){
            threads[i] = new Thread(new philosopher(i,room,chopstick));
            threads[i].start();
        }
        for(int i=0;i<5;i++){
            try{
                threads[i].join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
*/