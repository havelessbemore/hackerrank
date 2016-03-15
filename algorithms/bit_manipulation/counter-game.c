//https://www.hackerrank.com/challenges/counter-game
#include <stdio.h>

const char* P0 = "Louise";
const char* P1 = "Richard";

int main() {
    short T;
    short winner;
    unsigned long N;
    
    //FOR EACH TEST CASE
    scanf("%hd\n", &T);
    while (T-- > 0){
        scanf("%lu\n", &N);
        
        //SOLVE
        winner = 1;
        
        //Remove powers of two
        while((N & 1) == 0){
            winner ^= 1;
            N >>= 1UL;
        }
        
        //Don't count remaining 1
        --N;
        
        //Remove biggest powers of two (read: count set bits)
        while (N > 0UL){
            winner ^= 1;
            N &= (N - 1UL);
        }
        
        //OUTPUT
        printf("%s\n", (winner == 0) ? P0 : P1);
    }
    
    return 0;
}
