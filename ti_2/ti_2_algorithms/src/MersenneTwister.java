

public class MersenneTwister {

    private int[] mt;
    private int index;
    public MersenneTwister(int N){
        this.mt = new int[N-1];
        this.index = N + 1;

    }

}



/*
*  // Create a length n array to store the state of the generator
 int[0..n-1] MT
 int index := n+1
 const int lower_mask = (1 << r) - 1 // That is, the binary number of r 1's
 const int upper_mask = lowest w bits of (not lower_mask)

 // Initialize the generator from a seed
 function seed_mt(int seed) {
     index := n
     MT[0] := seed
     for i from 1 to (n - 1) { // loop over each element
         MT[i] := lowest w bits of (f * (MT[i-1] xor (MT[i-1] >> (w-2))) + i)
     }
 }

 // Extract a tempered value based on MT[index]
 // calling twist() every n numbers
 function extract_number() {
     if index >= n {
         if index > n {
           error "Generator was never seeded"
           // Alternatively, seed with constant value; 5489 is used in reference C code[46]
         }
         twist()
     }

     int y := MT[index]
     y := y xor ((y >> u) and d)
     y := y xor ((y << s) and b)
     y := y xor ((y << t) and c)
     y := y xor (y >> l)

     index := index + 1
     return lowest w bits of (y)
 }

 // Generate the next n values from the series x_i
 function twist() {
     for i from 0 to (n-1) {
         int x := (MT[i] and upper_mask)
                   + (MT[(i+1) mod n] and lower_mask)
         int xA := x >> 1
         if (x mod 2) != 0 { // lowest bit of x is 1
             xA := xA xor a
         }
         MT[i] := MT[(i + m) mod n] xor xA
     }
     index := 0
 }

* */