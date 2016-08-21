#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    int dp[1000];
    int haze[1000];
    int N;

    cin >> N;
    for (int i = 0; i < N; i++) {
        scanf("%d", &haze[i]);
    }
    for (int i = 0; i < N; i++) {
        dp[i] = 1001;
    }

    dp[0] = 0;
    for (int i = 0; i < N; i++) {
        for (int j = i + 1; j <= i + haze[i]; j++) {
            if (j < N) {
                dp[j] = min(dp[i] + 1, dp[j]);
            }
        }
    }

    if (dp[N - 1] == 1001) cout << "-1" << endl;
    else cout << dp[N - 1] << endl;

    return 0;
}
