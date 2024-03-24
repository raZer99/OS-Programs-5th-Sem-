//2. Write a program to simulate producer-consumer problem using semaphores.
import java.util.concurrent.Semaphore;
class que{
    int item;
    static Semaphore con = new Semaphore(0);
    static Semaphore prod = new Semaphore(1);
    void get(){
        try{
            con.acquire();
        }
        catch(InterruptedException e){
            System.out.println("Interrupted exception caught");
        }
        System.out.println("Consumer consumed item : " +item);
        prod.release();
    }
    void put(int item){
        try{
            prod.acquire();
        }
        catch(InterruptedException e){
            System.out.println("Interrupted exception caught");
        }
        this.item=item;
        System.out.println("Producer produced item : " +item);
        con.release();
    }
}

class producer implements Runnable{
    que q;
    producer(que q){
        this.q=q;
        new Thread(this,"producer").start();
    }
    public void run(){
        for(int i=0;i<5;i++){
            q.put(i);
        }
    }
}

class consumer implements Runnable{
    que q;
    consumer(que q){
        this.q=q;
        new Thread(this,"consumer").start();
    }
    public void run(){
        for(int i=0;i<5;i++){
            q.get();
        }
    }
}

public class prog2{
    public static void main(String[] args){
        que q = new que();
        new consumer(q);
        new producer(q);
    }
}

























/* 
import java.util.concurrent.Semaphore;
class que
{
    int item;
    static Semaphore con = new Semaphore(0);
    static Semaphore prod = new Semaphore(1);
    void get(){
        try{
            con.acquire();
        } catch (InterruptedException e){
            System.out.println("Interrupted exception caught");
        }
        System.out.println("Consumer consumed item " +item);
        prod.release();
    }
    void put(int item){
        try{
            prod.acquire();
        } catch (InterruptedException e){
            System.out.println("Interrupted exception caught");
        }
        this.item=item;
        System.out.println("Producer produced item " +item);
        con.release();
    }
}

class producer implements Runnable{
    que q;
    producer(que q){
        this.q=q;
        new Thread(this,"producer").start();
    }
    public void run(){
        for(int i=0;i<5;i++){
            q.put(i);
        }
    }
}

class consumer implements Runnable{
    que q;
    consumer(que q){
        this.q=q;
        new Thread(this,"consumer").start();
    }
    public void run(){
        for(int i=0;i<5;i++){
            q.get();
        }
    }
}

public class prog2{
    public static void main(String[] args){
        que q= new que();
        new consumer(q);
        new producer(q);
    }
}
*/