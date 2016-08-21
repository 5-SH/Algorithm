#include <iostream>
#include <string>
#include <cstring>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    string str1, str2;
    int size1 = 0, size2 = 0, cnt = 0;
    cin >> str1 >> str2;
    str1 = "0" + str1;
    str2 = "0" + str2;
    size1 = str1.size();
    size2 = str2.size();

    int **dp = new int*[size2];
    for (int i = 0; i < size2; i++) {
        dp[i] = new int[size1];
    }

    for (int i = 0; i < size2; i++) {
        for (int j = 0; j < size1; j++) {
            dp[i][j] = 0;
        }
    }

    for (int i = 1; i < size2; i++) {
        for (int j = 1; j < size1; j++) {
            if (str2[i] == str1[j]) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
                cnt = max(cnt, dp[i][j]);
            }
            else {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
                cnt = max(cnt, dp[i][j]);
            }
        }
    }

    for (int i = 0; i < size2; i++) {
        for (int j = 0; j < size1; j++) {
            cout << dp[i][j] << " ";
        }cout << endl;
    }

    cout << cnt << endl;

    return 0;
}
