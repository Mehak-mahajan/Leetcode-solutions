
class Solution {
    long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        // no equal parts mein divide hota equal no of even and odd exist even mein 0 index include hota n +1 

        long evenNo = (n + 1) / 2;
        long oddNo = n / 2 ;

        // even indices -> 0,,2,4,6,8 -> 5
        // odd indicies - > 2,3,5,7 -> 4 prime no 

        // instead of doing 5* 5*5.... tle very slow 

        long evenWays = power(5 , evenNo);
        long oddWays = power( 4 , oddNo);

        return (int)((evenWays * oddWays) % MOD);

    }

    private long power(long x , long n){
        // as here mod is given so we dont have any need to to handle the negative cases 
        
        // simple rule power find krne ka power even base ko multiply krne ki need nhi else x ko multiply krdo 

        // sq the base and reduce the power 

         long result = 1;

        while (n > 0) { // pwer greater 
            if (n % 2 == 1) {
                result = (result * x) % MOD;  /// when we multiply taki voh overflow nhi hojye hmesha mod 

                // each odd steps takes the current base
            }
            x = (x * x) % MOD;
            n = n / 2;
        }

        return result;

    }
}

// just do changes