
package NotFxml.Threading;

import java.util.logging.Level;
import java.util.logging.Logger;

class Truck implements Runnable{
    public static int mobileInTruck= 0;
    public static int truckCapacity;
     

    public Truck( int truckCapacity) {
        Thread t= new Thread(this);
        t.start();
        this.truckCapacity = truckCapacity;
    }
  
    public synchronized void takeMobile() throws InterruptedException{
        while(true){
            if(this.mobileInTruck==0 && Factory.mobileInFactory >=truckCapacity){
                Factory.mobileInFactory-= this.truckCapacity;
                this.mobileInTruck = this.truckCapacity;
                System.out.println("mobile taken");
                notifyAll();
            }
            else{ 
                System.out.println("procuction occuting");
                wait(); 
                
            this.mobileInTruck=0;
            System.out.println("got mobile"); }
        }
            
}

    @Override
    public void run() {
        try {
            takeMobile();
        } catch (InterruptedException ex) {
            Logger.getLogger(Truck.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public class Factory implements Runnable {
    public static int mobileInFactory=0;
    public static int capacity;
    

        public Factory(int capacity) {
            this.capacity = capacity;
            
            Thread t= new Thread(this);
            t.start();
        }
    
    public synchronized void produceMobile() throws InterruptedException{
        
            while(true){

                if(mobileInFactory >=Truck.truckCapacity){
                 //   System.out.println("truck capacity "+Truck.truckCapacity+" fullfiled");
                    System.out.println("sending notification");   
                 notifyAll();
                }
                
                if(this.mobileInFactory==this.capacity){
                    System.out.println("capacity full");
                    
                    wait();
                    System.out.println("mobile taken");
                }                
                else{
                    System.out.println("production increased to " +( mobileInFactory+1));
                    this.mobileInFactory++;
                    Thread.sleep(200);
                }
            
                
        }
    }
    @Override
    public void run() {
        try {
            produceMobile();
        } catch (InterruptedException ex) {
            Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
class Main{
    public static void main(String[] args) {
        Factory factory = new Factory(5);
        Truck truck =  new Truck(4);
        
    }
}
