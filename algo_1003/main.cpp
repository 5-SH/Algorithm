#include <iostream>
#include <vector>
#include <utility>

using namespace std;

vector <pair<int, int> > dp(41, make_pair(-1, -1));

pair<int, int> fibonacci(int n) {
    if (dp[n].first != -1 && dp[n].second != -1) {
        return dp[n];
    }
    else {
        pair<int, int> temp1, temp2;
        temp1 = fibonacci(n - 1);
        temp2 = fibonacci(n - 2);
        dp[n] = make_pair(temp1.first + temp2.first, temp1.second + temp2.second);
        return dp[n];
    }
}

int main()
{
    int testCase, n;
    pair <int, int> result;
    cin >> testCase;

    dp[0].first = 1;
    dp[0].second = 0;
    dp[1].first = 0;
    dp[1].second = 1;
    for (int i = 0;i < testCase; i++) {
        scanf("%d", &n);
        result = fibonacci(n);
        cout << result.first << " " << result.second << endl;
    }

    return 0;
}
