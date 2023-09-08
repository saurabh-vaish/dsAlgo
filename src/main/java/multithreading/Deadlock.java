package multithreading;

/**
 * Example of Deadlock and how to prevent it
 *Deadlock when multiple thread acquire lock on same resource
 * to solve this problem need to acquire lock on same order in which holding lock in other thread on resource
 *
 * @Author saurabh vaish
 * @Date 06-09-2023
 */
public class Deadlock {

    private final Object obj1 = new Object();
    private final Object obj2 = new Object();

    // deadlock using user defined class values / resources
    // Thread is having lock on obj1 but can not get lock on obj2
    // as obj2 is locked earlier by thread so here lock can't be acquired further
    public void someTask1(){
        synchronized (obj1){
            System.out.println("Acquired lock on Obj1 object in m1");
            synchronized (obj2){
                System.out.println("Acquired lock on Obj2 object in m1");

            }
            System.out.println("Released lock on obj2 object in m1");
        }
        System.out.println("Released lock on obj1 object in m1");
    }

    // deadlock using user defined class values / resources
    // Thread is having lock on obj2 but can not get lock on obj1
    // as obj1 is locked earlier by thread so here lock can't be acquired further
    public void someTask2(){
        synchronized (obj2){
            System.out.println("Acquired lock on obj2 object in m2");
            synchronized (obj1){
                System.out.println("Acquired lock on obj1 object in m2");

            }
            System.out.println("Released lock on obj1 object in m2");
        }
        System.out.println("Released lock on obj2 object in m2");
    }

    // deadlock using existing classes
    // Thread is having lock on String class but can not get lock on Integer class
    // as Integer class is locked earlier by thread so here lock can't be acquired further
    public void someTask3(){
        synchronized (String.class) {
            System.out.println("Acquired lock on String.class object");

            synchronized (Integer.class) {
                System.out.println("Acquired lock on Integer.class object");
            }
            System.out.println("Released lock on Integer.class object");
        }
        System.out.println("Released lock on String.class object");
    }

    // here we are having lock on Integer class then String class
    // Thread is having lock on Integer class but can not get lock on String class
    // as String class is locked earlier by thread so here lock can't be acquired further
    public void someTask4(){
        synchronized (Integer.class) {
            System.out.println("Acquired lock on Integer.class object");

            synchronized (String.class) {
                System.out.println("Acquired lock on String.class object");
            }
            System.out.println("Released lock on String.class object");
        }
        System.out.println("Released lock on Integer.class object");
    }

// ====================================== Solution ===================================
    // solution is acquire lock on resources based on same order we are holding lock in other thread

    public void someTask5(){
        synchronized (obj1){
            System.out.println("Acquired lock on Obj1 object in m5");
            synchronized (obj2){
                System.out.println("Acquired lock on Obj2 object in m5");

            }
            System.out.println("Released lock on obj2 object in m5");
        }
        System.out.println("Released lock on obj1 object in m5");
    }

    public void someTask6(){
        synchronized (obj1){
            System.out.println("Acquired lock on obj1 object in m6");
            synchronized (obj2){
                System.out.println("Acquired lock on obj2 object in m6");

            }
            System.out.println("Released lock on obj2 object in m6");
        }
        System.out.println("Released lock on obj1 object in m6");
    }

    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock();

        // creating two runnable tasks
        Runnable r1 = deadlock::someTask1;  // ()->deadlock.someTask1();
        Runnable r2 = deadlock::someTask2;
//        Runnable r1 = deadlock::someTask3;  // ()->deadlock.someTask1();
//        Runnable r2 = deadlock::someTask4;

        // creating thread from runnable and calling
//        new Thread(r1).start();
//        new Thread(r2).start();

        Runnable r5 = deadlock::someTask5;  // ()->deadlock.someTask1();
        Runnable r6 = deadlock::someTask6;

        // creating thread from runnable and calling
        new Thread(r5).start();
        System.out.println();
        new Thread(r6).start();
    }

}
