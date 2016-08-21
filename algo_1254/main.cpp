#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main()
{
    string str, rStr;
    int rSize,iSize, ans = 200001;

    cin >> str;
    iSize = str.size();

    if (iSize == 1) {
        cout << 1 << endl;
        return 0;
    }

    rStr = str;
    reverse(rStr.begin(), rStr.end());
    if (str.compare(rStr) == 0) {
        cout << str.size() << endl;
        return 0;
    }
    str += rStr.substr(0, rStr.size());
    rSize = rStr.size();
    rStr = str;

    for (int i = 0; i < rSize; i++) {
        if(str.compare(rStr) == 0) {
            int strSize = str.size();
            ans = min(ans, strSize);
        }

        str.erase(iSize, 1);
        rStr = str;
        reverse(rStr.begin(), rStr.end());
    }
    cout << ans << endl;

    return 0;
}
