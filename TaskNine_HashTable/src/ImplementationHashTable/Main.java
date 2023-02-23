package ImplementationHashTable;

public class Main {
    public static void main(String[] args) {

        // int size = 1000;
        Zip1 file = new Zip1("C:\\Users\\alisu\\TaskNine_HashTable\\src\\postnummer.csv");
       /* System.out.println("linear serach");
        double totaltimeSthlm = 0;
        double totalTimePajala = 0;
        int tries = 1000;
        for (int i = 0; i < tries; i++) {
            long t0 = System.nanoTime();
            file.lookup("111 15");
            long t1 = System.nanoTime();
            totaltimeSthlm = (t1 - t0);

            long t = System.nanoTime();
            file.lookup("984 99");
            long t2 = System.nanoTime();
            totalTimePajala = (t2 - t);
        }
        System.out.println(file.lookup("111 15").code + " " + file.lookup("111 15").name + " " + file.lookup("111 15").pop + " exekveringstiden är " + totaltimeSthlm / tries + " nano sekunder");
        System.out.println(file.lookup("984 99").code + " " + file.lookup("984 99").name + " " + file.lookup("984 99").pop + " exekveringstiden är " + totalTimePajala / tries + " nano sekunder");

        // benchmar for binary search
        System.out.println(" ");
        System.out.println("Binary search");
        for (int i = 0; i < tries; i++) {
            long t0 = System.nanoTime();
            file.binaryLookup("111 15");
            long t1 = System.nanoTime();
            totaltimeSthlm = (t1 - t0);

            long t = System.nanoTime();
            file.binaryLookup("984 99");
            long t2 = System.nanoTime();
            totalTimePajala = (t2 - t);
        }
        System.out.println(file.binaryLookup("111 15").code + " " + file.binaryLookup("111 15").name + " " + file.binaryLookup("111 15").pop + " exekveringstiden är " + totaltimeSthlm / tries + " nano sekunder");
        System.out.println(file.binaryLookup("984 99").code + " " + file.binaryLookup("984 99").name + " " + file.binaryLookup("984 99").pop + " exekveringstiden är " +  totalTimePajala / tries + " nano sekunder");
*/

         // benchmark when I changed from String to integer
      /* System.out.println("linear serach");
        double totaltimeSthlm = 0;
        double totalTimePajala = 0;
        int tries = 1000;
        for (int i = 0; i < tries; i++) {
            long t0 = System.nanoTime();
            file.lookup(11115);
            long t1 = System.nanoTime();
            totaltimeSthlm = (t1 - t0);

            long t = System.nanoTime();
            file.lookup(98499);
            long t2 = System.nanoTime();
            totalTimePajala = (t2 - t);
        }
        System.out.println(file.lookup(11115).code + " " + file.lookup(11115).name + " " + file.lookup(11115).pop + " exekveringstiden är " + totaltimeSthlm / tries + " nano sekunder");
        System.out.println(file.lookup(98499).code + " " + file.lookup(98499).name + " " + file.lookup(98499).pop + " exekveringstiden är " + totalTimePajala / tries + " nano sekunder");

        // benchmar for binary search
        System.out.println(" ");
        System.out.println("Binary search");
        for (int i = 0; i < tries; i++) {
            long t0 = System.nanoTime();
            file.binaryLookup(11115);
            long t1 = System.nanoTime();
            totaltimeSthlm = (t1 - t0);

            long t = System.nanoTime();
            file.binaryLookup(98499);
            long t2 = System.nanoTime();
            totalTimePajala = (t2 - t);
        }
        System.out.println(file.binaryLookup(11115).code + " " + file.binaryLookup(11115).name + " " + file.binaryLookup(11115).pop + " exekveringstiden är " + totaltimeSthlm / tries + " nano sekunder");
        System.out.println(file.binaryLookup(98499).code + " " + file.binaryLookup(98499).name + " " + file.binaryLookup(98499).pop + " exekveringstiden är " +  totalTimePajala / tries + " nano sekunder");
 */

            // change the code to keys for the hash function
       /* System.out.println("linear serach");
        double totaltimeSthlm = 0;
        double totalTimePajala = 0;
        int tries = 100;
        for (int i = 0; i < tries; i++) {
            long t0 = System.nanoTime();
            file.lookup(11115);
            long t1 = System.nanoTime();
            totaltimeSthlm = (t1 - t0);

            long t = System.nanoTime();
            file.lookup(98499);
            long t2 = System.nanoTime();
            totalTimePajala = (t2 - t);
        }
        System.out.println(file.lookup(11115).code + " " + file.lookup(11115).name + " " + file.lookup(11115).pop + " exekveringstiden är " + totaltimeSthlm / tries + " nano sekunder");
        System.out.println(file.lookup(98499).code + " " + file.lookup(98499).name + " " + file.lookup(98499).pop + " exekveringstiden är " + totalTimePajala / tries + " nano sekunder");

        // benchmar for binary search
        System.out.println(" ");
        System.out.println("Binary search");
        for (int i = 0; i < tries; i++) {
            long t0 = System.nanoTime();
            file.lookup(11115);
            long t1 = System.nanoTime();
            totaltimeSthlm = (t1 - t0);

            long t = System.nanoTime();
            file.lookup(98499);
            long t2 = System.nanoTime();
            totalTimePajala = (t2 - t);
        }
        System.out.println(file.binaryLookup(11115).code + " " + file.binaryLookup(11115).name + " " + file.binaryLookup(11115).pop + " exekveringstiden är " + totaltimeSthlm / tries + " nano sekunder");
        System.out.println(file.binaryLookup(98499).code + " " + file.binaryLookup(98499).name + " " + file.binaryLookup(98499).pop + " exekveringstiden är " +  totalTimePajala / tries + " nano sekunder");
        */


        System.out.println(" output for hashing and collision");
        double totaltimeCollision = 0;
        int tries = 1000;
        for( int i = 0; i < tries; i++){
            long t0 = System.nanoTime();
            file.collisions(10000);
            long t1 = System.nanoTime();
            totaltimeCollision = (t1 - t0);
        }
        System.out.println( " exekveringstiden " + totaltimeCollision/tries);


        //file.collisions(7919);
        //file.print();
        //System.out.println(file.collisions(100000));







        //System.out.println(totaltimeSthlm/tries);
        //int sthlm = 11115%size;
        //System.out.println(file.data[sthlm].code + " " + file.data[sthlm].name + file.data[sthlm].pop );
        //System.out.println(file.lookup("111 15").code + " " + file.lookup("111 15").name + " " + file.lookup("111 15").pop);
        //System.out.println(file.lookup("984 99").code + " " + file.lookup("984 99").name + " " + file.lookup("984 99").pop);

    }
}
