/*
@ASSESSME.USERID: brm2167
@ASSESSME.AUTHOR: Benjamin R. Metzger
@ASSESSME.DESCRIPTION: PRACTICEPRACTICAL3
@ASSESSME.ANALYZE: YES
*/

public class FunWithThreads1 {
    class MyThread implements Runnable {
        private int id;
        private static int lastId = 0;

        /**
         * Constructs a new instance of the MyThread class with an automatically
         * incremented ID.
         */
        public MyThread() {
            this.id = ++lastId;
        }

        /**
         * Counts from 0-9 in the command line, printing the thread and number
         * every second until complete.
         */
        @Override
        public void run() {
            System.out.printf("Thread start: Thread %d\n", id);
            for (int i = 0; i < 10; i++) {
                System.out.printf("Thread %d %d\n", id, i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.printf("Thread end: Thread %d\n", id);
        }
    }


    //Constructor of FunWithThreads
    public FunWithThreads1(){
        System.out.println("MAIN START");

        for (int i = 0; i < 2; i++) new Thread(new MyThread()).start();
       
        System.out.println("MAIN END");
    }

    public static void main(String[] args) throws Exception {
        
        new FunWithThreads1();

    }

    /*
     * 
     * 
     * Main Thread START
        Main Thread END
        Thread 1 0
        Thread 2 0
        Thread 1 1
        Thread 2 1
        Thread 1 2
        Thread 2 2
        Thread 1 3
        Thread 2 3
        Thread 1 4
        Thread 2 4
        Thread 1 5
        Thread 2 5
        Thread 1 6
        Thread 2 6
        Thread 1 7
        Thread 2 7
        Thread 1 8
        Thread 2 8
        Thread 1 9
        Thread 2 9
     */


}
