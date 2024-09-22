#include <bits/stdc++.h>
using namespace std;

int query(const string& s) {
    cout << "? " << s << endl;
    int response;
    cin >> response;
    return response;
}

int main() {
    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;

        string s = "";
        bool end = false;

        while (s.length() < n) {
            if (end) {
                if (query("0" + s)) {
                    s = "0" + s;
                } else {
                    s = "1" + s;
                }
                continue;
            }

            if (query(s + "0")) {
                s += "0";
            }
            else if (s.empty() || query(s + "1")) {
                s += "1";
            } else {
                end = true;
                continue;
            }
        }

        cout << "! " << s << endl;
    }

    return 0;
}
