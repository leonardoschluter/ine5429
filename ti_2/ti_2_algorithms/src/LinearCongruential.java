public class LinearCongruential {

    public void generate(long iteration, long modulus, long a, long c, long seed){
        for(int i = 0; i < iteration; i ++){
            seed = (a*seed +c) % modulus;
            System.out.println(seed);
        }
    }
}
