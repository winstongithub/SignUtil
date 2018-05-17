#pragma once
#include<string>
#include <map>
#include <iostream>
#include <algorithm>
using namespace std;
struct CmpByKeyLength {
	__declspec(dllexport) bool operator()( string k1,  string k2) {
		transform(k1.begin(), k1.end(), k1.begin(), ::tolower);
		transform(k2.begin(), k2.end(), k2.begin(), ::tolower);
		return k1 < k2;
	}
};

__declspec(dllexport) string encryptSign(map<string, string, CmpByKeyLength>& smap, string & APP_SECRET);

