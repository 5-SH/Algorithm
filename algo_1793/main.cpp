#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

void longPlusFunc (string* longPlus) {
    int carry = 0, add = 0, i = 0;
    string temp = "";
    reverse(longPlus[0].begin(), longPlus[0].end());
    reverse(longPlus[1].begin(), longPlus[1].end());
    longPlus[2].reserve(longPlus[1].size() + 1);

    for (i = 0; i < longPlus[0].size(); i++) {
        add = (longPlus[0][i] - '0') + (longPlus[1][i] - '0');
        temp += ((add + carry) % 10) +'0';
        if (add + carry > 9) carry = 1;
        else carry = 0;
    }
    for (int j = i; j < longPlus[1].size(); j++) {
        longPlus[2][j] = longPlus[1][j];
    }
    longPlus[2] = temp;
    if (carry == 1) longPlus[2] += "1";
    reverse(longPlus[2].begin(), longPlus[2].end());
}

int main()
{
    int input;
    string longPlus[3];
    string dp[251];
    dp[0] = "1", dp[1] = "1", dp[2] = "3";

    for (int i = 3; i <= 250; i++) {
        longPlus[0] = dp[i - 2];
        longPlus[1] = dp[i - 2];
        longPlusFunc(longPlus);
        longPlus[0].clear(), longPlus[1].clear();

        if (longPlus[2].size() > dp[i - 1].size()) {
            longPlus[1] = longPlus[2];
            longPlus[0] = dp[i - 1];
        }
        else {
            longPlus[1] = dp[i - 1];
            longPlus[0] = longPlus[2];
        }
        longPlus[2].clear();
        longPlusFunc(longPlus);

        dp[i] = longPlus[2];
        longPlus[0].clear(), longPlus[1].clear(), longPlus[2].clear();
    }

    while (cin >> input) {
        cout << dp[input] << endl;
    }
    return 0;
}
