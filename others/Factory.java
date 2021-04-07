
package NotFxml.Threading;

import java.util.logging.Level;
import java.util.logging.Logger;

class Truck implements Runnable{
    public static int mobileInTruck= 0;
    public static int truckCapacity;
    private Factory factory ;

    public void setFactory(Factory factory) {
        this.factory = factory;
    }


    

    public Truck( int truckCapacity) {

        this.truckCapacity = truckCapacity;
    }
  
    public  void takeMobile() throws InterruptedException{
        synchronized(factory){
        while(true){
            if(this.mobileInTruck==0 && Factory.mobileInFactory >=truckCapacity){
                Factory.mobileInFactory-= this.truckCapacity;
                this.mobileInTruck = this.truckCapacity;
                System.out.println("mobile taken");
                factory.notifyAll();
            }
            else{ 
                System.out.println("procuction occuring");
                factory.wait(); 
                
                this.mobileInTruck=0;
                System.out.println("got mobile");
            }
        }
        
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
    private Truck truck;

    public void setTruck(Truck truck) {
        this.truck = truck;
    }



        public Factory(int capacity) {
            this.capacity = capacity;
            

        }
    
    public  void produceMobile() throws InterruptedException{
        synchronized(truck){
            while(true){

                if(mobileInFactory >=Truck.truckCapacity){
                 //   System.out.println("truck capacity "+Truck.truckCapacity+" fullfiled");
                System.out.println("sending notification");   
                 truck.notify();
                }
                
                if(this.mobileInFactory==this.capacity){
                    System.out.println("capacity full");
                    
                    truck.wait();
                    System.out.println("mobile taken");
                }                
                else{
                    
                    this.mobileInFactory++;
                    Thread.sleep(200);
                    System.out.println("production increased to " + mobileInFactory);
                }
            
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
        factory.setTruck(truck);
        truck.setFactory(factory);
        Thread tfac= new Thread(factory, "factory");
        tfac.start();        
        Thread t= new Thread(truck, "truck");
        t.start();
      
    }
}
