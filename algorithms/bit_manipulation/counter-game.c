//https://www.hackerrank.com/challenges/counter-game
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

short logTwo(unsigned long);

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
        while (N > 1L){
            winner ^= 1;
            N -= 1UL << logTwo(N - 1UL);
        }
        
        //OUTPUT
        printf("%s\n", (winner == 0) ? P0 : P1);
    }
    
    return 0;
}

short logTwo(unsigned long n){
    short maxBit = -1;
    while (n > 0){
        n >>= 1;
        ++maxBit;
    }
    return maxBit;
}
