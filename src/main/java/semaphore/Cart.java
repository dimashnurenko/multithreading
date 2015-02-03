package semaphore;

/**
 * Created by Шнуренко on 02.02.2015.
 */
public class Cart {
    private static int weight = 0;

    public static void addWeight(){
        weight--;
    }

    public static void reduceWeight(){
        weight++;
    }

    public static int getWaight(){
        return weight;
    }
}
