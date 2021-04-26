#include <iostream>
#include <string>

using namespace std;

int alphabet1[27];
int alphabet2[27];

int main()
{
    int inSize;
    string inputStr1 ,inputStr2;
    cin >> inSize;
    for (int i = 0; i < 26; i++) {
        alphabet1[i] = alphabet2[i] = 0;
    }
    for (int i = 0; i < inSize; i++) {
        cin >> inputStr1 >> inputStr2;
        for (int i = 0; i < inputStr1.size(); i++) {
            alphabet1[inputStr1[i] - 97]++;
        }
        for (int i = 0; i < inputStr2.size(); i++) {
            alphabet2[inputStr2[i] - 97]++;
        }
        int match = 0;
        for (int i = 0; i < 26; i++) {
            if (alphabet1[i] == alphabet2[i])
                match++;
        }
        if (match == 26)
            cout << inputStr1 << " & " << inputStr2 << " are anagrams." << endl;
        else
            cout << inputStr1 << " & " << inputStr2 << " are NOT anagrams." << endl;
        for (int i = 0; i < 26; i++) {
            alphabet1[i] = alphabet2[i] = 0;
        }
    }
    return 0;
}
