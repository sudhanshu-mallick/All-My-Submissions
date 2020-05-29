#include <bits/stdc++.h>
using namespace std;

#define int long long
#define w(x) int x; cin >> x; while(x--)

void FIO(){
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

// 	#ifndef ONLINE_JUDGE
// 		freopen("input.txt", "r", stdin);
// 		freopen("output.txt", "w", stdout);
// 	#endif
}

struct rectangle{
	int len;
	int bre;
};

int32_t main() {
	FIO();
	
	int test;
	cin >> test;

	while(test-- > 0){
		long double a, b, c;
		cin >> a >> b >> c;

		int x = abs((c - a) / (a + b - 2 * c));
		long double v1 = abs(a - c);
		long double v2 = abs((a + b) / 2.0 - c);
		long double v3 = abs(((x + 1.0) * a + x * b) / (2.0 * x + 1.0) - c);
		long double v4 = abs(((x + 2.0) * a + (x + 1.0) * b) / (2.0 * x + 3.0) - c);

		if(v1 <= v2 && v1 <= v3 && v1 <= v4)
			cout << "1";
		else if(v2 <= v3 && v2 <= v4)
			cout << "2";
		else if(v3 <= v4)
			cout << (2 * x + 1);
		else
			cout << (2 * x + 3);

		cout << "\n";
	}
		
}