#include <iostream>
#include <string.h>

using namespace std;

int main()
{
    int n, r, l;
    long long int mod = 1000000007;

    cin >> n >> l >> r;
    long long int ***dp = new long long int**[n + 2];
    for (int i = 0; i <= n + 1; i++) {
        dp[i] = new long long int*[n + 2];
        for (int j = 0; j <= n + 1; j++) {
            dp[i][j] = new long long int[n + 2];
        }
    }
    for (int i = 0; i <= n + 1; i++) {
        for (int j = 0; j <= n + 1; j++) {
            for (int k = 0; k <= n + 1; k++) {
                dp[i][j][k] = 0;
            }
        }
    }


    dp[1][1][1] = 1;
    dp[2][2][1] = 1;
    dp[2][1][2] = 1;
    for (int i = 3; i <= n; i++) {
        for (int j = 1; j <= l; j++) {
            for (int k = 1; k <= r; k++) {
                dp[i][j][k] += dp[i - 1][j - 1][k];
                dp[i][j][k] %= mod;
                dp[i][j][k] += dp[i - 1][j][k - 1];
                dp[i][j][k] %= mod;
                dp[i][j][k] += dp[i - 1][j][k] * (i - 2);
                dp[i][j][k] %= mod;
            }
        }
    }

    cout << dp[n][l][r] % mod << endl;
    return 0;
}
