#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int numArr[10000] = {0};
    int n, num;
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        scanf("%d", &num);
        numArr[num - 1]++;
    }

    for (int i = 0; i < 10000; i++) {
        for (int j = 0; j < numArr[i]; j++) {
            printf("%d\n", i + 1);
        }
    }

    return 0;
}
