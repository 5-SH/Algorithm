#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int main()
{
    int str1Size, str2Size, temp = 0;
    int** dp;
    string str1 = " ", str2 = " ", buffer;

    cin >> buffer;
    str1Size = buffer.size();
    str1.append(buffer);
    buffer.clear();
    cin >> buffer;
    str2Size = buffer.size();
    str2.append(buffer);
    buffer.clear();

    dp = new int* [str2Size + 1];
    for (int i = 0; i < str2Size + 1; i++) {
        dp[i] = new int[str1Size + 1];
    }

    for (int i = 0; i < str2Size + 1; i++) {
        for (int j = 0; j < str1Size + 1; j++) {
            dp[i][j] = 0;
        }
    }

    for (int i = 1; i < str2Size + 1; i++) {
        for (int j = 1; j < str1Size + 1; j++) {
            if (str1[j] == str2[i]) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
                temp = max(dp[i][j], temp);
            }
        }
    }

    cout << temp << endl;

    return 0;
}
