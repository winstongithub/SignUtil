/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: DMD5
 * Author:   Pactera
 * Date:     2018/5/14 21:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package test;

import java.security.MessageDigest;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Pactera
 * @create 2018/5/14
 * @since 1.0.0
 */
public class DMD5 {

    public static String md5Encode(String inStr) throws Exception {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }


}