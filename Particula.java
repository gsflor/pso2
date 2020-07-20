    //ablubelubebe//
    package pso;
    import java.util.Arrays;
    import java.util.Random;

    public class Particula {

    double[] xSol;
    double xFitnessValue;
    
    double[] pBest;
    double pBestValue;
    double[] pBestVelocity;
    
    double[] pVelocity;

    public Particula(int[] x){
        this.xSol = Otimizador.copyFromIntArray(x);  
        this.pBest = this.xSol;
        setVelRand(xSol.length);
        this.pBestVelocity = pVelocity;
    }

        public void setVelRand(int n) {
            this.pVelocity = new double[n];
            // randomly generate the velocity
            for (int i = 0; i < n; i++) {
                this.pVelocity[i] = getRandomVelocity(n);
            }
        }

    private double getRandomVelocity(int upper) {
        int lower = 0;
        return (new Random().nextDouble() * (upper - lower)) + lower;
        }     
    }