import java.util.concurrent.ThreadLocalRandom;


public class UF {
    public static int[] id;

    public static void initialize(int N) {
        /**
         * Args:
         *     N (int): length of array id[]
         * gives the array id[] N length with all values equal to index
         * e.g.: id[2] = 2, id[72] = 72
         */
        id = new int[N];
        for(int i=0; i<id.length; i++) {
            id[i] = i;
        }
    }

    public static void connect(int i, int j) {
        /**
         * Args:
         *    i (int): index to be connected to j
         *    j (int): index to be connected to i
         * connects i to j, j to i
         */
        if(connected(i, j)) {
            System.out.println(i + " and " + j + " are already connected");
            return;
        }
        int k;
        if (id[i] == i) {
            k = getRoot(j);
            id[k] = i;
        } else if (id[j] == j) {
            k = getRoot(i);
            id[k] = j;
        } else {
            int m;
            k = getRoot(i);
            m = getRoot(j);
            id[m] = k;
        }
    }

    public static int getRoot(int a) {
        while (id[a] != a) {
            a = id[a];
        }
        return a;

    }

    public static boolean connected(int i, int j) {
        /**
         * Args:
         *     i (int), j (int): indexes to check if connected
         * Returns:
         *     true if are connected, else false
         */
        
        
        return false; //delete
    }

    public static boolean allConnected() {
        /**
         * check if all nodes are connected
         */
        for(int k = 0; k<id.length; k++) {
            if (id[k] != id[0]) {
                return false;
            }
        }
        return true;
    }

    public static int getRandomInt() {
        /**
         * returns a random integer from 0 to the length of array id[]
         */
        return ThreadLocalRandom.current().nextInt(0, id.length);
    }

    public static void main(String[] args) {
        /**
         * initializes array id[], then connects values at random indexes until
         * all are connected
         */
        initialize(10);
        int i;
        int j;
        while (!allConnected()) {
            i = getRandomInt();
            j = getRandomInt();
            connect(i, j);
        }
        for(int k=0; k<id.length; k++) {
            System.out.println(id[k]);
        }
    }

}

