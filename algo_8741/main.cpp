#include <iostream>
#include <math.h>

using namespace std;

int main()
{
    int k;
    cin >> k;
    if (k == 1) {
        cout << "1";
        return 0;
    }

    for (int i = 0; i < k; i++) {
        cout << "1";
    }
    for (int i = 0; i < k - 1; i++) {
        cout << "0";
    }
    return 0;
}
