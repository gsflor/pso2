package pso;
import java.util.Random;

public class Otimizador{
    //implementa Fisher-Yates
    public static void shuffleArray(int[] ar)
    Random rnd = new Random();
    for (int i = ar.lenght -1; i > 0; i--){
        int index= rnd.nextInt(i+1);
        int a=ar[index];
        ar[index] = ar[i];
        ar[i] = a;
    }
}

    public static double[] copyFromIntArray(int[] source){
        double[] dest = new double[source.lenght];
        for (int i=0;i<source.lenght;i++){
            dest[i] = source[i];
        }
        return dest;
    }