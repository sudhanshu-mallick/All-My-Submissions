#include <bits/stdc++.h>

#define forn(i, n) for (int i = 0; i < int(n); i++)

using namespace std;

int calc(const vector<int> &a, const vector<int> &b){
    int n = a.size();
    int m = b.size();
    vector<int> c(n), res;
    vector<int> su(n + 1);
    int r = m - 1;
    for (int i = n - 1; i >= 0; --i){
        su[i] = su[i + 1];
        while (r >= 0 && b[r] > a[i]) --r;
        if (r >= 0 && b[r] == a[i]) ++su[i];
    }
    int ans = 0;
    int j = 0;
    r = 0;
    forn(l, m){
        while (j < n && a[j] <= b[l] + j) ++j;
        while (r < m && b[r] - b[l] < j) ++r;
        ans = max(ans, r - l + su[j]);
    }
    return ans;
}

int main() {
    int t;
    scanf("%d", &t);
    forn(_, t){
        int n, m;
        scanf("%d%d", &n, &m);
        vector<int> a(n), b(m);
        forn(i, n) scanf("%d", &a[i]);
        forn(i, m) scanf("%d", &b[i]);
        vector<int> al, bl, ar, br;
        forn(i, n){
            if (a[i] < 0) al.push_back(-a[i]);
            else ar.push_back(a[i]);
        }
        forn(i, m){
            if (b[i] < 0) bl.push_back(-b[i]);
            else br.push_back(b[i]);
        }
        reverse(al.begin(), al.end());
        reverse(bl.begin(), bl.end());
        printf("%d\n", calc(al, bl) + calc(ar, br));
    }
    return 0;
}