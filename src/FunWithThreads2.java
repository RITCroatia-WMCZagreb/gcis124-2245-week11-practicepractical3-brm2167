/*
@ASSESSME.USERID: brm2167
@ASSESSME.AUTHOR: Benjamin R. Metzger
@ASSESSME.DESCRIPTION: PRACTICEPRACTICAL3
@ASSESSME.ANALYZE: YES
*/

public class FunWithThreads2 {
    class Counter extends Thread {
        private int id;
        private static int lastId = 0;

        /**
         * Constructs a new instance of the Counter class with an automatically
         * incremented ID.
         */
        public Counter() {
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
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("Thread %d %d\n", id, i);
            }
            System.out.printf("Thread end: Thread %d\n", id);
        }
    }

    //Constructor of FunWithThreads
    public FunWithThreads2(){
        System.out.println("MAIN START");
        
        Thread counter1 = new Counter();
        counter1.start();
        try {
            counter1.join(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Counter().start();
        try {
            counter1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("MAIN END");
    }

    public static void main(String[] args) throws Exception {
        
        new FunWithThreads2();

    }


}

/*
 * 
 * 
 * Main Thread START
Thread start:Thread 1
Thread 1 0
Thread 1 1
Thread 1 2
Thread 1 3
Thread start:Thread 2
Thread 1 4
Thread 2 0
Thread 1 5
Thread 2 1
Thread 2 2
Thread 1 7
Thread 2 3
Thread 1 8
Thread 2 4
Thread 1 9
Thread end:Thread 1
Main Thread END
Thread 2 5
Thread 2 6
Thread 2 7
Thread 2 8
Thread 2 9
Thread end:Thread 2
 */