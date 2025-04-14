/*
@ASSESSME.USERID: brm2167
@ASSESSME.AUTHOR: Benjamin R. Metzger
@ASSESSME.DESCRIPTION: PRACTICEPRACTICAL3
@ASSESSME.ANALYZE: YES
*/

public class FunWithThreads3 {
    private static int counter = 0;

    /**
     * Increments the counter by 1.
     */
    public synchronized void increment() {
        counter++;
    }

    class Counter extends Thread {
        /**
         * Increments the counter 40,000 times.
         */
        @Override
        public void run() {
            for (int i = 0; i < 40000; i++) increment();
        }
    }


    //Constructor of FunWithThreads
    public FunWithThreads3(){
        System.out.println("MAIN START");

        Thread counter1 = new Counter();
        Thread counter2 = new Counter();

        counter1.start();
        counter2.start();

        try {
            counter1.join();
            counter2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     
        System.out.println(counter);
        System.out.println("MAIN END");
    }

    public static void main(String[] args) throws Exception {
        
        new FunWithThreads3();

    }

    
}

