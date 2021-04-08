
package NotFxml.Threading;

import java.util.logging.Level;
import java.util.logging.Logger;
class Seller implements Runnable{
    public  int sellCapacity;
    private static  Truck truck;
    public int mobileInShop=0;
    private int  mobiles=0;
    private String name;

    public void setTruck(Truck truck) {
        this.truck = truck;
    }
    public Seller(int sellCapacity, String name) {
        this.sellCapacity = sellCapacity;
        this.name= name;
    }
    public void sellMobile() throws InterruptedException{
        synchronized(truck)
        {
//            while(Truck.mobileInTruck!=0){
//                if(Truck.mobileInTruck-this.sellCapacity>=0){
//                    this.mobileInShop= this.sellCapacity;
//                    Truck.mobileInTruck-= this.sellCapacity;
//                    while(this.mobileInShop!=0){
//                        mobiles++;
//                        System.out.println(name +" selling mobile " +mobiles);
//                        Thread.sleep(2000);
//                        this.mobileInShop--;
//                    }
//                }
//                else{
//                    mobiles++;
//                    System.out.println( name+ " selling mobile " +mobiles);                    
//                    Truck.mobileInTruck--;
//                    Thread.sleep(2000);
//                }
            }
           truck.notify();
        }

    @Override
    public void run() {
                    while(Truck.mobileInTruck!=0){
                if(Truck.mobileInTruck-this.sellCapacity>=0){
                    this.mobileInShop= this.sellCapacity;
                    Truck.mobileInTruck-= this.sellCapacity;
                    while(this.mobileInShop!=0){
                        mobiles++;
                        System.out.println(name +" selling mobile " +mobiles);
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Seller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        this.mobileInShop--;
                    }
                }
                else{
                    mobiles++;
                    System.out.println( name+ " selling mobile " +mobiles);                    
                    Truck.mobileInTruck--;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Seller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
    }
    

    }


}
class Truck implements Runnable{
    public static int mobileInTruck= 0;
    public static int truckCapacity;
    private Factory factory ;
    private Seller seller1;
    private Seller seller2;
    public void setFactory(Factory factory) {
        this.factory = factory;
    }
    public Truck( int truckCapacity) {

        this.truckCapacity = truckCapacity;
    }

    public void setSeller1(Seller seller) {
        this.seller1 = seller;
    }
    public void setSeller2 (Seller seller) {
        this.seller2 = seller;
    }  
    public  void takeMobile() throws InterruptedException{
        synchronized(this){
            while(true){
                if(this.mobileInTruck==0 && Factory.mobileInFactory >=truckCapacity){
                    Factory.mobileInFactory-= this.truckCapacity;
                    this.mobileInTruck = this.truckCapacity;
                    System.out.println("truck  took mobile from factory");
                    System.out.println("going to sell..");
                    Thread.sleep(3000);
                    System.out.println("reached destination");
                    System.out.println(this.mobileInTruck+" mobiles in truck");
                    
        Thread sellerT2 = new Thread(seller2, "seller1");  
        Thread sellerT = new Thread(seller1, "seller2"); 
        sellerT2.start();  
        sellerT.start();
                sellerT2.join();
                sellerT.join();
                    this.notify();
                }
                else{ 
                    System.out.println("truck waiting");
                    this.wait();
                    this.mobileInTruck=0;
                    System.out.println("got notification");
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
                    System.out.println("sending notification to truck");   
                    truck.notify();
                }
                
                if(this.mobileInFactory==this.capacity){
                    System.out.println("capacity full");                   
                    truck.wait();
                    System.out.println("mobile taken confirmed from factory");
                    System.out.println("new production started");
                }                
                else{
                    this.mobileInFactory++;
                    Thread.sleep(2000);
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
        Truck truck =  new Truck(5);
        Seller seller = new Seller(2, "seller 1");
        factory.setTruck(truck);
        truck.setFactory(factory);
        seller.setTruck(truck);

        Seller seller2 = new Seller(2, "seller 2");
        seller2.setTruck(truck);
        Thread tfac= new Thread(factory, "factory");
        Thread t= new Thread(truck, "truck");
   //     Thread sellerT = new Thread(seller, "seller1");  
     //   Thread sellerT2 = new Thread(seller2, "seller2");  
        truck.setSeller1(seller);
        truck.setSeller1(seller);
        t.start();
        tfac.start(); 
 //       sellerT.start();  
  //      sellerT2.start();
      
    }
}
