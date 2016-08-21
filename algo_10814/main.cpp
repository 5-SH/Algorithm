#include <iostream>
#include <tuple>
#include <algorithm>

using namespace std;

typedef tuple<int, int, string> member;

bool cmpFunc(member memA, member memB) {
    if (get<1>(memA) == get<1>(memB)) {
        return (get<0>(memA) < get<0>(memB));
    }
    return (get<1>(memA) < get<1>(memB));
}

int main()
{
    int memNum, memAge;
    string memName;
    cin >> memNum;

    member* memArr = new member[memNum];

    for (int i = 0; i < memNum; i++) {
        cin >> memAge >> memName;
        memArr[i] = make_tuple(i, memAge, memName);
    }

    sort(memArr, memArr+memNum, cmpFunc);

    int a, b;
    string c;
    for (int i = 0; i < memNum; i++) {
        cout << get<1>(memArr[i]) << " " << get<2>(memArr[i]);
        printf("\n");
    }

    return 0;
}
