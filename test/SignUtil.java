/**
 * Copyright (C), 2015-2018, XXX���޹�˾
 * FileName: SignUtil
 * Author:   Pactera
 * Date:     2018/5/14 21:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package test;

import java.util.*;

/**
 * ��һ�仰���ܼ�����<br> 
 * ����
 *
 * @author Pactera
 * @create 2018/5/14
 * @since 1.0.0
 */
public class SignUtil {

    public static String encryptSign(Map<String, String> map,String APP_SECRET) {
        String signStr = "";
        try {
            //ǩ������
            signStr += APP_SECRET;
            if (map == null) {
                return null;
            }

            //���в���������ĸ��˳������
            Set<String> keySet = sortMapKey(map);

            //ѭ������ǩ������ֵ
            for (String key : keySet) {
                signStr += key + map.get(key);
            }
            signStr += APP_SECRET;

            //ǩ����md5����
            signStr = DMD5.md5Encode(signStr);
            //ת��Ϊ��д
            signStr = signStr.toUpperCase();
        } catch (Exception e) {

        }
        return signStr;
    }

    //���в���������ĸ��˳������
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