#include <iostream>
#include <algorithm>

using namespace std;

int small[10];

int main()
{
    int sum = 0, tSum = 0;
    for (int i = 0; i < 9; i++) {
        cin >> small[i];
        sum += small[i];
    }
    tSum = sum;
    for (int i = 0; i < 9; i++) {
        for (int j = i + 1; j < 9; j++) {
            tSum -= small[i];
            tSum -= small[j];
            if (tSum == 100) {
                small[i] = 101;
                small[j] = 101;
                sort(small, small + 9);
                for (int k = 0; k < 7; k++)
                    cout << small[k] << endl;
                return 0;
            }
            tSum = sum;
        }
    }

    return 0;
}
