#include "SignUtil.h"
#include "md5.h"
string encryptSign(map<string, string, CmpByKeyLength>& smap, string& APP_SECRET)
{
	string signStr = "";
	signStr += APP_SECRET;
	for (auto &iter : smap)
	{
		signStr += iter.first;
		signStr += iter.second;
	}
	signStr += APP_SECRET;
	string  md5 = MD5(signStr).toStr();
	transform(md5.begin(), md5.end(), md5.begin(), ::toupper);
	return md5;
}
