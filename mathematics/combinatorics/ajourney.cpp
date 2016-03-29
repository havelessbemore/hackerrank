//https://www.hackerrank.com/challenges/ajourney
#include<bits/stdc++.h>
#define base2To10 0.30102999566398119521373889472449L
#define base10To2 3.32192809488736234787031942948939L
using namespace std;

unsigned int modPow(unsigned int b, unsigned int p, unsigned int mod){
    long long int c;
    if (p < 2){
        return p < 1 ? 1 : b%mod;
    }
    c = modPow(b, p/2, mod);
    c = (c*c)%mod;
    return (p&1) == 0 ? c : (c*b)%mod;
}
int main() {
    unsigned short T;
    long double N, K, exp;
    unsigned int upper, lower;
    cin >> T;
    while (T-- > 0){
        cin >> N >> K;
        exp = base10To2*(K-1.0L-floor((N-1)*base2To10))+N-1.0L;
        upper = pow(2.0L, exp);
        lower = modPow(2, N-1, pow(10, K));
        cout << (upper + lower) << endl;
    }
    return 0;
}