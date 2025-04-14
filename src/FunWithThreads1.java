/*
@ASSESSME.USERID: brm2167
@ASSESSME.AUTHOR: Benjamin R. Metzger
@ASSESSME.DESCRIPTION: PRACTICEPRACTICAL3
@ASSESSME.ANALYZE: YES
*/

public class FunWithThreads1 {


    //Constructor of FunWithThreads
    public FunWithThreads1(){
        System.out.println("MAIN START");
       
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
