#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;

        vector<int> a(n);
        for (int i = 0; i < n; ++i) {
            cin >> a[i];
        }

        while (m--) {
            char op;
            int l, r;
            cin >> op >> l >> r;

            int maxVal = INT_MIN;

            for (int i = 0; i < n; ++i) {
                if (a[i] >= l && a[i] <= r) {
                    if (op == '+') {
                        a[i]++;
                    } else if (op == '-') {
                        a[i]--;
                    }
                }
                maxVal = max(maxVal, a[i]);
            }

            cout << maxVal << " ";
        }
        cout << endl;
    }

    return 0;
}
