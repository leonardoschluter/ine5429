public class MultiplyWIthCarry {

    final long a = 0xffffda61L;
    long x = System.nanoTime() & 0xffffffffL;

    public int nextInt() {
        x = (a * (x & 0xffffffffL)) + (x >>> 32);
        return Math.abs((int) x);
    }

}
