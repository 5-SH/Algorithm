#include <iostream>
#include <vector>

using namespace std;

int p[101];
int n[101];
long long int dp[101][10001];

int main()
{
    int t, k;
    cin >> t >> k;
    for (int i = 1; i <= k; i++) {
        scanf("%d %d", &p[i], &n[i]);
    }
    dp[0][0] = 1;

    for (int i = 1; i <= k; i++) {
        for (int j = 0; j <= n[i]; j++) {
            for (int k = 0; k <= t; k++) {
                if (p[i] * j + k > t) break;
                dp[i][k + p[i] * j] += dp[i - 1][k];
            }
        }
    }

    cout << dp[k][t] << endl;

    return 0;
}
