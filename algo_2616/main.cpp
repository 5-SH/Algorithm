#include <iostream>
#include <algorithm>
#include <string.h>
#include <math.h>

using namespace std;

int dp[4][50001];
int train[50001];
int trainNum, carryNum;

int main()
{
    int ans = 0;
    cin >> trainNum;

    for (int i = 1; i <= trainNum; i++) {
        scanf("%d", &train[i]);
        train[i] = train[i] + train[i - 1];
    }
    cin >> carryNum;

    for (int i = 1; i <= 3; i++) {
        for (int j = i * carryNum; j <= trainNum; j++) {
            dp[i][j] = dp[i - 1][j - carryNum] + (train[j] - train[j - carryNum]);
            dp[i][j] = max(dp[i][j - 1], dp[i][j]);
        }
    }

    cout << dp[3][trainNum] << endl;
    return 0;
}
