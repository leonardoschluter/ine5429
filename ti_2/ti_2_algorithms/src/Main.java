import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
/*
        MultiplyWIthCarry mwc = new MultiplyWIthCarry();
        System.out.println(convertToBinary(mwc.nextInt()) + "" + convertToBinary(mwc.nextInt())+ "" + convertToBinary(mwc.nextInt())+ "" + convertToBinary(mwc.nextInt())+ "" + convertToBinary(mwc.nextInt())+ "" + convertToBinary(mwc.nextInt())+ "" + convertToBinary(mwc.nextInt())+ "" + convertToBinary(mwc.nextInt())+ "" + convertToBinary(mwc.nextInt())+ "" + convertToBinary(mwc.nextInt())+ "" + convertToBinary(mwc.nextInt())+ "" + convertToBinary(mwc.nextInt())+ "" + convertToBinary(mwc.nextInt())+ "" + convertToBinary(mwc.nextInt())+ "" + convertToBinary(mwc.nextInt())+ "" + convertToBinary(mwc.nextInt())+ "" + convertToBinary(mwc.nextInt())+ "" + convertToBinary(mwc.nextInt())+ "" + convertToBinary(mwc.nextInt())+ "" + convertToBinary(mwc.nextInt())+ "" + convertToBinary(mwc.nextInt())+ "" + convertToBinary(mwc.nextInt())+ "" + convertToBinary(mwc.nextInt())+ "" + convertToBinary(mwc.nextInt()));


        LinearCongruential lgc = new LinearCongruential();
        lgc.generate(1000, Double.doubleToLongBits(Math.pow(2, 32)), 16843009, 11, System.nanoTime());
*/


        SecureRandom r = new SecureRandom();
        System.out.println("Generating stock random seed");
        r.nextInt(); // need to do something for SR to be triggered.

        // Use this seed to generate a n-value for Blum-Blum-Shub
        // This value can be re-used if desired.
        System.out.println("Generating N");
        int bitsize = 512;
        BigInteger nval = BlumBlumShub.generateN(bitsize, r);

        // now get a seed
        byte[] seed = new byte[bitsize/8];
        r.nextBytes(seed);

        // now create an instance of BlumBlumShub
        BlumBlumShub bbs = new BlumBlumShub(nval, seed);

        // and do something
        System.out.println("Generating 10 bytes");
        for (int i = 0; i < 10; ++i) {
            System.out.println(bbs.next(128));
        }
    }

    static String convertToBinary(int no){
        int container[] = new int[4096];
        int i = 0;
        while (no > 0){
            container[i] = no%2;
            i++;
            no = no/2;
        }
        System.out.println(i);
        String result = "";
        for (int j = i -1 ; j >= 0 ; j--){
            result = result.concat(Integer.toString((container[j])));
        }
        return result;
    }

}
