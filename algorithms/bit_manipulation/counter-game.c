//https://www.hackerrank.com/challenges/counter-game
#include <stdio.h>

const char* P0 = "Louise";
const char* P1 = "Richard";

int main() {
    short T;
    short winner;
    unsigned long N;
    
    //For each test case...
    scanf("%hd\n", &T);
    while (T-- > 0){
        
        //Get input
        scanf("%lu\n", &N);
        
        //Set initial winner
        winner = 1;
        
        //Remove powers of two and toggle winner
        while((N & 1) == 0){
            winner ^= 1;
            N >>= 1UL;
        }
        
        //Don't count remaining 1
        --N;
        
        //Remove biggest powers of two (read: count set bits) and toggle winner
        while (N > 0UL){
            winner ^= 1;
            N &= (N - 1UL);
        }
        
        //Print output
        printf("%s\n", (winner == 0) ? P0 : P1);
    }
    
    return 0;
}
