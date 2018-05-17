#include <iostream>
#include "../SignUtil/SignUtil.h"
using namespace std;
//#pragma comment(lib,"SignUtil.lib")  

int main()
{
	map<string, string , CmpByKeyLength> tmap;
	tmap.insert(make_pair("HotelId", "2000303"));
	tmap.insert(make_pair("hotelIddaf", "2000303"));
	tmap.insert(make_pair("asafadasdasda", "2000303"));
	tmap.insert(make_pair("Asa", "2000303"));
	for (auto iter : tmap)
	{
		cout << iter.first << endl;
	}
	string b = "V8C37E33DEFDE51IF91E1E03E51657DP";
	string test = encryptSign(tmap, b);
	cout << test << endl;
}