/*
This problem tests your knowledge of Threads. Write a program named 
SimpleThreading.java to create several threads and a simple counter. The main 
program will instantiate an object of class Threads, calling its constructor. 
The constructor will generate the following output (beginning of output omitted 
for space):

    Thread 5 counter 42 
    Thread 4 counter 39 
    Thread 3 counter 36 
    Thread 2 counter 33 
    Thread 1 counter 30 
    Thread 5 counter 27 
    Thread 2 counter 24 
    Thread 1 counter 21 
    Thread 3 counter 18 
    Thread 4 counter 15 
    Thread 1 counter 12 
    Thread 4 counter 9 
    Thread 3 counter 6 
    Thread 5 counter 3 
    Thread 2 counter 0 
    Main: at end counter = 0

As shown, it will create 5 threads named 1 through 5 as shown above. The threads 
will share a common (global) counter which is set to 90 before any of them is 
started.

The threads will loop. On each iteration they will, in a thread-safe manner:
    • Subtract 3 from the shared counter
    • Print the thread name and the counter
    • NOTE: since the subtraction happens before printing, the first value 
      printed is 87 and the last value is 0.
    • Sleep for 2 msec. (unsynchronized)

When the counter reaches 0, the thread will terminate (return from the run()
method).

Note that the count is decreasing and does not duplicate. Also note that the 
thread numbers are not in any particular order. Your thread numbers will NOT be 
in the same order as shown, nor should they be the same on any two runs.

The counter should count down, in order, from 87 to 0. The example above does 
this, although the beginning lines have scrolled off the top. Once all threads 
have finished, the code that created the threads should print out the common 
counter.

Note: There are only 5 threads (besides the main thread). You have the freedom 
to code this any way you want as long as the threads run concurrently.

*/

/*
@ASSESSME.USERID: brm2167
@ASSESSME.AUTHOR: Benjamin R. Metzger
@ASSESSME.DESCRIPTION: PRACTICEPRACTICAL3
@ASSESSME.ANALYZE: YES
*/

public class SimpleThreading {
    private int counter = 90;

    /**
     * Subtracts an amount from the counter and prints it to the console.
     * @param amount the amount to subtract from the counter
     */
    public synchronized void decrement(int threadid, int amount) {
        if (counter == 0) return;
        System.out.printf(
            "Thread %d counter %d\n", threadid,  counter -= amount
        );
    }

    class Decrementor extends Thread {
        private int id;
        private static int lastId = 0;

        /**
         * Constructs a new instance of the Decrementor class with an
         * automatically incremented ID.
         */
        public Decrementor() {
            this.id = ++lastId;
        }

        /**
         * Decrements from the shared counter until it reaches 0.
         */
        @Override
        public void run() {
            while (counter > 0) {
                decrement(id, 3);
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
   
    public SimpleThreading(){
        for (int i = 0; i < 5; i++) new Decrementor().start();
    }

    public static void main(String[] args) {
        new SimpleThreading();
    }
    
    
}
