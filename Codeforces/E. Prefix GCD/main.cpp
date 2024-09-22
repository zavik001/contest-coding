#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    while (t--)
    {
        int n;
        cin >> n;
        vector<int> a(n);
        for (int i = 0; i < n; ++i)
        {
            cin >> a[i];
        }

        int d = 0;
        for (int ai : a)
        {
            d = gcd(ai, d);
        }

        int cur = 0;
        int ans = 0;

        while (!a.empty() && cur != d)
        {
            auto it = min_element(a.begin(), a.end(), [&cur](int ai1, int ai2)
                                  { return gcd(ai1, cur) < gcd(ai2, cur); });

            cur = gcd(*it, cur);
            ans += cur;

            a.erase(it);
        }

        cout << (a.size() * d + ans) << endl;
    }

    return 0;
}
