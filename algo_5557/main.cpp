#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int last, s = 0;
int in[101];
long long int dp[101][21];

int main()
{
    cin >> s;
    for (int i = 0; i < s; i++) {
        scanf("%d", &in[i]);
    }
    for (int i = 0; i < 101; i++)
        for (int j = 0; j < 21; j++)
            dp[i][j] = 0;

    last = in[s - 1];
    dp[0][in[0]] = 1;
    for (int i = 0; i < s - 2; i++) {
        for (int j = 0; j <= 20; j++) {
            if (dp[i][j] != 0 && j + in[i + 1] <= 20)
                dp[i + 1][j + in[i + 1]] += dp[i][j];
            if (dp[i][j] != 0 && j - in[i + 1] >= 0)
                dp[i + 1][j - in[i + 1]] += dp[i][j];
        }
    }

    cout << dp[s - 2][last] << endl;
    return 0;
}
