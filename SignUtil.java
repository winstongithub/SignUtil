/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: SignUtil
 * Author:   Pactera
 * Date:     2018/5/14 21:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package test;

import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Pactera
 * @create 2018/5/14
 * @since 1.0.0
 */
public class SignUtil {

    public static String encryptSign(Map<String, String> map,String APP_SECRET) {
        String signStr = "";
        try {
            //签名数据
            signStr += APP_SECRET;
            if (map == null) {
                return null;
            }

            //所有参数按照字母想顺序排序
            Set<String> keySet = sortMapKey(map);

            //循环生成签名数据值
            for (String key : keySet) {
                signStr += key + map.get(key);
            }
            signStr += APP_SECRET;

            //签名用md5编码
            signStr = DMD5.md5Encode(signStr);
            //转换为大写
            signStr = signStr.toUpperCase();
        } catch (Exception e) {

        }
        return signStr;
    }

    //所有参数按照字母想顺序排序
    private static Set sortMapKey(Map map) {
        Set keySet = map.keySet();
        List list = new ArrayList(map.keySet());

        Collections.sort(list, new Comparator() {
            public int compare(Object a, Object b) {
                return a.toString().toLowerCase().compareTo(b.toString()
                        .toLowerCase());
            }
        });
        keySet = new TreeSet(list);
        return keySet;
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("hotelId", "2000303");
        // map.put("hotelId", "2000014");

        // String signStr = SignUtil.encryptSign(map,"R8C36C45EH76OP7F9RMJ5KYDD7R0IV8P");
        String signStr = SignUtil.encryptSign(map,"V8C37E33DEFDE51IF91E1E03E51657DP");
        System.out.println(signStr);

        Map<String,String> map1 = new HashMap<>();
        map1.put("memberId", "030999810");
        map1.put("resNo","R20110720000078211");
        List<Integer> goodsIdList = new ArrayList<>();
        goodsIdList.add(1);
        goodsIdList.add(2);
        goodsIdList.add(3);
        String goodsIdListStr = "";
        for(Integer goodsId : goodsIdList){
            goodsIdListStr += goodsId;
        }
        map1.put("goodsIdList",goodsIdListStr);

        String signStr1 = SignUtil.encryptSign(map1,"V8C37E33DEFDE51IF91E1E03E51657DP");
        System.out.println(signStr1);

        Map<String,String> map2 = new HashMap<>();
        map2.put("year","2017");
        map2.put("month","4");
        map2.put("orgType","4");
        String signStr2 = SignUtil.encryptSign(map2,"V8C37E33DEFDE51IF91E1E03E51657DP");
        System.out.println(signStr2);

    }



}