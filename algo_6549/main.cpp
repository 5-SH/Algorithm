#include <iostream>
#include <stack>
#include <algorithm>
#include <vector>

using namespace std;

int main()
{
    long long int hisArr[100001];
    long long int hisArea;
    vector<long long int> hisAreaVec;
    long long int temp = 0, hisArrSize = 0;
    stack<int> stk;

    while (1) {
        scanf("%d", &hisArrSize);
        if (hisArrSize == 0) {
            break;
        }

        for (int i = 0; i < hisArrSize; i++) {
            scanf("%lld", &hisArr[i]);
        }

        for (int i = 0; i < hisArrSize; i++) {
            while (!stk.empty() && hisArr[i] < hisArr[stk.top()]) {
                temp = stk.top();
                stk.pop();
                if (!stk.empty()) {
                    hisArea = max(hisArea, hisArr[temp] * (i - stk.top() - 1));
                }
                else {
                    hisArea = max(hisArea, hisArr[temp] * (i));
                }
            }
            stk.push(i);
        }

        while (!stk.empty()) {
            temp = stk.top();
            stk.pop();
            if (!stk.empty()) {
                    hisArea = max(hisArea, hisArr[temp] * (hisArrSize - stk.top() - 1));
            }
            else {
                hisArea = max(hisArea, hisArr[temp] * (hisArrSize));
            }
        }
        hisAreaVec.push_back(hisArea);
        hisArea = 0;
    }

    for (int i = 0; i < hisAreaVec.size(); i++) {
        printf("%lld\n", hisAreaVec.at(i));
    }

    return 0;
}

